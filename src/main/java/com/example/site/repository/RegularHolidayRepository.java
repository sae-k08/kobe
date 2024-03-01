package com.example.site.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.site.entity.RegularHoliday;

public interface RegularHolidayRepository extends JpaRepository<RegularHoliday, Integer> {
    // regular_holiday_restaurantテーブルから、指定したrestaurant_idに紐づくRegularHolidayオブジェクトのリストを取得する
    List<RegularHoliday> findRegularHolidaysRestaurantIById(Integer id);
}