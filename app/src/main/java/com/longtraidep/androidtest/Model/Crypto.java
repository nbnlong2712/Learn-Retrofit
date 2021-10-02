package com.longtraidep.androidtest.Model;

import com.google.gson.annotations.SerializedName;

public class Crypto {
    @SerializedName(value = "Name")
    private String name;
    @SerializedName(value = "Price")
    private double price;
    @SerializedName(value = "Color")
    private String color;

    public Crypto(String name, double price, String color) {
        this.name = name;
        this.price = price;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
