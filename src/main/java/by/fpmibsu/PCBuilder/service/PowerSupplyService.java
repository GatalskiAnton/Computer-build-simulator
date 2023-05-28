package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.PCCaseDao;
import by.fpmibsu.PCBuilder.dao.PCDao;
import by.fpmibsu.PCBuilder.dao.PowerSupplyDao;
import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.component.PowerSupply;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PowerSupplyService<PowerSupply> implements ComponentServiceI<by.fpmibsu.PCBuilder.entity.component.PowerSupply> {
    private static Logger log = LogManager.getLogger(PowerSupplyService.class);

    @Override
    public List<by.fpmibsu.PCBuilder.entity.component.PowerSupply> getAllComponents() throws DaoException {
        log.info("PCCaseService calling getAllComponents");
        PowerSupplyDao powerSupplyDao = new PowerSupplyDao();

        try {
            return powerSupplyDao.findAll();
        } catch (DaoException e) {
            log.error(e);
            return null;
        }
    }

    @Override
    public boolean selectComponent(int pcId, by.fpmibsu.PCBuilder.entity.component.PowerSupply component) {
        PCDao dao = new PCDao();
        try {
            PC pc = dao.findPCById(pcId);
            pc.setPowerSupply(component);
            dao.update(pc);
            return true;
        } catch (DaoException e) {
            return false;
        }
    }

    @Override
    public by.fpmibsu.PCBuilder.entity.component.PowerSupply getComponentById(int componentId) {
        PowerSupplyDao dao = new PowerSupplyDao();
        try {
            return dao.findComponentById(componentId);
        } catch (DaoException e) {
            return null;
        }
    }
}
