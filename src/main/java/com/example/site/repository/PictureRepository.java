package com.example.site.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.site.entity.Picture;

public interface PictureRepository extends JpaRepository<Picture, Integer> {
    // picturesテーブルから、指定したrestaurant_idに紐づくPictureオブジェクトのリストを取得する
    List<Picture> findByRestaurantId(Integer restaurantId);
}
