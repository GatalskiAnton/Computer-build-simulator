package by.fpmibsu.PCBuilder.entity.component;

import java.util.Objects;

public class PowerSupply extends Component{

    private int power;
    public PowerSupply(int id, int price, String name, String brand, int power) {
        super(id, price, name, brand);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PowerSupply that = (PowerSupply) o;
        return power == that.power;
    }

    public PowerSupply(){

    }

    @Override
    public String toString() {
        return "PowerSupply{" + super.toString() + ", " +
                "power=" + power +
                '}';
    }
}
