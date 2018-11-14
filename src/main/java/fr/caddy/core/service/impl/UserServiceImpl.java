package fr.caddy.core.service.impl;

import fr.caddy.common.bean.User;
import fr.caddy.core.dao.CounterDao;
import fr.caddy.core.dao.UserDao;
import fr.caddy.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG = Logger.getLogger(UserServiceImpl.class.getName());

    @Autowired
    private UserDao userDao;

    @Autowired
    private CounterDao counterDao;


    //private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Override
    public User getById(Long id) {
        final User user = userDao.findById(id).get();
        return user;
    }

    @Override
    public User getByLogin(String login) {
        final User user = userDao.findByLogin(login);
        System.out.println(user.getPasswordCoursesU());
        return user;
    }

    @Override
    public User update(User user) {
        //user.setPasswordCoursesU(bCryptPasswordEncoder.encode(user.getPasswordCoursesU()));
        System.out.println(user.getPasswordCoursesU());
        return userDao.save(user);
    }

    @Override
    public User create(User user) {
        user.setId(counterDao.getNextSequence(User.COLLECTION_NAME));
        //user.setPasswordCoursesU(bCryptPasswordEncoder.encode(user.getPasswordCoursesU()));
        return userDao.save(user);
    }

}
