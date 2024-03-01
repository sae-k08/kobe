package com.example.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.site.entity.CategoryRestaurant;

public interface CategoryRestaurantRepository extends JpaRepository<CategoryRestaurant, Integer> {

}