package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.CPUDao;
import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.GPUDao;
import by.fpmibsu.PCBuilder.dao.PCDao;
import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.component.CPU;
import by.fpmibsu.PCBuilder.entity.component.Component;
import by.fpmibsu.PCBuilder.entity.component.GPU;

import java.util.ArrayList;
import java.util.List;

public class GPUService<GPU> implements ComponentServiceI<by.fpmibsu.PCBuilder.entity.component.GPU> {
    @Override
    public List<by.fpmibsu.PCBuilder.entity.component.GPU> getAllComponents() throws DaoException {
        GPUDao gpuDao = new GPUDao();
        return gpuDao.findAll();
    }

    @Override
    public boolean selectComponent(int pcId, by.fpmibsu.PCBuilder.entity.component.GPU component) {
        PCDao dao = new PCDao();
        try {
            PC pc = dao.findPCById(pcId);
            pc.setGpu(component);
            dao.update(pc);
            return true;
        } catch (DaoException e) {
            return false;
        }
    }

    @Override
    public by.fpmibsu.PCBuilder.entity.component.GPU getComponentById(int componentId) {
        GPUDao dao = new GPUDao();
        try {
            return dao.findComponentById(componentId);
        } catch (DaoException e) {
            return null;
        }
    }
}
