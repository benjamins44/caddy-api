package fr.caddy.coursesu.history;

import fr.caddy.common.bean.HistoryOrder;
import fr.caddy.common.bean.User;
import fr.caddy.core.dao.UserDao;
import fr.caddy.coursesu.history.service.HistoryUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("historyU")
public class HistoryURest {

    @Autowired
    private HistoryUService historyUservice;

    @Autowired
    private UserDao userDao;

    @RequestMapping("/extract/{orderId}")
    public void extract(final Long orderId) {

        final User user = userDao.findByLogin("bcorre");
        String customer = user.getLoginCoursesU();
        String password = user.getPasswordCoursesU();
        historyUservice.getNewHistory(customer, password, orderId);
    }

    @GetMapping("/orders/{customer}")
    public List<HistoryOrder> findAll(@PathVariable String customer) {
        return historyUservice.findAll(customer);
    }

    @GetMapping("/orders/{customer}/date/{date}")
    public List<HistoryOrder> findAll(@PathVariable String customer, @PathVariable String date) throws Exception {
        return historyUservice.findAllByDate(customer, date);
    }
}
