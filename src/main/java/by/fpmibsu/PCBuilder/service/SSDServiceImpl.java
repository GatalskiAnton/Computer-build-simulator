package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.PCDaoImpl;
import by.fpmibsu.PCBuilder.dao.SSDDaoImpl;
import by.fpmibsu.PCBuilder.entity.PC;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SSDServiceImpl<SSD> implements ComponentService<by.fpmibsu.PCBuilder.entity.component.SSD> {
    private static Logger log = LogManager.getLogger(SSDServiceImpl.class);

    @Override
    public List<by.fpmibsu.PCBuilder.entity.component.SSD> getAllComponents() throws DaoException {
        log.info("PCCaseService calling getAllComponents");
        SSDDaoImpl ssdDao = new SSDDaoImpl();

        try {
            return ssdDao.findAll();
        } catch (DaoException e) {
            log.error(e);
            return null;
        }
    }
    @Override
    public boolean selectComponent(int pcId, by.fpmibsu.PCBuilder.entity.component.SSD component) {
        PCDaoImpl dao = new PCDaoImpl();
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
        SSDDaoImpl dao = new SSDDaoImpl();
        try {
            return dao.findComponentById(componentId);
        } catch (DaoException e) {
            return null;
        }
    }
}
