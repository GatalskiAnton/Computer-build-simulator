package by.fpmibsu.PCBuilder.entity.component;

import by.fpmibsu.PCBuilder.entity.component.utils.Socket;

import javax.swing.plaf.SeparatorUI;
import java.util.Objects;

public class CPU extends Component{
    private Socket socket;
    private int core;
    private int clockSpeed;
    private int TDP;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CPU cpu = (CPU) o;
        return core == cpu.core && clockSpeed == cpu.clockSpeed && TDP == cpu.TDP && socket == cpu.socket;
    }

    public CPU(int id, int price, String name, String brand, int clockSpeed, Socket socket, int TDP, int core) {
        super(id, price, name, brand);
        this.socket = socket;
        this.core = core;
        this.clockSpeed = clockSpeed;
        this.TDP = TDP;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public int getCore() {
        return core;
    }

    public void setCore(int core) {
        this.core = core;
    }

    public int getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(int clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public int getTDP() {
        return TDP;
    }

    public void setTDP(int TDP) {
        this.TDP = TDP;
    }

    public CPU(){}

    @Override
    public String toString() {
        return "CPU{" + super.toString() + ", " +
                "socket=" + socket +
                ", core=" + core +
                ", clockSpeed=" + clockSpeed +
                ", TDP=" + TDP +
                '}';
    }
}
