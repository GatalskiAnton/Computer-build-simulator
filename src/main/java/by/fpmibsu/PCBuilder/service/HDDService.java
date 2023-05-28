package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.GPUDao;
import by.fpmibsu.PCBuilder.dao.HDDDao;
import by.fpmibsu.PCBuilder.dao.PCDao;
import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.component.HDD;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class HDDService<HDD> implements ComponentServiceI<by.fpmibsu.PCBuilder.entity.component.HDD> {
    private static Logger log = LogManager.getLogger(HDDService.class);

    @Override
    public List<by.fpmibsu.PCBuilder.entity.component.HDD> getAllComponents() throws DaoException {
        log.info("HDDService calling getAllComponents");
        HDDDao hddDao = new HDDDao();

        try {
            return hddDao.findAll();
        } catch (DaoException e) {
            log.error(e);
            return null;
        }
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
