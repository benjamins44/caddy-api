package fr.caddy.core.dao;

import fr.caddy.common.bean.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDao extends MongoRepository<User, Long> {

    public User findByLoginCoursesU(String login);

    public User findByLogin(String login);
}
