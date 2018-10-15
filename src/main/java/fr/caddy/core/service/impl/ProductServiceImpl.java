package fr.caddy.core.service.impl;

import fr.caddy.common.bean.*;
import fr.caddy.core.dao.CounterDao;
import fr.caddy.core.dao.ProductDao;
import fr.caddy.core.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CounterDao counterDao;

    /**
     * Return the product of the product instance
     * Save it if not exists
     * @param productInstance
     * @return
     */
    public Product getOrSave(ProductInstance productInstance, String customer) {
        // test to get it
        List<Product> products = productDao.findByIdProductInstance(productInstance.getId());
        Product product = null;
        if (products.size() > 0) {
            product = products.get(0);
        }
        if (product == null) {
            // create it
            product = new Product();
            product.setProductInstances(new ArrayList<>());
            product.setConsumption(new Consumption());
            product.getConsumption().setDayQuantity(new ArrayList<>());
            product.getConsumption().setMonth(new ArrayList<>());
            product.getConsumption().setWeeklyQuantity(new ArrayList<>());
            product.setCustomer(customer);
            // copy property
            BeanUtils.copyProperties(productInstance, product);
            // generate Id
            product.setId(counterDao.getNextSequence(Product.COLLECTION_NAME));
            // create product shop
            product.getProductInstances().add(productInstance);
            productInstance.setPriority(1);
            // save it
            productDao.save(product);
        } else {
            // refresh productInstance into product
            this.removeProductInstances(product, productInstance);
            product.getProductInstances().add(productInstance);
            product.setCustomer(customer);
            // save it
            productDao.save(product);
        }
        return product;
    }

    /**
     * Return the list of order of the list of history order
     * @param productInstances
     * @return
     */
    public List<Product> getOrSave(List<ProductInstance> productInstances, String customer) {
        List<Product> list = new ArrayList<Product>();
        for (ProductInstance productInstance: productInstances) {
            list.add(this.getOrSave(productInstance, customer));
        }
        return list;
    }

    /*
        Get all products of a customer
     */
    public List<Product> getAll(String customer) {
        return productDao.findByCustomer(customer);
    }

    public List<Product> getAll() {
        return productDao.findAll();
    }

    public void save(List<Product> products) {
        for (Product product: products) {
            this.productDao.save(product);
        }
    }

    /**
     * Refresh product instance of all products
     * @param productInstance
     */
    public void refreshProductInstance(ProductInstance productInstance) {
        List<Product> products = productDao.findByIdProductInstance(productInstance.getId());
        for (Product product: products) {
            // refresh productInstance into product
            this.removeProductInstances(product, productInstance);
            product.getProductInstances().add(productInstance);
            // save it
            productDao.save(product);
        }
    }

    /**
     * Calculate Consumptions with orders
     */
    public List<Product> calculateConsumptions(List<Order> orders) {
        final Map<Long, Product> productCalculate = new HashMap<>();
        for (Order order: orders) {
            for (ProductInstance productInstance : order.getProductInstances()) {
                List<Product> products = productDao.findByOrderIdAndProductInstance(order.getId(), productInstance.getId());
                if (products.isEmpty()) {
                    // order is not in productInstance
                    Product product = productCalculate.get(productInstance.getId());
                    if (product == null) {
                        product = this.getOrSave(productInstance, order.getCustomer());
                    }
                    // add dayQuantity
                    final DayQuantity dayQuantity = new DayQuantity();
                    dayQuantity.setDay(order.getDate());
                    dayQuantity.setOrderId(order.getId());
                    dayQuantity.setQuantity(productInstance.getQuantity());
                    dayQuantity.setSign(order.getSign());

                    product.getConsumption().getDayQuantity().add(dayQuantity);
                    productCalculate.put(productInstance.getId(), product);
                }
            }
        }
        // calculate weeklyQuantity
        for (Product product: productCalculate.values()) {
            final Map<Integer, Map<Integer, Float>> mapWeeklyQuantity = new HashMap<>();
            WeekFields weekFields = WeekFields.of(Locale.getDefault());
            for (DayQuantity dayQuantity : product.getConsumption().getDayQuantity()) {
                final Integer week = dayQuantity.getDay().get(weekFields.weekOfWeekBasedYear());
                final Integer year = dayQuantity.getDay().getYear();

                Map<Integer, Float> mapWeek = mapWeeklyQuantity.get(year);
                if (mapWeek == null) {
                    mapWeek = new HashMap<>();
                    mapWeeklyQuantity.put(year, mapWeek);
                }


                Float quantity = mapWeek.get(week);
                if (quantity == null) {
                    quantity = 0F;
                }
                quantity += dayQuantity.getQuantity();
                mapWeek.put(week, quantity);
            }
            final List<WeeklyQuantity> newWeekliesQuantity = new ArrayList<>();
            for (Integer year: mapWeeklyQuantity.keySet()) {
                for (Integer week: mapWeeklyQuantity.get(year).keySet()) {
                    final WeeklyQuantity weeklyQuantity = new WeeklyQuantity();
                    weeklyQuantity.setYear(year);
                    weeklyQuantity.setWeek(week);
                    weeklyQuantity.setQuantity(mapWeeklyQuantity.get(year).get(week));
                    newWeekliesQuantity.add(weeklyQuantity);
                }
            }
            product.getConsumption().setWeeklyQuantity(newWeekliesQuantity);
            // save it
            productDao.save(product);
        }
        return productCalculate.values().stream().collect(Collectors.toList());
    }
    public void calculateAverage(List<Product> products) {
        for (Product product: products) {
            this.calculateAverage(product);
        }

    }
    public void calculateAverage(Product product) {

        final Integer count = product.getConsumption().getWeeklyQuantity().size();
        final List<Average> averages = new ArrayList<>();

        for (int i = Math.min(count, 5); i <= count; i += 5) {

            List<WeeklyQuantity> wq = product.getConsumption().getWeeklyQuantity().stream()
                    .sorted((wq1, wq2) -> {
                        return (wq1.getYear() * 1000 + wq1.getWeek()) - (wq2.getYear() * 1000 + wq2.getWeek());
                    })
                    .limit(i)
                    .collect(Collectors.toList());
            if (wq.size() == 0) {
                break;
            }
            final Integer startWeek = wq.get(0).getWeek();
            Integer iWq = 0;
            Float sum = 0.0F;
            List<Integer> spaceWeekBetween = new ArrayList<>();

            final Integer endWeek = wq.get(wq.size() - 1).getWeek();

            Integer lastWeek = startWeek;

            for (int cweek = startWeek; cweek <= endWeek; cweek = (cweek + 1) % 52) {
                if (cweek == wq.get(iWq).getWeek()) {
                    sum += wq.get(iWq).getQuantity();
                    if (iWq != 0) {
                        spaceWeekBetween.add((cweek + 52 - lastWeek) % 52);
                        lastWeek = cweek;
                    }
                    iWq++;
                }
            }

            final Average average = new Average();
            averages.add(average);
            average.setNbOccurences(i);
            average.setQuantity(sum / wq.size());
            Float sumSpace = 0.0F;
            for (Integer space: spaceWeekBetween) {
                sumSpace+=space;
            }
            average.setNbWeek(sumSpace / spaceWeekBetween.size());
        }
        product.getConsumption().setAverages(averages);
        // save it
        productDao.save(product);
    }

    public void calculateProbabilities(List<Product> products) {
        for (Product product: products) {
            this.calculateProbabilities(product);
        }
    }
    public void calculateProbabilities(Product product) {
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        final Integer currentWeek = LocalDate.now().get(weekFields.weekOfWeekBasedYear());
        final Integer currentYeay = LocalDate.now().getYear();
        final Optional<WeeklyQuantity> wq = product.getConsumption().getWeeklyQuantity().stream()
                .max((wq1, wq2) -> {
                    return (wq1.getYear() * 1000 + wq1.getWeek()) - (wq2.getYear() * 1000 + wq2.getWeek());
                })
                .map(weeklyQuantity -> weeklyQuantity);
        if (wq.isPresent()) {
            final Integer nbWeekLastBuy = (currentWeek + (currentYeay - wq.get().getYear()) * 52) - wq.get().getWeek();
            product.getConsumption().setNbWeekOfLastBuy(nbWeekLastBuy);
            // use only first average calculated on 5 occurencies
            final Average average = product.getConsumption().getAverages().get(0);
            Float probability = product.getConsumption().getNbWeekOfLastBuy() / average.getNbWeek();
            // if 6 x average of week < nb last week buy, or nb occurency < 3 , the product wiil be not buy, force it
            if (nbWeekLastBuy > average.getNbWeek() * 3 || average.getNbOccurences() < 3 || !ProductStatus.USED.equals(product.getStatus())) {
                probability = 0F;
            }
            product.getConsumption().setProbalilityBuy(probability);
            product.getConsumption().setProbalilityQuantityBuy(average.getQuantity());
            productDao.save(product);
        }
    }

    public Order prepareOrder(String customer) {
        // get all of the customers
        final List<Product> products = getAll(customer);
        final Order order = new Order();
        for (Product product: products) {
            final Float propability = product.getConsumption().getProbalilityBuy();
            // test with seuil 90%
            if (propability > 0.9F) {
                // add to the order the first product instance
                final ProductInstance productInstance = product.getProductInstances().get(0);
                // cast to int the quantity (pas de gestion des produits au poids)
                final Integer quantity = product.getConsumption().getProbalilityQuantityBuy().intValue();
                productInstance.setQuantity(quantity.floatValue());
                order.getProductInstances().add(productInstance);
            }
        }
        return order;
    }

    private void removeProductInstances(Product product, ProductInstance productInstance) {
        for (ProductInstance productInstanceCurrent : product.getProductInstances()) {
            if (productInstanceCurrent.getId().equals(productInstance.getId())) {
                product.getProductInstances().remove(productInstanceCurrent);
                return;
            }
        }
    }
}
