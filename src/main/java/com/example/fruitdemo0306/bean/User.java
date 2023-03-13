package com.example.fruitdemo0306.bean;
/**
 * @Author Hotan
 * @Date 2023/3/12 10:21
 * @PackageName:com.example.fruitdemo0306.bean
 * @ClassName: User
 * @Description: TODO
 * @Version 1.0
 */

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author: Hotan
 * @Project: BigData-MovieRecommender
 * @Pcakage: com.example.fruitdemo0306.bean.User
 * @Date: 2023年03月12日 10:21
 * @Description:
 */
@Entity
public class User {
    @Id
    private int id;
    private String name;
    private String email;
    private Integer age;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}