package com.example.site.entity;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
//import java.util.Locale.Category;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "restaurants")
@Data
public class Restaurant {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private Integer id;
     
     @Column(name = "name")
     private String name;
     
     @Column(name = "image")
     private String image;
     
     @Column(name = "description")
     private String description;
     
     @Column(name = "lowest_price")
     private Integer lowestPrice;
   
     @Column(name = "highest_price")
     private Integer highestPrice;
     
     @Column(name = "postal_code")
     private String postalCode;
     
     @Column(name = "address")
     private String address;
     
     @Column(name = "access")
     private String access;
     
     @Column(name = "opening_time")
     private LocalTime openingTime;
     
     @Column(name = "closing_time")
     private LocalTime closingTime;
     
     @Column(name = "phone_number")
     private String phoneNumber;
     
     @Column(name = "seating_capacity")
     private Integer seatingCapacity;
  
     @Column(name = "created_at", insertable = false, updatable = false)
     private Timestamp createdAt;

     @Column(name = "updated_at", insertable = false, updatable = false)
     private Timestamp updatedAt;
     
     @ManyToMany
     @JoinTable(
         name = "category_restaurant",
         joinColumns = @JoinColumn(name = "restaurant_id"),
         inverseJoinColumns = @JoinColumn(name = "category_id")
     )
     private List<Category> categories;
     
     public Integer getId() {
    	 return id;
     }
     
     public void setId(Integer id) {
    	 this.id = id;
     }
     
     public String getName() {
    	 return name;
     }
     
     public void setName(String name) {
    	 this.name = name;
     }
     
     public String getImage() {
    	 return image;
     }
     
     public void setImage(String image) {
    	 this.image = image;
     }
     
     public String getDescription() {
    	  return description;
     }
     
     public void setDescription(String description) {
    	 this.description = description;
     }
     
     public int getLowestPrice() {
    	 return lowestPrice;
     }
     
     public void setLowestPrice(Integer lowestPrice) {
    	 this.lowestPrice = lowestPrice;
     }
     
     public int getHighestPrice() {
    	 return highestPrice;
     }
     
     public void setHighestPrice(Integer highestPrice) {
    	 this.highestPrice = highestPrice;
     }
     
     public String getPostalCode() {
    	 return postalCode;
     }
     
     public void setPostalCode(String postalCode) {
    	 this.postalCode = postalCode;
     }
     
     public String getAddress() {
    	 return address;
     }
     
     public void setAddress(String address) {
    	 this.address = address;
     }
     
     public String getAccess() {
    	 return access;
     }
     
     public void setAccess(String access) {
    	 this.access = access;
     }
     
     public LocalTime getOpeningTime() {
    	 return openingTime;
     }
     
     public void setOpeningTime(LocalTime openingTime) {
    	 this.openingTime = openingTime;
     }
     
     public LocalTime getClosingTime()  {
    	 return closingTime;
     }
     
     public void setClosingTime(LocalTime closingTime) {
    	 this.closingTime = closingTime;
     }
     
     public String getPhoneNumber() {
    	 return phoneNumber;
     }
     
     public void setPhoneNumber(String phoneNumber) {
    	 this.phoneNumber = phoneNumber;
     }
     
     public Integer getSeatingCapacity() {
    	 return seatingCapacity;
     }
     
     public void setSeatingCapacity(Integer seatingCapacity) {
    	 this.seatingCapacity = seatingCapacity;
     }
     
     public Timestamp getCreatedAt() {
    	 return createdAt;
     }
     
     public void createdAt(Timestamp createdAt) {
    	 this.createdAt = createdAt;
     }
     
     public Timestamp getUpdatedAt() {
    	 return updatedAt;
     }
     
     public void updatedAt(Timestamp updatedAt) {
    	 this.updatedAt = updatedAt;
     }
     
     public List<Category> getCategories() {
    	    return categories;
     }

     public void setCategories(List<Category> categories) {
    	    this.categories = categories;
     }

     @OneToMany(mappedBy  = "restaurant", cascade = CascadeType.ALL)
     private List<RegularHoliday> regularHolidays;
     
     public List<RegularHoliday> getRegularHolidays() {
    	 return regularHolidays;
     }
     
     public void setRegularHolidays(List<RegularHoliday> regularHolidays) {
    	 this.regularHolidays = regularHolidays;
     }
     
     @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
     private List<Picture> pictures;
     
     public List<String> getPictureFiles() {
    	    List<String> pictureFiles = new ArrayList<>();
    	    if (pictures != null) {
    	        for (Picture picture : pictures) {
    	            pictureFiles.addAll(picture.getPictureFiles());
    	        }
    	    }
    	    return pictureFiles;
    	}

    	public void setPictureFiles(List<String> pictureFiles) {
    	    if (pictures == null) {
    	        pictures = new ArrayList<>();
    	    }
    	    Picture picture = new Picture();
    	    picture.setPictureFiles(pictureFiles);
    	    pictures.add(picture);
    	}
}