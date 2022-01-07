package com.example.trabalho1unidade.model;

public class Product {
    private String name;
    private float price;
    private String image_id;    // File name
    private String type;        // Food or Drink
    private String category;

    public Product(String name, float price, String image_id, String type, String category) {
        this.name = name;
        this.price = price;
        this.image_id = image_id;
        this.type = type;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
