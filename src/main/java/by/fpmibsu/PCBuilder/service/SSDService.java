package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.PCDao;
import by.fpmibsu.PCBuilder.dao.RAMDao;
import by.fpmibsu.PCBuilder.dao.SSDDao;
import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.component.SSD;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SSDService<SSD> implements ComponentServiceI<by.fpmibsu.PCBuilder.entity.component.SSD> {
    private static Logger log = LogManager.getLogger(SSDService.class);

    @Override
    public List<by.fpmibsu.PCBuilder.entity.component.SSD> getAllComponents() throws DaoException {
        log.info("PCCaseService calling getAllComponents");
        SSDDao ssdDao = new SSDDao();

        try {
            return ssdDao.findAll();
        } catch (DaoException e) {
            log.error(e);
            return null;
        }
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
