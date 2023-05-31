package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.*;
import by.fpmibsu.PCBuilder.dao.utils.PCComponents;
import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.component.utils.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CoolerServiceImpl<Cooler> implements ComponentService<by.fpmibsu.PCBuilder.entity.component.Cooler> {
    private static Logger log = LogManager.getLogger(CoolerServiceImpl.class);

    @Override
    public List<by.fpmibsu.PCBuilder.entity.component.Cooler> getAllComponents() throws DaoException {
        log.info("CoolerService calling getAllComponents");
        CoolerDaoImpl coolerDao = new CoolerDaoImpl();
        try {
            return coolerDao.findAll();
        } catch (DaoException e) {
            log.error(e);
            return null;
        }
    }

    @Override
    public boolean selectComponent(int pcId, by.fpmibsu.PCBuilder.entity.component.Cooler component) {
        PCDaoImpl dao = new PCDaoImpl();
        try {
            PCComponents c = dao.findPCById(pcId);
            c.setCoolerID(component.getId());
            PC pc = new PC();
            pc.setId(c.getId());
            pc.setUserId(c.getUserID());
            pc.setCooler(new CoolerDaoImpl().findComponentById(c.getCoolerID()));
            pc.setCpu(new CPUDaoImpl().findComponentById(c.getCPUID()));
            pc.setGpu(new GPUDaoImpl().findComponentById(c.getGPUID()));
            pc.setHdd(new HDDDaoImpl().findComponentById(c.getHDDID()));
            pc.setMotherboard(new MotherboardDaoImpl().findComponentById(c.getMotherBoardID()));
            pc.setPCCase(new PCCaseDaoImpl().findComponentById(c.getPcCaseID()));
            pc.setPowerSupply(new PowerSupplyDaoImpl().findComponentById(c.getPowerSupplyID()));
            pc.setRam(new RAMDaoImpl().findComponentById(c.getRAMID()));
            pc.setSsd(new SSDDaoImpl().findComponentById(c.getSSDID()));
            dao.update(pc);
            return true;
        } catch (DaoException e) {
            return false;
        }
    }

    @Override
    public by.fpmibsu.PCBuilder.entity.component.Cooler getComponentById(int componentId) {
        CoolerDaoImpl dao = new CoolerDaoImpl();
        try {
            return dao.findComponentById(componentId);
        } catch (DaoException e) {
            return null;
        }
    }

    public List<by.fpmibsu.PCBuilder.entity.component.Cooler> getCoolersBySocket(Socket socket) throws DaoException {
        log.info("CoolerService calling getCoolersBySocket");
        CoolerDaoImpl coolerDao = new CoolerDaoImpl();
        try {
            return coolerDao.findComponentBySocket(socket);
        } catch (DaoException e) {
            log.error(e);
            return null;
        }
    }

    public List<by.fpmibsu.PCBuilder.entity.component.Cooler> getCoolersByTDP(int TDP) throws DaoException {
        log.info("CoolerService calling getCoolersByTDP");
        CoolerDaoImpl coolerDao = new CoolerDaoImpl();
        try {
            return coolerDao.findComponentByTDP(TDP);
        } catch (DaoException e) {
            log.error(e);
            return null;
        }
    }
}
