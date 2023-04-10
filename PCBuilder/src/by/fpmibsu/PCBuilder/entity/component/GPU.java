package by.fpmibsu.PCBuilder.entity.component;

import by.fpmibsu.PCBuilder.entity.component.utils.VideoMemoryType;

public class GPU extends Component {
    private int videoMemory;
    private int clockSpeed;
    private VideoMemoryType videoMemoryType;

    public GPU(int id, int price, String name, String brand, int clockSpeed, int videoMemory,
            VideoMemoryType videoMemoryType) {
        super(id, price, name, brand);
        this.clockSpeed = clockSpeed;
        this.videoMemory = videoMemory;
        this.videoMemoryType = videoMemoryType;
    }

    public int getVideoMemory() {
        return videoMemory;
    }

    public void setVideoMemory(int videoMemory) {
        this.videoMemory = videoMemory;
    }

    public int getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(int clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public VideoMemoryType getVideoMemoryType() {
        return videoMemoryType;
    }

    public void setVideoMemoryType(VideoMemoryType videoMemoryType) {
        this.videoMemoryType = videoMemoryType;
    }

    public GPU() {

    }

    @Override
    public String toString() {
        return "GPU{" + super.toString() + ", " +
                "videoMemory=" + videoMemory +
                ", clockSpeed=" + clockSpeed +
                ", videoMemoryType=" + videoMemoryType +
                '}';
    }
}
