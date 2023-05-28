package by.fpmibsu.PCBuilder.entity.component;

import by.fpmibsu.PCBuilder.entity.component.utils.Socket;

import java.util.Objects;

public class Cooler extends Component{
    private Socket socket;
    private int TDP;
    private int diameter;

    public Cooler(int id, int price, String name, String brand, Socket socket, int TDP, int diameter) {
        super(id, price, name, brand);
        this.socket = socket;
        this.TDP = TDP;
        this.diameter = diameter;
    }

    public Cooler(){

    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public int getTDP() {
        return TDP;
    }

    public void setTDP(int TDP) {
        this.TDP = TDP;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    @Override
    public String toString() {
        return "Cooler{" + super.toString() + ", " +
                "socket=" + socket +
                ", TDP=" + TDP +
                ", diameter=" + diameter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cooler cooler = (Cooler) o;
        return TDP == cooler.TDP && diameter == cooler.diameter && socket == cooler.socket;
    }
}



