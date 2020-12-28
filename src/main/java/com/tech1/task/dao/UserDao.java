package com.tech1.task.dao;

import com.tech1.task.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao extends CrudRepository<User, Long> {

    Optional<User> findById(Long id);

    List<User> findByAgeGreaterThan(int age);


    @Query(value = "select distinct a.user.name from Article a group by  a.user.id having count(a.user.id) > 3 ")
    List<String> getUserNames();


}
