package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.PCDao;
import by.fpmibsu.PCBuilder.dao.PowerSupplyDao;
import by.fpmibsu.PCBuilder.dao.RAMDao;
import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.component.RAM;

import java.util.ArrayList;
import java.util.List;

public class RamService<RAM> implements ComponentServiceI<by.fpmibsu.PCBuilder.entity.component.RAM> {
    @Override
    public List<by.fpmibsu.PCBuilder.entity.component.RAM> getAllComponents() throws DaoException {
        RAMDao ramDao = new RAMDao();
        return ramDao.findAll();
    }

    @Override
    public boolean selectComponent(int pcId, by.fpmibsu.PCBuilder.entity.component.RAM component) {
        PCDao dao = new PCDao();
        try {
            PC pc = dao.findPCById(pcId);
            pc.setRam(component);
            dao.update(pc);
            return true;
        } catch (DaoException e) {
            return false;
        }
    }

    @Override
    public by.fpmibsu.PCBuilder.entity.component.RAM getComponentById(int componentId) {
        RAMDao dao = new RAMDao();
        try {
            return dao.findComponentById(componentId);
        } catch (DaoException e) {
            return null;
        }
    }
}
