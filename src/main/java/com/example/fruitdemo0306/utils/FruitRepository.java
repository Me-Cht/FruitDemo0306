package com.example.fruitdemo0306.utils;

import com.example.fruitdemo0306.bean.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface FruitRepository extends JpaRepository <Fruit,Long> {
    List<Fruit> findAll();

    @Transactional
    @Modifying  //指定该方法为执行修改操作
    @Query("UPDATE Fruit f SET f.price = :newPrice WHERE f.id = :id")
        //@Query注解的作用是指定该方法执行SQL语句，在此为更新水果价格。
    int updatePriceById(@Param("id") Long id, @Param("newPrice") BigDecimal newPrice);
}
