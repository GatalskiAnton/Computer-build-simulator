package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.GPUDaoImpl;
import by.fpmibsu.PCBuilder.dao.PCDaoImpl;
import by.fpmibsu.PCBuilder.entity.PC;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class GPUServiceImpl<GPU> implements ComponentService<by.fpmibsu.PCBuilder.entity.component.GPU> {
    private static Logger log = LogManager.getLogger(GPUServiceImpl.class);

    @Override
    public List<by.fpmibsu.PCBuilder.entity.component.GPU> getAllComponents() throws DaoException {
        log.info("GPUService calling getAllComponents");
        GPUDaoImpl gpuDao = new GPUDaoImpl();

        try {
            return gpuDao.findAll();
        } catch (DaoException e) {
            log.error(e);
            return null;
        }
    }

    @Override
    public boolean selectComponent(int pcId, by.fpmibsu.PCBuilder.entity.component.GPU component) {
        PCDaoImpl dao = new PCDaoImpl();
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
        GPUDaoImpl dao = new GPUDaoImpl();
        try {
            return dao.findComponentById(componentId);
        } catch (DaoException e) {
            return null;
        }
    }
}
