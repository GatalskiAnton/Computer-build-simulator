package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.HDDDao;
import by.fpmibsu.PCBuilder.entity.component.HDD;

import java.util.ArrayList;
import java.util.List;

public class HDDService implements ComponentServiceI {
    @Override
    public List<HDD> getAllComponents() throws DaoException {
        HDDDao hddDao = new HDDDao();
        return hddDao.findAll();
    }
}
