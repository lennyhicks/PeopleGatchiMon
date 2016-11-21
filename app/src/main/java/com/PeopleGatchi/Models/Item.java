package com.PeopleGatchi.Models;

/**
 * Created by lennyhicks on 11/18/16.
 */

public class Item {
    private String name;
    private Integer price;
    private Integer resourceId;

    public Item(String name, Integer price, Integer resourceId) {
        this.name = name;
        this.price = price;
        this.resourceId = resourceId;
    }

    public Item(String name, Integer resourceId) {
        this.name = name;
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }
}
