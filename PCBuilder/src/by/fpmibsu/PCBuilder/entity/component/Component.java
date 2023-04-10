package by.fpmibsu.PCBuilder.entity.component;

public abstract class Component {
    private int id;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Component(int id, int price, String name, String brand) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.brand = brand;
    }

    public Component(){

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

    @Override
    public String toString() {
        return
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'';
    }
}
