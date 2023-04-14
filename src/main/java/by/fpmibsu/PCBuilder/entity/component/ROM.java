package by.fpmibsu.PCBuilder.entity.component;

public class ROM extends Component{
    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ROM(int id, int price, String name, String brand, int capacity) {
        super(id, price, name, brand);
        this.capacity = capacity;
    }

    public ROM() {
    }
}
