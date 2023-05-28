package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.CPUDao;
import by.fpmibsu.PCBuilder.dao.CoolerDao;
import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.PCDao;
import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.component.CPU;
import by.fpmibsu.PCBuilder.entity.component.Component;
import by.fpmibsu.PCBuilder.entity.component.Cooler;
import by.fpmibsu.PCBuilder.entity.component.utils.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CPUService<CPU> implements ComponentServiceI<by.fpmibsu.PCBuilder.entity.component.CPU> {
    private static Logger log = LogManager.getLogger(CPUService.class);

    @Override
    public List<by.fpmibsu.PCBuilder.entity.component.CPU> getAllComponents() throws DaoException {
        log.info("CPUService calling getAllComponents");
        CPUDao cpuDao = new CPUDao();

        try {
            return cpuDao.findAll();
        } catch (DaoException e) {
            log.error(e);
            return null;
        }
    }

    @Override
    public boolean selectComponent(int pcId, by.fpmibsu.PCBuilder.entity.component.CPU component) {
        PCDao dao = new PCDao();
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
        CPUDao dao = new CPUDao();
        try {
            return dao.findComponentById(componentId);
        } catch (DaoException e) {
            return null;
        }
    }

    public List<by.fpmibsu.PCBuilder.entity.component.CPU> getCPUsBySocket(Socket socket) throws DaoException {
        log.info("CPUService calling getCPUsBySocket");

        CPUDao cpuDao = new CPUDao();
        try {
            return cpuDao.findComponentBySocket(socket);
        } catch (DaoException e) {
            log.error(e);
            return null;
        }
    }

    public List<by.fpmibsu.PCBuilder.entity.component.CPU> getCPUsByTDP(int TDP) throws DaoException {
        log.info("CPUService calling getCPUsByTDP");

        CPUDao cpuDao = new CPUDao();
        try {
            return cpuDao.findComponentByTDP(TDP);
        } catch (DaoException e) {
            log.error(e);
            return null;
        }
    }
}
