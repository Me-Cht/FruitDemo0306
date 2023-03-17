package com.example.fruitdemo0306.controller;
/**
 * @Author Hotan
 * @Date 2023/3/12 20:29
 * @PackageName:com.example.fruitdemo0306.controller
 * @ClassName: UserController
 * @Description: TODO
 * @Version 1.0
 */

import com.example.fruitdemo0306.Service.UserService;
import com.example.fruitdemo0306.bean.User;
import com.example.fruitdemo0306.bean.UserLogin;
import com.example.fruitdemo0306.utils.Result;
import com.example.fruitdemo0306.utils.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: Hotan
 * @Project: BigData-MovieRecommender
 * @Pcakage: com.example.fruitdemo0306.controller.UserController
 * @Date: 2023年03月12日 20:29
 * @Description:
 */
@RestController

@CrossOrigin
@RequestMapping("api/user")
public class UserController {
    @Resource
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getAllData")
    public List<User> getAllData(){
        return userRepository.findAll();
    }
    @RequestMapping("/login")
    public Result<UserLogin> loginController(@RequestBody UserLogin user) {
        String name = user.getName();
        String password = user.getPassword();
        UserLogin userLogin = userService.loginService(name, password);
        if (userLogin != null) {
            return Result.success(userLogin, "登录成功！");
        } else {
            return Result.error("10000", "密码错误！");
        }
    }






}