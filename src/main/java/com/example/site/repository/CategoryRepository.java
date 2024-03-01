package com.example.site.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.site.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
    List<Category> findByRestaurantId(Integer restaurantId);
    
    public Page<Category> findByNameLike(String word, Pageable pageable);
}
