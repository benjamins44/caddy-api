package fr.caddy.core.service.impl;

import fr.caddy.common.bean.*;
import fr.caddy.common.helpers.UtilsHelper;
import fr.caddy.core.dao.CounterDao;
import fr.caddy.core.dao.ProductDao;
import fr.caddy.core.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.NumberFormat;
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

    public static final Float PERCENT_TO_ORDER = 0.9F;

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
            // set default image
            if (StringUtils.isEmpty(product.getImage())) {
                product.setImage(productInstance.getImage());
            }
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

    @Override
    public List<Product> getByLabelLike(String label) {
        return productDao.findByLabelContainingIgnoreCase(label);
    }

    @Override
    public Product getById(Long id) {
        return this.productDao.findById(id).get();
    }

    @Override
    public Product update(Product product) {
        return this.productDao.save(product);
    }

    @Override
    public Product create(Product product) {
        // generate id
        product.setId(counterDao.getNextSequence(Product.COLLECTION_NAME));
        return this.productDao.save(product);
    }

    @Override
    public void delete(Product product) {
        this.productDao.delete(product);
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
    public List<Product> calculateConsumptionsOfOrders(List<Order> orders) {
        final Map<Long, Product> productCalculate = new HashMap<>();
        for (Order order: orders) {
            for (Product product : order.getProducts()) {
                List<Product> products = productDao.findByOrderIdAndProduct(order.getId(), product.getId());
                if (products.isEmpty()) {
                    // add dayQuantity
                    final DayQuantity dayQuantity = new DayQuantity();
                    dayQuantity.setDay(order.getDate());
                    dayQuantity.setOrderId(order.getId());
                    dayQuantity.setQuantity(product.getQuantity());
                    dayQuantity.setSign(order.getSign());

                    final Product aProduct = productCalculate.get(product.getId());
                    if (aProduct != null) {
                        product = aProduct;
                    }

                    product.getConsumption().getDayQuantity().add(dayQuantity);
                    productCalculate.put(product.getId(), product);
                }
            }
        }
        return this.calculateConsumptions(productCalculate.values().stream().collect(Collectors.toList()));
    }

    public List<Product> calculateConsumptions(List<Product> products) {
        // calculate weeklyQuantity
        for (Product product: products) {
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
        return products;
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
        product.setOrderStatus(ProductOrderStatus.NO_ORDER);
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        final Integer currentWeek = LocalDate.now().get(weekFields.weekOfWeekBasedYear());
        final Integer currentYeay = LocalDate.now().getYear();
        final Optional<WeeklyQuantity> wq = product.getConsumption().getWeeklyQuantity().stream()
                .max((wq1, wq2) -> {
                    return (wq1.getYear() * 1000 + wq1.getWeek()) - (wq2.getYear() * 1000 + wq2.getWeek());
                })
                .map(weeklyQuantity -> weeklyQuantity);
        Float probability = 0F;
        Float quantity = 0F;
        if (wq.isPresent()) {
            final Integer nbWeekLastBuy = (currentWeek + (currentYeay - wq.get().getYear()) * 52) - wq.get().getWeek();
            product.getConsumption().setNbWeekOfLastBuy(nbWeekLastBuy);
            // use only first average calculated on 5 occurencies
            final Average average = product.getConsumption().getAverages().get(0);
            if (average.getNbWeek() > 0) {
                probability = product.getConsumption().getNbWeekOfLastBuy() / average.getNbWeek();
                quantity = average.getQuantity();
            }
            // if 6 x average of week < nb last week buy, or nb occurency < 3 , the product wiil be not buy, force it
            if (nbWeekLastBuy > average.getNbWeek() * 3 || average.getNbOccurences() < 3 || !ProductStatus.USED.equals(product.getStatus())) {
                quantity = 0F;
                if (ProductStatus.ABANDONNED.equals(product.getStatus())) {
                    product.setOrderStatus(ProductOrderStatus.ABANDONNED);
                    probability = -3F;
                } else if (average.getNbOccurences() < 3 ) {
                    product.setOrderStatus(ProductOrderStatus.NOT_ENOUGH_ORDERED);
                    probability = -1F;
                } else {
                    product.setOrderStatus(ProductOrderStatus.NO_LONGER_PROPOSED);
                    probability = -2F;
                }
            }
            if (probability > PERCENT_TO_ORDER) {
                product.setOrderStatus(ProductOrderStatus.TO_ORDER);
            }
            if (probability > 1) {
                probability = 1F;
            }
        }
        product.getConsumption().setProbalilityBuy(UtilsHelper.castTwoDecimal(probability));
        product.getConsumption().setProbalilityQuantityBuy(UtilsHelper.castTwoDecimal(quantity));
        productDao.save(product);
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
