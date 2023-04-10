package by.fpmibsu.PCBuilder.entity.component;

import by.fpmibsu.PCBuilder.entity.component.utils.Color;

public class PCCase extends Component{

    private Color color;

    public PCCase(int id, int price, String name, String brand, Color color) {
        super(id, price, name, brand);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public PCCase(){

    }

    @Override
    public String toString() {
        return "PCCase{" + super.toString() + ", " +
                "color=" + color +
                '}';
    }
}


