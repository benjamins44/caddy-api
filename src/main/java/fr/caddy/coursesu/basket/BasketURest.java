package fr.caddy.coursesu.basket;

import fr.caddy.common.bean.BasketPurchase;
import fr.caddy.common.bean.User;
import fr.caddy.core.dao.UserDao;
import fr.caddy.coursesu.basket.service.BasketUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("basketU")
public class BasketURest {

    @Autowired
    private BasketUService basketUService;

    @Autowired
    private UserDao userDao;

    @PostMapping("/basketPurchases")
    public void purchases(@RequestBody List<BasketPurchase> basketPurchases) {
        final User user = userDao.findByLogin("bcorre");
        String customer = user.getLoginCoursesU();
        String password = user.getPasswordCoursesU();
        basketUService.basket(basketPurchases, customer, password);
    }
}
