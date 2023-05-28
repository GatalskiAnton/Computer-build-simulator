package by.fpmibsu.PCBuilder.entity.component;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ROM rom = (ROM) o;
        return capacity == rom.capacity;
    }

    public ROM() {
    }
}
