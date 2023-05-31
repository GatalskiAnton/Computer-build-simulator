package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.CoolerDaoImpl;
import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.PCDaoImpl;
import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.component.utils.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CoolerServiceImpl<Cooler> implements ComponentService<by.fpmibsu.PCBuilder.entity.component.Cooler> {
    private static Logger log = LogManager.getLogger(CoolerServiceImpl.class);

    @Override
    public List<by.fpmibsu.PCBuilder.entity.component.Cooler> getAllComponents() throws DaoException {
        log.info("CoolerService calling getAllComponents");
        CoolerDaoImpl coolerDao = new CoolerDaoImpl();
        try {
            return coolerDao.findAll();
        } catch (DaoException e) {
            log.error(e);
            return null;
        }
    }

    @Override
    public boolean selectComponent(int pcId, by.fpmibsu.PCBuilder.entity.component.Cooler component) {
        PCDaoImpl dao = new PCDaoImpl();
        try {
            PC pc = dao.findPCById(pcId);
            pc.setCooler((component));
            dao.update(pc);
            return true;
        } catch (DaoException e) {
            return false;
        }
    }

    @Override
    public by.fpmibsu.PCBuilder.entity.component.Cooler getComponentById(int componentId) {
        CoolerDaoImpl dao = new CoolerDaoImpl();
        try {
            return dao.findComponentById(componentId);
        } catch (DaoException e) {
            return null;
        }
    }

    public List<by.fpmibsu.PCBuilder.entity.component.Cooler> getCoolersBySocket(Socket socket) throws DaoException {
        log.info("CoolerService calling getCoolersBySocket");
        CoolerDaoImpl coolerDao = new CoolerDaoImpl();
        try {
            return coolerDao.findComponentBySocket(socket);
        } catch (DaoException e) {
            log.error(e);
            return null;
        }
    }

    public List<by.fpmibsu.PCBuilder.entity.component.Cooler> getCoolersByTDP(int TDP) throws DaoException {
        log.info("CoolerService calling getCoolersByTDP");
        CoolerDaoImpl coolerDao = new CoolerDaoImpl();
        try {
            return coolerDao.findComponentByTDP(TDP);
        } catch (DaoException e) {
            log.error(e);
            return null;
        }
    }
}
