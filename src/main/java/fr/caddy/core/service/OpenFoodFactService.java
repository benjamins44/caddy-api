package fr.caddy.core.service;

import feign.Param;
import feign.RequestLine;
import fr.caddy.common.bean.opendfoodfact.ProductOpenFoodFact;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "openFoodFactService", url= "https://fr.openfoodfacts.org/api/v0")
public interface OpenFoodFactService {

    @RequestMapping(method = RequestMethod.GET, value = "/produit/{id}.json")
    ProductOpenFoodFact getById(@Param("id") Long id);
}
