package fr.caddy.core.service;

import fr.caddy.common.bean.opendfoodfact.ProductOpenFoodFact;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "openFoodFactService", url= "https://fr.openfoodfacts.org/api/v0")

public interface OpenFoodFactService  {

    @RequestMapping(method = RequestMethod.GET,
            value = "/produit/{id}.json",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    ProductOpenFoodFact getById(@PathVariable("id") Long id);
}
