package com.example.site.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "category_restaurant")
@Data
public class CategoryRestaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "restaurant_id", insertable = true, updatable = true)
	private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "category_id", insertable = true, updatable = true)
    private Category category;

    @Column(name = "created_at", insertable = false, updatable = false)
	private Timestamp  createdAt;
	
	@Column(name = "updated_at", insertable = false, updatable = false)
	private Timestamp updatedAt;

    public Integer getId() {
    	return id;
    }
    
    public void setId(Integer id) {
    	this.id = id;
    }

    public Timestamp getCreatedAt() {
    	return createdAt;
    }
    
    public void setCreatedAt(Timestamp createdAt) {
    	this.createdAt = createdAt;
    }
    
    public Timestamp getUpdatedAt() {
    	return updatedAt;
    }
    
    public void setUpdatedAt(Timestamp updatedAt) {
    	this.updatedAt = updatedAt;
    }
    
    public Restaurant getRestaurant() {
    	return restaurant;
    }
    
    public void setRestaurant(Restaurant restaurant) {
    	this.restaurant = restaurant;
    }
    
    public Category getCategory() {
    	return category;
    }
    
    public void setCategory(Category category) {
    	this.category = category;
    }
}
