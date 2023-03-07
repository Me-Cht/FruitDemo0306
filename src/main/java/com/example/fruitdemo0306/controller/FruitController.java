package com.example.fruitdemo0306.controller;

import com.example.fruitdemo0306.bean.Fruit;
import com.example.fruitdemo0306.utils.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/api/fruit")
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
            return ResponseEntity.ok().build();
        }
    }

}
