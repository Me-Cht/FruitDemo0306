package com.example.fruitdemo0306.controller;

import com.example.fruitdemo0306.bean.Fruit;
import com.example.fruitdemo0306.utils.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/product")
public class FruitController {

    @Autowired
    private FruitRepository fruitRepository;

    @GetMapping("/findAll")
    public List<Fruit> getAllFruits(){
        return fruitRepository.findAll();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFruit(@PathVariable Long id){
        Fruit fruit = fruitRepository.findById(id).orElse(null);
        if(fruit == null){
            return ResponseEntity.notFound().build();
        }else{
            fruitRepository.delete(fruit);
            return ResponseEntity.ok().build();
        }
    }
    @PutMapping("/update/{id}") //使用{id}作为路径参数。

    //声明changeFruitPrice方法，使用@PathVariable获取路径参数{id}，使用@RequestBody获取请求体中的JSON数据。
    public ResponseEntity<String> changeFruitPrice(@PathVariable("id") Long id, @RequestBody Map<String, Object> body) {
        //获取JSON数据中的newPrice，并将其转换为BigDecimal类型。
        BigDecimal newPrice = new BigDecimal(body.get("newPrice").toString());
        //调用FruitRepository的updatePriceById方法，更新水果的价格。
        int result = fruitRepository.updatePriceById(id, newPrice);
        //如果更新失败，则返回状态码为404，响应消息为"Fruit not found."。
        if (result == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fruit not found.");
        }
        //更新成功后，返回状态码为200，响应消息为"Fruit price updated successfully."。
        return ResponseEntity.ok("Fruit price updated successfully.");
    }
    @PostMapping("/add")
    public Fruit addFruit(@RequestBody Fruit fruit){
        return fruitRepository.save(fruit);
    }

}
