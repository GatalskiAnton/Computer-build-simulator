package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.*;
import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.component.CPU;
import by.fpmibsu.PCBuilder.entity.component.HDD;
import by.fpmibsu.PCBuilder.entity.component.Motherboard;
import by.fpmibsu.PCBuilder.entity.component.utils.Socket;

import java.util.ArrayList;
import java.util.List;

public class MotherboardService<Motherboard> implements ComponentServiceI<by.fpmibsu.PCBuilder.entity.component.Motherboard> {
    @Override
    public List<by.fpmibsu.PCBuilder.entity.component.Motherboard> getAllComponents() throws DaoException {
        MotherboardDao motherboardDao = new MotherboardDao();
        return motherboardDao.findAll();
    }

    @Override
    public boolean selectComponent(int pcId, by.fpmibsu.PCBuilder.entity.component.Motherboard component) {
        PCDao dao = new PCDao();
        try {
            PC pc = dao.findPCById(pcId);
            pc.setMotherboard(component);
            dao.update(pc);
            return true;
        } catch (DaoException e) {
            return false;
        }
    }

    @Override
    public by.fpmibsu.PCBuilder.entity.component.Motherboard getComponentById(int componentId) {
        MotherboardDao dao = new MotherboardDao();
        try {
            return dao.findComponentById(componentId);
        } catch (DaoException e) {
            return null;
        }
    }

    public List<by.fpmibsu.PCBuilder.entity.component.Motherboard> getMotherboardsBySocket(Socket socket) throws DaoException {
        MotherboardDao motherboardDao = new MotherboardDao();
        return motherboardDao.findComponentBySocket(socket);
    }
}
