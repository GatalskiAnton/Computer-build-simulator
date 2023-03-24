package by.fpmibsu.PCBuilder.entity.component;

public class PowerSupply extends Component{

    private int power;
    public PowerSupply(int price, String name, String brand, int power) {
        super(price, name, brand);
        this.power = power;
    }
}
