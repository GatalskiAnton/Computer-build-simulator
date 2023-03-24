package by.fpmibsu.PCBuilder.entity.component;

import by.fpmibsu.PCBuilder.entity.component.utils.Socket;

public class CPU extends Component{
    private Socket socket;
    private int core;
    private int clockSpeed;
    private int TDP;


    public CPU(int price, String name, String brand, Socket socket, int core, int clockSpeed, int TDP) {
        super(price, name, brand);
        this.socket = socket;
        this.core = core;
        this.clockSpeed = clockSpeed;
        this.TDP = TDP;
    }
}
