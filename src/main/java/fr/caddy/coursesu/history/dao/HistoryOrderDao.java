package fr.caddy.coursesu.history.dao;

import fr.caddy.common.bean.HistoryOrder;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface HistoryOrderDao extends MongoRepository<HistoryOrder, Long> {

    public List<HistoryOrder> findByCustomer(String customer);

    public List<HistoryOrder> findByCustomerAndDateGreaterThan(String customer, LocalDate date);

}
