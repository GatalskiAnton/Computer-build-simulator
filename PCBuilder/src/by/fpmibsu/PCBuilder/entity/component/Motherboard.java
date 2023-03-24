package by.fpmibsu.PCBuilder.entity.component;

import by.fpmibsu.PCBuilder.entity.component.utils.Socket;

public class Motherboard extends Component{
    private Socket socket;

    public Motherboard(int price, String name, String brand, Socket socket) {
        super(price, name, brand);
        this.socket = socket;
    }
}
