package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.PCCaseDao;
import by.fpmibsu.PCBuilder.entity.component.PCCase;

import java.util.ArrayList;
import java.util.List;

public class PCCaseService implements ComponentServiceI {
    @Override
    public List<PCCase> getAllComponents() throws DaoException {
        PCCaseDao pcCaseDao = new PCCaseDao();
        return pcCaseDao.findAll();
    }
}
