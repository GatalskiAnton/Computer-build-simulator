package by.fpmibsu.PCBuilder.entity.component;

import by.fpmibsu.PCBuilder.entity.component.utils.Socket;

public class Motherboard extends Component{
    private Socket socket;

    public Motherboard(int id, int price, String name, String brand, Socket socket) {
        super(id, price, name, brand);
        this.socket = socket;
    }

    public Motherboard(){

    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public String toString() {
        return "Motherboard{"+ super.toString() + ", " +
                "socket=" + socket +
                '}';
    }
}
