package com.example.site.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.site.entity.Category;
import com.example.site.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
	
      public Page<Restaurant> findByNameLike(String keyword, Pageable pageable);
      //List<Category> findCategoriesById(Integer id);
      @Query("SELECT c FROM Restaurant r JOIN r.categories c WHERE r.id = :restaurantId")
      List<Category> findCategoriesById(@Param("restaurantId") Integer restaurantId);
}