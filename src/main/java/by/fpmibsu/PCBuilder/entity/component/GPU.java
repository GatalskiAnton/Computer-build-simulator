package by.fpmibsu.PCBuilder.entity.component;

import by.fpmibsu.PCBuilder.entity.component.utils.VideoMemoryType;

import java.util.Objects;

public class GPU extends Component {
    private int videoMemory;
    private int clockSpeed;
    private VideoMemoryType videoMemoryType;

    public GPU(int id, int price, String name, String brand, int clockSpeed, VideoMemoryType videoMemoryType, int videoMemory) {
        super(id, price, name, brand);
        this.videoMemoryType = videoMemoryType;
        this.clockSpeed = clockSpeed;
        this.videoMemory = videoMemory;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GPU gpu = (GPU) o;
        return videoMemory == gpu.videoMemory && clockSpeed == gpu.clockSpeed && videoMemoryType == gpu.videoMemoryType;
    }
}
