package by.fpmibsu.PCBuilder.entity.component;

public abstract class Component {
    private int price;

    public Component(int price, String name, String brand) {
        this.price = price;
        this.name = name;
        this.brand = brand;
    }

    private String name;

    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
