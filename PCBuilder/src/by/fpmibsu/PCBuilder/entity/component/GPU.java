package by.fpmibsu.PCBuilder.entity.component;

import by.fpmibsu.PCBuilder.entity.component.utils.VideoMemoryType;

public class GPU extends Component{
    private int videoMemory;
    private int clockSpeed;
    private VideoMemoryType videoMemoryType;
    public GPU(int price, String name, String brand, VideoMemoryType videoMemoryType) {
        super(price, name, brand);
        this.videoMemoryType = videoMemoryType;
    }
}
