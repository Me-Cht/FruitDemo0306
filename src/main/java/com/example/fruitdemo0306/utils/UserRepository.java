package com.example.fruitdemo0306.utils;

import com.example.fruitdemo0306.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @Author Hotan
 * @Date 2023/3/12 20:31
 * @PackageName:com.example.fruitdemo0306.utils
 * @ClassName: UserRepository
 * @Description: TODO
 * @Version 1.0
 */
public interface UserRepository extends JpaRepository <User,Long>, JpaSpecificationExecutor<User> {
    List<User> findAll();

}
