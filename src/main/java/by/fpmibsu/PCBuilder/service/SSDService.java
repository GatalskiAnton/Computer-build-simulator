package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.PCDao;
import by.fpmibsu.PCBuilder.dao.RAMDao;
import by.fpmibsu.PCBuilder.dao.SSDDao;
import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.component.SSD;

import java.util.ArrayList;
import java.util.List;

public class SSDService<SSD> implements ComponentServiceI<by.fpmibsu.PCBuilder.entity.component.SSD> {
    @Override
    public List<by.fpmibsu.PCBuilder.entity.component.SSD> getAllComponents() throws DaoException {
        SSDDao ssdDao = new SSDDao();
        return ssdDao.findAll();
    }

    @Override
    public boolean selectComponent(int pcId, by.fpmibsu.PCBuilder.entity.component.SSD component) {
        PCDao dao = new PCDao();
        try {
            PC pc = dao.findPCById(pcId);
            pc.setSsd(component);
            dao.update(pc);
            return true;
        } catch (DaoException e) {
            return false;
        }
    }

    @Override
    public by.fpmibsu.PCBuilder.entity.component.SSD getComponentById(int componentId) {
        SSDDao dao = new SSDDao();
        try {
            return dao.findComponentById(componentId);
        } catch (DaoException e) {
            return null;
        }
    }
}
