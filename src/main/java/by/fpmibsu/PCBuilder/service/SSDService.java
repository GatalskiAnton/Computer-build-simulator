package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.SSDDao;
import by.fpmibsu.PCBuilder.entity.component.SSD;

import java.util.ArrayList;
import java.util.List;

public class SSDService implements ComponentServiceI {
    @Override
    public List<SSD> getAllComponents() throws DaoException {
        SSDDao ssdDao = new SSDDao();
        return ssdDao.findAll();
    }
}
