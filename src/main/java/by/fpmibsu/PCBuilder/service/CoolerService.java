package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.CoolerDao;
import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.PCDao;
import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.component.Cooler;
import by.fpmibsu.PCBuilder.entity.component.utils.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CoolerService<Cooler> implements ComponentServiceI<by.fpmibsu.PCBuilder.entity.component.Cooler> {
    private static Logger log = LogManager.getLogger(CoolerService.class);

    @Override
    public List<by.fpmibsu.PCBuilder.entity.component.Cooler> getAllComponents() throws DaoException {
        log.info("CoolerService calling getAllComponents");
        CoolerDao coolerDao = new CoolerDao();
        try {
            return coolerDao.findAll();
        } catch (DaoException e) {
            log.error(e);
            return null;
        }
    }

    @Override
    public boolean selectComponent(int pcId, by.fpmibsu.PCBuilder.entity.component.Cooler component) {
        PCDao dao = new PCDao();
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
        CoolerDao dao = new CoolerDao();
        try {
            return dao.findComponentById(componentId);
        } catch (DaoException e) {
            return null;
        }
    }

    public List<by.fpmibsu.PCBuilder.entity.component.Cooler> getCoolersBySocket(Socket socket) throws DaoException {
        log.info("CoolerService calling getCoolersBySocket");
        CoolerDao coolerDao = new CoolerDao();
        try {
            return coolerDao.findComponentBySocket(socket);
        } catch (DaoException e) {
            log.error(e);
            return null;
        }
    }

    public List<by.fpmibsu.PCBuilder.entity.component.Cooler> getCoolersByTDP(int TDP) throws DaoException {
        log.info("CoolerService calling getCoolersByTDP");
        CoolerDao coolerDao = new CoolerDao();
        try {
            return coolerDao.findComponentByTDP(TDP);
        } catch (DaoException e) {
            log.error(e);
            return null;
        }
    }
}
