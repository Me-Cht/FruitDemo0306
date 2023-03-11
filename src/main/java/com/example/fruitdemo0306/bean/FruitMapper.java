package com.example.fruitdemo0306.bean;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author Hotan
 * @Date 2023/3/10 22:17
 * @PackageName:com.example.fruitdemo0306.bean
 * @ClassName: test
 * @Description: TODO
 * @Version 1.0
 */
@Mapper
public interface FruitMapper extends BaseMapper <Fruit>{
    @Select("SELECT * FROM fruit WHERE name = #{name}")
    Fruit selectByName(@Param("name") String name);
    // 根据分类查询水果数据
    @Select("SELECT * FROM fruit WHERE category = #{category}")
    List<Fruit> selectByCategory(@Param("category") String category);

    // 根据价格区间查询水果数据
    @Select("SELECT * FROM fruit WHERE price BETWEEN #{minPrice} AND #{maxPrice}")
    List<Fruit> selectByPriceRange(@Param("minPrice") BigDecimal minPrice, @Param("maxPrice") BigDecimal maxPrice);



}
