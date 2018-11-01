package fr.caddy.core;

import fr.caddy.common.bean.Product;
import fr.caddy.common.constants.Constants;
import fr.caddy.core.service.ProductInstanceService;
import fr.caddy.core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("products")
public class ProductsRest {

    private static final Logger LOG = Logger.getLogger(ProductsRest.class.getName());

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductInstanceService productInstanceService;

    @GetMapping
    public List<Product> get() {
        return productService.getAll();
    }

    @RequestMapping(value="query", method = RequestMethod.GET)
    public List<Product> getByLabeLike(@RequestParam("label") String label) {
        return productService.getByLabelLike(label);

    }
    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public Product getById(@PathVariable("id") Long id) {
        return productService.getById(id);
    }

    @RequestMapping(value="{id}", method = RequestMethod.PUT)
    public Product update(@PathVariable("id") Long id, @RequestBody Product product) {
        product.setId(id);
        return productService.update(product);
    }
    @RequestMapping(method = RequestMethod.POST)
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id, @RequestBody Product product) {
        product.setId(id);
        productService.delete(product);
    }

    @RequestMapping(value="refresh", method = RequestMethod.GET)
    public void refresh() {
        List<Product> products = this.get();
        for (Product product: products) {
            productInstanceService.refresh(product.getProductInstances().get(0));
            productService.getOrSave(product.getProductInstances().get(0), Constants.SIGN_U);
        }
    }

    @RequestMapping(value="stats", method = RequestMethod.GET)
    public List<Product> stats() {
        List<Product> products = this.get();
        productService.calculateConsumptions(products);
        productService.calculateProbabilities(products);
        return products;
    }

}