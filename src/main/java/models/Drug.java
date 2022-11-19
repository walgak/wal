package models;

public class Drug {

    private String name;
    private String imgSrc;
    private double price;
    private String color;

    public void setName(String name) {
        this.name = name;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }
}
