package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.PCCaseDaoImpl;
import by.fpmibsu.PCBuilder.dao.PCDaoImpl;
import by.fpmibsu.PCBuilder.entity.PC;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PCCaseServiceImpl<PCCase> implements ComponentService<by.fpmibsu.PCBuilder.entity.component.PCCase> {
    private static Logger log = LogManager.getLogger(PCCaseServiceImpl.class);


    @Override
    public List<by.fpmibsu.PCBuilder.entity.component.PCCase> getAllComponents() throws DaoException {
        log.info("PCCaseService calling getAllComponents");
        PCCaseDaoImpl pcCaseDao = new PCCaseDaoImpl();

        try {
            return pcCaseDao.findAll();
        } catch (DaoException e) {
            log.error(e);
            return null;
        }
    }

    @Override
    public boolean selectComponent(int pcId, by.fpmibsu.PCBuilder.entity.component.PCCase component) {
        PCDaoImpl dao = new PCDaoImpl();
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
        PCCaseDaoImpl dao = new PCCaseDaoImpl();
        try {
            return dao.findComponentById(componentId);
        } catch (DaoException e) {
            return null;
        }
    }
}
