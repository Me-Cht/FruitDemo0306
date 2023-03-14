package com.example.fruitdemo0306.Service;

import com.example.fruitdemo0306.bean.User;
import com.example.fruitdemo0306.bean.UserLogin;

public interface UserService {

    UserLogin loginService(String name,String password);
    UserLogin registerService(UserLogin user);
}
