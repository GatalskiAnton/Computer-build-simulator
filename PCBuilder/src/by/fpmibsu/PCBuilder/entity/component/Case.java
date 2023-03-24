package by.fpmibsu.PCBuilder.entity.component;

import by.fpmibsu.PCBuilder.entity.component.utils.Color;

public class Case extends Component{

    private Color color;

    public Case(int price, String name, String brand, Color color) {
        super(price, name, brand);
        this.color = color;
    }
}


