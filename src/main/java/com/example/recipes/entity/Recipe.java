package com.example.recipes.entity;
import jakarta.persistence.*;


@Entity
@Table(name = "recipes")
public class Recipe {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String cuisine;
    private Float rating;
    private Integer prepTime;
    private Integer cookTime;
    private Integer totalTime;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(columnDefinition = "json")
    private String nutrients;

    private String serves;
  
  
    
    
    public Recipe() {}

    
    
  

    public Recipe(Integer id, String title, String cuisine, Float rating, Integer prepTime, Integer cookTime,
			Integer totalTime, String description, String nutrients, String serves) {
		super();
		this.id = id;
		this.title = title;
		this.cuisine = cuisine;
		this.rating = rating;
		this.prepTime = prepTime;
		this.cookTime = cookTime;
		this.totalTime = totalTime;
		this.description = description;
		this.nutrients = nutrients;
		this.serves = serves;
	}





	public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCuisine() {
        return cuisine;
    }

    public Float getRating() {
        return rating;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public String getDescription() {
        return description;
    }

    public String getNutrients() {
        return nutrients;
    }

    public String getServes() {
        return serves;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNutrients(String nutrients) {
        this.nutrients = nutrients;
    }

    public void setServes(String serves) {
        this.serves = serves;
    }
}