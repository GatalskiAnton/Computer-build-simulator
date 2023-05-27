package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.CoolerDao;
import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.PCDao;
import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.component.Cooler;
import by.fpmibsu.PCBuilder.entity.component.utils.Socket;

import java.util.List;

public class CoolerService<Cooler> implements ComponentServiceI<by.fpmibsu.PCBuilder.entity.component.Cooler> {
    @Override
    public List<by.fpmibsu.PCBuilder.entity.component.Cooler> getAllComponents() throws DaoException {
        CoolerDao coolerDao = new CoolerDao();
        return coolerDao.findAll();
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
        CoolerDao coolerDao = new CoolerDao();
        return coolerDao.findComponentBySocket(socket);
    }

    public List<by.fpmibsu.PCBuilder.entity.component.Cooler> getCoolersByTDP(int TDP) throws DaoException {
        CoolerDao coolerDao = new CoolerDao();
        return coolerDao.findComponentByTDP(TDP);
    }
}
