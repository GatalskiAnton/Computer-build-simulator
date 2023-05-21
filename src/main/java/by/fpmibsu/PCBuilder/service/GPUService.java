package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.GPUDao;
import by.fpmibsu.PCBuilder.entity.component.GPU;

import java.util.ArrayList;
import java.util.List;

public class GPUService implements ComponentServiceI {
    @Override
    public List<GPU> getAllComponents() throws DaoException {
        GPUDao gpuDao = new GPUDao();
        return gpuDao.findAll();
    }
}
