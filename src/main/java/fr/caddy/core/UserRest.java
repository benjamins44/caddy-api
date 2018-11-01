package fr.caddy.core;

import fr.caddy.common.bean.*;
import fr.caddy.core.dao.UserDao;
import fr.caddy.core.service.PreOrderService;
import fr.caddy.core.service.UserService;
import fr.caddy.coursesu.basket.service.BasketUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("users")
public class UserRest {

    private static final Logger LOG = Logger.getLogger(UserRest.class.getName());


    @Autowired
    private UserService userService;


    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public User get(@PathVariable("id") Long id) {
        return userService.getById(id);
    }


    @RequestMapping(value="", method = RequestMethod.GET)
    public List<User> getAll() {
        return userService.getAll();
    }

    @RequestMapping(value="{id}", method = RequestMethod.PUT)
    public User update(@PathVariable("id") Long id, @RequestBody User user) {
        return userService.update(user);
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public User create( @RequestBody User user) {
        return userService.create(user);
    }
}