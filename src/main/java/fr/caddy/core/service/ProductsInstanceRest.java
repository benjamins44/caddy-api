package fr.caddy.core.service;

import fr.caddy.common.bean.ProductInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
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
}