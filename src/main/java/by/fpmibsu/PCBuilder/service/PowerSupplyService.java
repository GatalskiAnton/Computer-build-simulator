package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.PCCaseDao;
import by.fpmibsu.PCBuilder.dao.PCDao;
import by.fpmibsu.PCBuilder.dao.PowerSupplyDao;
import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.component.PowerSupply;

import java.util.ArrayList;
import java.util.List;

public class PowerSupplyService<PowerSupply> implements ComponentServiceI<by.fpmibsu.PCBuilder.entity.component.PowerSupply> {
    @Override
    public List<by.fpmibsu.PCBuilder.entity.component.PowerSupply> getAllComponents() throws DaoException {
        PowerSupplyDao powerSupplyDao = new PowerSupplyDao();
        return powerSupplyDao.findAll();
    }

    @Override
    public boolean selectComponent(int pcId, by.fpmibsu.PCBuilder.entity.component.PowerSupply component) {
        PCDao dao = new PCDao();
        try {
            PC pc = dao.findPCById(pcId);
            pc.setPowerSupply(component);
            dao.update(pc);
            return true;
        } catch (DaoException e) {
            return false;
        }
    }

    @Override
    public by.fpmibsu.PCBuilder.entity.component.PowerSupply getComponentById(int componentId) {
        PowerSupplyDao dao = new PowerSupplyDao();
        try {
            return dao.findComponentById(componentId);
        } catch (DaoException e) {
            return null;
        }
    }
}
