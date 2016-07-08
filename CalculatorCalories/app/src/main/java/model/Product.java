package model;

/**
 * Created by Alex Iachimov on 5/5/2016.
 */
public class Product {
    private int id;
    private String name;
    private int calorie;
    private String proteine;
    private String fats;
    private String carbohydrates;


    public  Product(){

    }

    public Product(int id, String name, int calorie, String proteine, String fats, String carbohydrates) {
        this.id = id;
        this.name = name;
        this.calorie = calorie;
        this.proteine = proteine;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public int getId() {return id;  }

    public String getName() {
        return name;
    }

    public int getCalorie() {
        return calorie;
    }

    public String getProteine() {
        return proteine;
    }

    public String getFats() {
        return fats;
    }

    public String getCarbohydrates() {
        return carbohydrates;
    }

}
