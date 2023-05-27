package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.GPUDao;
import by.fpmibsu.PCBuilder.dao.HDDDao;
import by.fpmibsu.PCBuilder.dao.PCDao;
import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.component.HDD;

import java.util.ArrayList;
import java.util.List;

public class HDDService<HDD> implements ComponentServiceI<by.fpmibsu.PCBuilder.entity.component.HDD> {
    @Override
    public List<by.fpmibsu.PCBuilder.entity.component.HDD> getAllComponents() throws DaoException {
        HDDDao hddDao = new HDDDao();
        return hddDao.findAll();
    }

    @Override
    public boolean selectComponent(int pcId, by.fpmibsu.PCBuilder.entity.component.HDD component) {
        PCDao dao = new PCDao();
        try {
            PC pc = dao.findPCById(pcId);
            pc.setHdd(component);
            dao.update(pc);
            return true;
        } catch (DaoException e) {
            return false;
        }
    }

    @Override
    public by.fpmibsu.PCBuilder.entity.component.HDD getComponentById(int componentId) {
        HDDDao dao = new HDDDao();
        try {
            return dao.findComponentById(componentId);
        } catch (DaoException e) {
            return null;
        }
    }
}
