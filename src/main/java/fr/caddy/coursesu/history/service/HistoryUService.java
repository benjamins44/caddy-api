package fr.caddy.coursesu.history.service;

import fr.caddy.common.bean.HistoryOrder;

import java.time.LocalDate;
import java.util.List;

public interface HistoryUService {

    public List<HistoryOrder> getNewHistory(final String login, final String password, final Long lastOrder);

    public List<HistoryOrder> findAll(String customer);

    public List<HistoryOrder> findAllByDate(String customer, LocalDate date);

    public List<HistoryOrder> findAllByDate(String customer, String date) throws Exception;

}
