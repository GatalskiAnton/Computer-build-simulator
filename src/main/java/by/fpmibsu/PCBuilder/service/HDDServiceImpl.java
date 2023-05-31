package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.HDDDaoImpl;
import by.fpmibsu.PCBuilder.dao.PCDaoImpl;
import by.fpmibsu.PCBuilder.entity.PC;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class HDDServiceImpl<HDD> implements ComponentService<by.fpmibsu.PCBuilder.entity.component.HDD> {
    private static Logger log = LogManager.getLogger(HDDServiceImpl.class);

    @Override
    public List<by.fpmibsu.PCBuilder.entity.component.HDD> getAllComponents() throws DaoException {
        log.info("HDDService calling getAllComponents");
        HDDDaoImpl hddDao = new HDDDaoImpl();

        try {
            return hddDao.findAll();
        } catch (DaoException e) {
            log.error(e);
            return null;
        }
    }

    @Override
    public boolean selectComponent(int pcId, by.fpmibsu.PCBuilder.entity.component.HDD component) {
        PCDaoImpl dao = new PCDaoImpl();
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
        HDDDaoImpl dao = new HDDDaoImpl();
        try {
            return dao.findComponentById(componentId);
        } catch (DaoException e) {
            return null;
        }
    }
}
