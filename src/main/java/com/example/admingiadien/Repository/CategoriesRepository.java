package com.example.admingiadien.Repository;

import com.example.admingiadien.Entity.Categories;
import com.example.admingiadien.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories , Integer> {

}
