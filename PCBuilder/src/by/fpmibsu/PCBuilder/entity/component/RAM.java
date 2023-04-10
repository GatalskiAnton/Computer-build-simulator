package by.fpmibsu.PCBuilder.entity.component;

import by.fpmibsu.PCBuilder.entity.component.utils.MemoryType;

public class RAM extends Component{
    private int speed;
    private MemoryType memoryType;
    public RAM(int id, int price, String name, String brand, int speed, MemoryType memoryType) {
        super(id, price, name, brand);
        this.memoryType = memoryType;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public MemoryType getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(MemoryType memoryType) {
        this.memoryType = memoryType;
    }

    public  RAM(){}

    @Override
    public String toString() {
        return "RAM{" + super.toString() + ", " +
                "speed=" + speed +
                ", memoryType=" + memoryType +
                '}';
    }
}
