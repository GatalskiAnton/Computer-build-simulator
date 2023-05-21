package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.PowerSupplyDao;
import by.fpmibsu.PCBuilder.entity.component.PowerSupply;

import java.util.ArrayList;
import java.util.List;

public class PowerSupplyService implements ComponentServiceI {
    @Override
    public List<PowerSupply> getAllComponents() throws DaoException {
        PowerSupplyDao powerSupplyDao = new PowerSupplyDao();
        return powerSupplyDao.findAll();
    }
}
