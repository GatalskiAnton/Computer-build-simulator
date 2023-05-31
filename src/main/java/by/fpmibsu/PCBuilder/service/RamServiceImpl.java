package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.PCDaoImpl;
import by.fpmibsu.PCBuilder.dao.RAMDaoImpl;
import by.fpmibsu.PCBuilder.entity.PC;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class RamServiceImpl<RAM> implements ComponentService<by.fpmibsu.PCBuilder.entity.component.RAM> {
    private static Logger log = LogManager.getLogger(RamServiceImpl.class);

    @Override
    public List<by.fpmibsu.PCBuilder.entity.component.RAM> getAllComponents() throws DaoException {
        log.info("RamService calling getAllComponents");
        RAMDaoImpl ramDao = new RAMDaoImpl();

        try {
            return ramDao.findAll();
        } catch (DaoException e) {
            log.error(e);
            return null;
        }
    }

    @Override
    public boolean selectComponent(int pcId, by.fpmibsu.PCBuilder.entity.component.RAM component) {
        PCDaoImpl dao = new PCDaoImpl();
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
        RAMDaoImpl dao = new RAMDaoImpl();
        try {
            return dao.findComponentById(componentId);
        } catch (DaoException e) {
            return null;
        }
    }
}
