package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.MotherboardDao;
import by.fpmibsu.PCBuilder.dao.PCCaseDao;
import by.fpmibsu.PCBuilder.dao.PCDao;
import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.component.PCCase;

import java.util.ArrayList;
import java.util.List;

public class PCCaseService<PCCase> implements ComponentServiceI<by.fpmibsu.PCBuilder.entity.component.PCCase> {
    @Override
    public List<by.fpmibsu.PCBuilder.entity.component.PCCase> getAllComponents() throws DaoException {
        PCCaseDao pcCaseDao = new PCCaseDao();
        return pcCaseDao.findAll();
    }

    @Override
    public boolean selectComponent(int pcId, by.fpmibsu.PCBuilder.entity.component.PCCase component) {
        PCDao dao = new PCDao();
        try {
            PC pc = dao.findPCById(pcId);
            pc.setPCCase(component);
            dao.update(pc);
            return true;
        } catch (DaoException e) {
            return false;
        }
    }

    @Override
    public by.fpmibsu.PCBuilder.entity.component.PCCase getComponentById(int componentId) {
        PCCaseDao dao = new PCCaseDao();
        try {
            return dao.findComponentById(componentId);
        } catch (DaoException e) {
            return null;
        }
    }
}
