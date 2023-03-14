package com.example.fruitdemo0306.repository;

import com.example.fruitdemo0306.bean.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<UserLogin, Long> {
    UserLogin findByName(String name);
    UserLogin findByNameAndPassword(String name ,String password);

}
