package com.example.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.site.entity.Category;
import com.example.site.entity.Picture;
import com.example.site.entity.RegularHoliday;
import com.example.site.entity.Restaurant;
import com.example.site.repository.CategoryRepository;
import com.example.site.repository.PictureRepository;
import com.example.site.repository.RegularHolidayRepository;
import com.example.site.repository.RestaurantRepository;

@Controller
@RequestMapping("/admin/restaurants")
public class AdminRestaurantController {
     private final RestaurantRepository restaurantRepository;
     @Autowired
     private final RegularHolidayRepository regularHolidayRepository;
     @Autowired
     private final PictureRepository pictureRepository;
     
     public AdminRestaurantController(RestaurantRepository restaurantRepository, CategoryRepository categoryRepository, RegularHolidayRepository regularHolidayRepository, PictureRepository pictureRepository) {
    	 this.restaurantRepository = restaurantRepository;
    	 this.regularHolidayRepository = regularHolidayRepository;
    	 this.pictureRepository = pictureRepository;
     }
     
     @GetMapping
     public String index(Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable, @RequestParam(name = "keyword", required = false) String keyword) {
    	 Page<Restaurant> restaurantPage;
    	 
    	 if (keyword != null && !keyword.isEmpty()) {
             restaurantPage = restaurantRepository.findByNameLike("%" + keyword + "%", pageable);               
         } else {
             restaurantPage = restaurantRepository.findAll(pageable);
         }
    	 
    	 model.addAttribute("restaurantPage", restaurantPage);
    	 model.addAttribute("keyword", keyword);
    	 
    	 return "admin/restaurants/index";
     }
    
     @GetMapping("/{id}")
     public String show(@PathVariable(name = "id") Integer id, Model model, Pageable pageable) {
    	 Restaurant restaurant = restaurantRepository.findById(id).orElse(null);
    	 List<Category> categories = restaurant.getCategories();
    	 List<RegularHoliday> offs = regularHolidayRepository.findRegularHolidaysRestaurantIById(id);
    	 List<Picture> photos = pictureRepository.findByRestaurantId(id);
    	 
         model.addAttribute("restaurant", restaurant);
         model.addAttribute("categories", categories);  
         model.addAttribute("offs", offs);  
         model.addAttribute("photos", photos);
         
         return "admin/restaurants/show";
     }
}