package com.example.fruitdemo0306.Service;

import com.example.fruitdemo0306.bean.User;
import com.example.fruitdemo0306.bean.UserLogin;
import com.example.fruitdemo0306.repository.UserDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserDAO userDAO;
    @Override
    public UserLogin loginService(String name, String password) {
        UserLogin userlogin = userDAO.findByNameAndPassword(name, password);
        if(userlogin != null){
            userlogin.setPassword("");
        }
        return userlogin;



    }

    @Override
    public UserLogin registerService(UserLogin user) {
        if(userDAO.findByName(user.getName())!= null){
            return null;

        }else {
            UserLogin newuser = userDAO.save(user);
            if (newuser!=null){
                newuser.setPassword("");
            }
            return newuser;

        }
    }


}
