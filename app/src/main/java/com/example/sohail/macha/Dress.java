package com.example.sohail.macha;

public class Dress {
    int image;
    String price,catogiry,name;

    Dress(int resource,String price,String catogiry,String name){
        this.image = resource;
        this.price = price;
        this.catogiry = catogiry;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getPrice() {
        return price;
    }

    public String getCatogiry() {
        return catogiry;
    }
}
