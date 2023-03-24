package by.fpmibsu.PCBuilder.entity.component;

import by.fpmibsu.PCBuilder.entity.component.utils.Socket;

public class Cooler extends Component{
    private Socket socket;
    private int TDP;
    private int diameter;

    public Cooler(int price, String name, String brand, Socket socket, int TDP, int diameter) {
        super(price, name, brand);
        this.socket = socket;
        this.TDP = TDP;
        this.diameter = diameter;
    }
}



