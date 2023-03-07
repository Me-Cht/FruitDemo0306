package com.example.fruitdemo0306.utils;

import com.example.fruitdemo0306.bean.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FruitRepository extends JpaRepository <Fruit,Long> {
    List<Fruit> findAll();
}
