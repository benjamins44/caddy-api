package fr.caddy.core.dao;

import fr.caddy.common.bean.OffCoursesU;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OffCoursesUDao extends MongoRepository<OffCoursesU, Long> {

    public List<OffCoursesU> findByIdCoursesU(Long id);

    public List<OffCoursesU> findByCode(String code);
}
