package com.example.fruitdemo0306.bean;
/**
 * @Author Hotan
 * @Date 2023/3/12 21:18
 * @PackageName:com.example.fruitdemo0306.bean
 * @ClassName: UserLogin
 * @Description: TODO
 * @Version 1.0
 */

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author: Hotan
 * @Project: BigData-MovieRecommender
 * @Pcakage: com.example.fruitdemo0306.bean.UserLogin
 * @Date: 2023年03月12日 21:18
 * @Description:
 */
@Entity
public class UserLogin {
    @Id
    private int id;
    private String name;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}