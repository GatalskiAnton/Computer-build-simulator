package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.component.Component;

import java.util.ArrayList;
import java.util.List;

public interface ComponentServiceI<C extends Component> {

    List<C> getAllComponents() throws DaoException;

    boolean selectComponent(int pcId, C component);

    C getComponentById(int componentId);
}
