package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.CPUDao;
import by.fpmibsu.PCBuilder.dao.CoolerDao;
import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.entity.component.CPU;
import by.fpmibsu.PCBuilder.entity.component.Cooler;
import by.fpmibsu.PCBuilder.entity.component.utils.Socket;

import java.util.ArrayList;
import java.util.List;

public class CPUService implements ComponentServiceI {
    @Override
    public List<CPU> getAllComponents() throws DaoException {
        CPUDao cpuDao = new CPUDao();
        return cpuDao.findAll();
    }

    public List<CPU> getCPUsBySocket(Socket socket) throws DaoException {
        CPUDao cpuDao = new CPUDao();
        return cpuDao.findComponentBySocket(socket);
    }

    public List<CPU> getCPUsByTDP(int TDP) throws DaoException {
        CPUDao cpuDao = new CPUDao();
        return cpuDao.findComponentByTDP(TDP);
    }
}
