package fr.caddy.core;

import fr.caddy.common.bean.ProductInstance;
import fr.caddy.core.service.ProductInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("productInstances")
public class ProductsInstanceRest {

    private static final Logger LOG = Logger.getLogger(ProductsInstanceRest.class.getName());

    @Autowired
    private ProductInstanceService productInstanceService;

    @GetMapping
    public List<ProductInstance> get() {
        return productInstanceService.getAll();

    }
    @RequestMapping(value="query", method = RequestMethod.GET)
    public List<ProductInstance> getByLabeLike(@RequestParam("label") String label) {
        return productInstanceService.getByLabeLike(label);

    }
    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public ProductInstance getById(@PathVariable("id") Long id) {
        return productInstanceService.getById(id);
    }

    @RequestMapping(value="{id}/query", method = RequestMethod.GET)
    public ProductInstance getById(@PathVariable("id") Long id, @RequestParam("refresh") Boolean refresh, @RequestParam("ean") Long ean) {
        ProductInstance productInstance = productInstanceService.getById(id);
        if (refresh) {
            productInstance.setOpenFoodFactId(ean);
            productInstanceService.refresh(productInstance);
        }
        return productInstance;
    }

    @RequestMapping(value="{id}", method = RequestMethod.PUT)
    public ProductInstance update(@PathVariable("id") Long id, @RequestBody ProductInstance productInstance) {
        productInstance.setId(id);
        return productInstanceService.update(productInstance);
    }
    @RequestMapping(method = RequestMethod.POST)
    public ProductInstance create(@RequestBody ProductInstance productInstance) {
        return productInstanceService.create(productInstance);
    }
    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id, @RequestBody ProductInstance productInstance) {
        productInstance.setId(id);
        productInstanceService.delete(productInstance);
    }

}