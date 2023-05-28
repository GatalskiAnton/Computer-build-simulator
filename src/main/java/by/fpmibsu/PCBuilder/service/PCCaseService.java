package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.MotherboardDao;
import by.fpmibsu.PCBuilder.dao.PCCaseDao;
import by.fpmibsu.PCBuilder.dao.PCDao;
import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.component.PCCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PCCaseService<PCCase> implements ComponentServiceI<by.fpmibsu.PCBuilder.entity.component.PCCase> {
    private static Logger log = LogManager.getLogger(PCCaseService.class);


    @Override
    public List<by.fpmibsu.PCBuilder.entity.component.PCCase> getAllComponents() throws DaoException {
        log.info("PCCaseService calling getAllComponents");
        PCCaseDao pcCaseDao = new PCCaseDao();

        try {
            return pcCaseDao.findAll();
        } catch (DaoException e) {
            log.error(e);
            return null;
        }
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
