package fr.caddy.core.service;

import fr.caddy.common.bean.User;

import java.util.List;

public interface UserService {

    public List<User> getAll();

    public User getById(Long id);

    public User getByLogin(String login);

    public User update(User user);


    public User create(User user);
}
