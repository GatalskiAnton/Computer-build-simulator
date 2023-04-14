package by.fpmibsu.PCBuilder.entity.component;

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

    public PowerSupply(){

    }

    @Override
    public String toString() {
        return "PowerSupply{" + super.toString() + ", " +
                "power=" + power +
                '}';
    }
}
