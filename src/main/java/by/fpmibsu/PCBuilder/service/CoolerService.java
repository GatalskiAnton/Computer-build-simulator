package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.CoolerDao;
import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.entity.component.Cooler;
import by.fpmibsu.PCBuilder.entity.component.utils.Socket;

import java.util.ArrayList;
import java.util.List;

public class CoolerService implements ComponentServiceI {
    @Override
    public List<Cooler> getAllComponents() throws DaoException {
        CoolerDao coolerDao = new CoolerDao();
        return coolerDao.findAll();
    }

    public List<Cooler> getCoolersBySocket(Socket socket) throws DaoException {
        CoolerDao coolerDao = new CoolerDao();
        return coolerDao.findComponentBySocket(socket);
    }

    public List<Cooler> getCoolersByTDP(int TDP) throws DaoException {
        CoolerDao coolerDao = new CoolerDao();
        return coolerDao.findComponentByTDP(TDP);
    }
}
