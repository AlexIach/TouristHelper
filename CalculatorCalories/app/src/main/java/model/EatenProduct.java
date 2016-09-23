package model;

/**
 * Created by Alex Iachimov on 5/9/2016.
 */
public class EatenProduct {
    private int id;
    private String name;
    private int amount;
    private String yearTime;
    private String monthTime;
    private String dayTime;
    private String hourTime;
    private String minTime;
    private Product product;
    private int coefficient;
    private String userId;

    public EatenProduct(int id, String name, int amount, String yearTime, String dayTime, String monthTime, String hourTime, String minTime,Product product,int coefficient,String userId) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.yearTime = yearTime;
        this.dayTime = dayTime;
        this.monthTime = monthTime;
        this.hourTime = hourTime;
        this.minTime = minTime;
        this.product = product;
        this.coefficient =coefficient;
        this.userId = userId;

    }

    public int getId() {return id;}

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public String getYearTime() {
        return yearTime;
    }

    public String getMonthTime() {
        return monthTime;
    }

    public String getDayTime() {
        return dayTime;
    }

    public String getHourTime() {
        return hourTime;
    }

    public String getMinTime() {
        return minTime;
    }

    public Product getProduct() {return product;}

    public int getCoefficient() {return coefficient;}

    public String getUserId() {
        return userId;
    }
}
