package fr.caddy.core.dao;

import fr.caddy.common.bean.ProductInstance;

import java.util.List;

public interface ProductInstanceCustomDao {

    public List<ProductInstance> findByIdExtAndSign(Long idExt, String sign);

}
