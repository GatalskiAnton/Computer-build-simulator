package by.fpmibsu.PCBuilder.entity.component;

import by.fpmibsu.PCBuilder.entity.component.utils.Socket;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(super.getId(), super.getName(), super.getBrand(), super.getPrice(), socket);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motherboard that = (Motherboard) o;
        return super.getId() == getId() && Objects.equals(super.getName(), getName()) && Objects.equals(super.getBrand(), getBrand()) && super.getPrice() == getPrice()  && socket == that.socket;
    }
}
