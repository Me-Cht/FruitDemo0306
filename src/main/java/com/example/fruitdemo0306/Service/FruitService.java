package com.example.fruitdemo0306.Service;
/**
 * @Author Hotan
 * @Date 2023/3/10 22:41
 * @PackageName:com.example.fruitdemo0306.Service
 * @ClassName: FruitService
 * @Description: TODO
 * @Version 1.0
 */

import com.example.fruitdemo0306.bean.Fruit;
import com.example.fruitdemo0306.utils.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Hotan
 * @Project: BigData-MovieRecommender
 * @Pcakage: com.example.fruitdemo0306.Service.FruitService
 * @Date: 2023年03月10日 22:41
 * @Description:
 */

@Service
public class FruitService {

    @Autowired
    private FruitRepository fruitRepository;

    public List<Fruit> getFruits(String name, String category, Double minPrice, Double maxPrice) {
        Specification<Fruit> spec = Specification.where(null);

        if (name != null && !name.isEmpty()) {
            spec = spec.and((root, query, builder) -> builder.like(root.get("name"), "%" + name + "%"));
        }

        if (category != null && !category.isEmpty()) {
            spec = spec.and((root, query, builder) -> builder.equal(root.get("category"), category));
        }

        if (minPrice != null) {
            spec = spec.and((root, query, builder) -> builder.greaterThanOrEqualTo(root.get("price"), minPrice));
        }

        if (maxPrice != null) {
            spec = spec.and((root, query, builder) -> builder.lessThanOrEqualTo(root.get("price"), maxPrice));
        }

        return fruitRepository.findAll(spec);
    }
}
