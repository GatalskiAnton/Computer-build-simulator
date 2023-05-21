package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.CPUDao;
import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.HDDDao;
import by.fpmibsu.PCBuilder.dao.MotherboardDao;
import by.fpmibsu.PCBuilder.entity.component.CPU;
import by.fpmibsu.PCBuilder.entity.component.HDD;
import by.fpmibsu.PCBuilder.entity.component.Motherboard;
import by.fpmibsu.PCBuilder.entity.component.utils.Socket;

import java.util.ArrayList;
import java.util.List;

public class MotherboardService implements ComponentServiceI {
    @Override
    public List<Motherboard> getAllComponents() throws DaoException {
        MotherboardDao motherboardDao = new MotherboardDao();
        return motherboardDao.findAll();
    }

    public List<Motherboard> getMotherboardsBySocket(Socket socket) throws DaoException {
        MotherboardDao motherboardDao = new MotherboardDao();
        return motherboardDao.findComponentBySocket(socket);
    }
}
