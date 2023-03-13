package com.example.fruitdemo0306.controller;
/**
 * @Author Hotan
 * @Date 2023/3/12 20:29
 * @PackageName:com.example.fruitdemo0306.controller
 * @ClassName: UserController
 * @Description: TODO
 * @Version 1.0
 */

import com.example.fruitdemo0306.bean.User;
import com.example.fruitdemo0306.utils.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Hotan
 * @Project: BigData-MovieRecommender
 * @Pcakage: com.example.fruitdemo0306.controller.UserController
 * @Date: 2023年03月12日 20:29
 * @Description:
 */
@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getAllData")
    public List<User> getAllData(){
        return userRepository.findAll();
    }



}