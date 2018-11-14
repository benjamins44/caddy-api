package fr.caddy.core.dao;

import fr.caddy.common.bean.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface OrderDao extends MongoRepository<Order, Long>, OrderCustomDao  {

    public List<Order> findByCustomer(String customer);

    public List<Order> findByCustomerAndDateGreaterThan(String customer, LocalDate date);

    public Order findByIdExtAndSign(Long idExt, String sign);

    public Order findFirstBySignAndCustomerOrderByIdExtDesc(String sign, String customer);

}
