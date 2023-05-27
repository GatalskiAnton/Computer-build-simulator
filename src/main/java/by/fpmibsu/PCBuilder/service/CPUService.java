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

import java.util.ArrayList;
import java.util.List;

public class CPUService<CPU> implements ComponentServiceI<by.fpmibsu.PCBuilder.entity.component.CPU> {
    @Override
    public List<by.fpmibsu.PCBuilder.entity.component.CPU> getAllComponents() throws DaoException {
        CPUDao cpuDao = new CPUDao();
        return cpuDao.findAll();
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
        CPUDao cpuDao = new CPUDao();
        return cpuDao.findComponentBySocket(socket);
    }

    public List<by.fpmibsu.PCBuilder.entity.component.CPU> getCPUsByTDP(int TDP) throws DaoException {
        CPUDao cpuDao = new CPUDao();
        return cpuDao.findComponentByTDP(TDP);
    }
}
