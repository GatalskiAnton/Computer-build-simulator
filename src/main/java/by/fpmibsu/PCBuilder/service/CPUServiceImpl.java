package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.CPUDaoImpl;
import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.PCDaoImpl;
import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.component.utils.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CPUServiceImpl<CPU> implements ComponentService<by.fpmibsu.PCBuilder.entity.component.CPU> {
    private static Logger log = LogManager.getLogger(CPUServiceImpl.class);

    @Override
    public List<by.fpmibsu.PCBuilder.entity.component.CPU> getAllComponents() throws DaoException {
        log.info("CPUService calling getAllComponents");
        CPUDaoImpl cpuDao = new CPUDaoImpl();

        try {
            return cpuDao.findAll();
        } catch (DaoException e) {
            log.error(e);
            return null;
        }
    }

    @Override
    public boolean selectComponent(int pcId, by.fpmibsu.PCBuilder.entity.component.CPU component) {
        PCDaoImpl dao = new PCDaoImpl();
        try {
            PC pc = dao.findPCById(pcId);
            pc.setCpu(component);
            dao.update(pc);
            return true;
        } catch (DaoException e) {
            return false;
        }
    }

    @Override
    public by.fpmibsu.PCBuilder.entity.component.CPU getComponentById(int componentId) {
        CPUDaoImpl dao = new CPUDaoImpl();
        try {
            return dao.findComponentById(componentId);
        } catch (DaoException e) {
            return null;
        }
    }

    public List<by.fpmibsu.PCBuilder.entity.component.CPU> getCPUsBySocket(Socket socket) throws DaoException {
        log.info("CPUService calling getCPUsBySocket");

        CPUDaoImpl cpuDao = new CPUDaoImpl();
        try {
            return cpuDao.findComponentBySocket(socket);
        } catch (DaoException e) {
            log.error(e);
            return null;
        }
    }

    public List<by.fpmibsu.PCBuilder.entity.component.CPU> getCPUsByTDP(int TDP) throws DaoException {
        log.info("CPUService calling getCPUsByTDP");

        CPUDaoImpl cpuDao = new CPUDaoImpl();
        try {
            return cpuDao.findComponentByTDP(TDP);
        } catch (DaoException e) {
            log.error(e);
            return null;
        }
    }
}
