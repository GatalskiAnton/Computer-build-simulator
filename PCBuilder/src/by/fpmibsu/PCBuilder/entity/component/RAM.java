package by.fpmibsu.PCBuilder.entity.component;

import by.fpmibsu.PCBuilder.entity.component.utils.MemoryType;

public class RAM extends Component{
    private int speed;
    private MemoryType memoryType;
    public RAM(int price, String name, String brand, int speed, MemoryType memoryType) {
        super(price, name, brand);
        this.memoryType = memoryType;
    }
}
