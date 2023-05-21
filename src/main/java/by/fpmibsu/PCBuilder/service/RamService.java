package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.RAMDao;
import by.fpmibsu.PCBuilder.entity.component.RAM;

import java.util.ArrayList;
import java.util.List;

public class RamService implements ComponentServiceI {
    @Override
    public List<RAM> getAllComponents() throws DaoException {
        RAMDao ramDao = new RAMDao();
        return ramDao.findAll();
    }
}
