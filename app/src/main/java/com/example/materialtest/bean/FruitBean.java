package com.example.materialtest.bean;

/**
 * Fruit 实体类
 *
 * @author ALion on 2017/4/21 16:15
 */

public class FruitBean {

    private String name;

    private int imageId;

    private int resId;

    public FruitBean(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }


    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

}
