package fr.caddy.core.dao;

import fr.caddy.common.bean.PreOrder;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface PreOrderDao extends MongoRepository<PreOrder, Long> {

    public List<PreOrder> findByCustomer(String customer);

    public List<PreOrder> findByCustomerAndDateGreaterThan(String customer, LocalDate date);

    public PreOrder findByIdExtAndSign(Long idExt, String sign);

    public PreOrder findFirstBySignAndCustomerOrderByIdExtDesc(String sign, String customer);

}
