package com.example.site.entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "pictures")
@Data
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    /*
    @Column(name = "photo_1")
    private String photo1;

    @Column(name = "photo_2")
    private String photo2;

    @Column(name = "photo_3")
    private String photo3;

    @Column(name = "photo_4")
    private String photo4;
	
	*/
    
    @ElementCollection
    @CollectionTable(name = "picture_files", joinColumns = @JoinColumn(name = "picture_id"))
    @Column(name = "file_path")
    private List<String> pictureFiles;
    
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

}
