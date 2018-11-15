package fr.caddy.core;

import fr.caddy.common.bean.ProductsGrouping;
import fr.caddy.core.service.ProductsGroupingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("productsgrouping")
public class ProductsGroupingRest {

    private static final Logger LOG = Logger.getLogger(ProductsGroupingRest.class.getName());

    @Autowired
    private ProductsGroupingService productsGroupingService;

    @GetMapping
    public List<ProductsGrouping> get() {
        return productsGroupingService.getAll();
    }

    @RequestMapping(value="query", method = RequestMethod.GET)
    public Optional<ProductsGrouping> getByCategories(@RequestParam("categories") List<String> categories) {
        return productsGroupingService.getByCategories(categories);

    }
    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public ProductsGrouping getById(@PathVariable("id") Long id) {
        return productsGroupingService.getById(id);
    }

    @RequestMapping(value="{id}", method = RequestMethod.PUT)
    public ProductsGrouping update(@PathVariable("id") Long id, @RequestBody ProductsGrouping productsGrouping) {
        productsGrouping.setId(id);
        return productsGroupingService.update(productsGrouping);
    }
    @RequestMapping(method = RequestMethod.POST)
    public ProductsGrouping create(@RequestBody ProductsGrouping productsGrouping) {
        return productsGroupingService.create(productsGrouping);
    }

    @RequestMapping(value="auto", method = RequestMethod.GET)
    public void autoCreate() {
        productsGroupingService.autoCreateAll();
    }


    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id, @RequestBody ProductsGrouping productsGrouping) {
        productsGrouping.setId(id);
        productsGroupingService.delete(productsGrouping);
    }




}