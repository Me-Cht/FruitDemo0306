package com.example.fruitdemo0306.controller;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.fruitdemo0306.Service.FruitService;
import com.example.fruitdemo0306.bean.Fruit;
import com.example.fruitdemo0306.bean.FruitMapper;
import com.example.fruitdemo0306.utils.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/product")
public class FruitController {

    @Autowired
    private FruitRepository fruitRepository;
    @Autowired
    private FruitMapper fruitMapper;

    @Autowired
    FruitService fruitService;

    private static final Logger LOGGER = Logger.getLogger(FruitController.class.getName());

    @GetMapping("/findAll")
    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }

    @GetMapping("findById/{id}")
    public Optional<Fruit> getDetail(@PathVariable Long id) {
        return fruitRepository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFruit(@PathVariable Long id) {
        Fruit fruit = fruitRepository.findById(id).orElse(null);
        if (fruit == null) {
            return ResponseEntity.notFound().build();
        } else {
            fruitRepository.delete(fruit);
            return ResponseEntity.ok().build();
        }
    }

    @PutMapping("/update/{id}") //使用{id}作为路径参数。

    //声明changeFruitPrice方法，使用@PathVariable获取路径参数{id}，使用@RequestBody获取请求体中的JSON数据。
    public ResponseEntity<String> changeFruitPrice(@PathVariable("id") Long id, @RequestBody Map<String, Object> body) {
        //获取JSON数据中的newPrice，并将其转换为BigDecimal类型。
        Double price = new Double(body.get("price").toString());
        //调用FruitRepository的updatePriceById方法，更新水果的价格。
        int result = fruitRepository.updatePriceById(id, price);
        //如果更新失败，则返回状态码为404，响应消息为"Fruit not found."。
        if (result == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fruit not found.");
        }
        //更新成功后，返回状态码为200，响应消息为"Fruit price updated successfully."。
        return ResponseEntity.ok("Fruit price updated successfully.");
    }

    @PostMapping("/add")
    public Fruit addFruit(@RequestBody Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Fruit>> getFruits(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice
    ) {
        LOGGER.log(Level.INFO, "Received search request with name={0}, category={1}, minPrice={2}, maxPrice={3}",
                new Object[]{name, category, minPrice, maxPrice});
        List<Fruit> fruits = fruitRepository.findByPriceBetweenAndNameContainingAndCategoryContaining(
                minPrice != null ? minPrice : 0,
                maxPrice != null ? maxPrice : Double.MAX_VALUE,
                name != null ? name : "",
                category != null ? category : ""
        );

        return ResponseEntity.ok(fruits);
    }

    //        @RequestParam(required = false) String name,
//        @RequestParam(required = false) String category,
//        @RequestParam(required = false) Double minPrice,
//        @RequestParam(required = false) Double maxPrice

    //                name != null ? name:"",
//                category != null ? category:"",
//                minPrice!=null ? minPrice: Double.MAX_VALUE,
//                maxPrice != null ? maxPrice: Double.MAX_VALUE

    @GetMapping("/search")
    public ResponseEntity<List<Fruit>> getFName(@RequestBody(required = false) Map<String,Object> body){
        String name = Optional.ofNullable(body.get("name")).map(Object::toString).orElse("");
        String category = Optional.ofNullable(body.get("category")).map(Object::toString).orElse("");
        Double minPrice = Optional.ofNullable(body.get("minPrice")).map(Object::toString).map(Double::parseDouble).orElse(0.0);
        Double maxPrice = Optional.ofNullable(body.get("maxPrice")).map(Object::toString).map(Double::parseDouble).orElse(99999.0);
        List<Fruit> fruits = fruitRepository.findByNameContaining(name, category, minPrice, maxPrice);
    return ResponseEntity.ok(fruits);
    }


    //组合查询


}








