package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.*;
import by.fpmibsu.PCBuilder.dao.utils.PCComponents;
import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.component.Motherboard;


public class PCServiceImpl implements PCService {

    @Override
    public int getPrice(PC pc) {
        int price = 0;
        price += pc.getCooler().getPrice();
        price += pc.getCpu().getPrice();
        price += pc.getGpu().getPrice();
        if (pc.getHdd() != null) {
            price += pc.getHdd().getPrice();
        }
        if (pc.getSsd() != null) {
            price += pc.getSsd().getPrice();
        }
        price += pc.getMotherboard().getPrice();
        price += pc.getPCCase().getPrice();
        price += pc.getPowerSupply().getPrice();
        price += pc.getRam().getPrice();
        return price;
    }

    @Override
    public PC getPC(int pcId) {
        PCDaoImpl pcDao = new PCDaoImpl();
        try {
            PCComponents c = pcDao.findPCById(pcId);
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
            return pc;
        } catch (DaoException e) {
            return null;
        }
    }

    @Override
    public PC getPc(String login) {
        UserDaoImpl userDao = new UserDaoImpl();
        try {
            return getPC(userDao.getPcById(userDao.findUserByLogin(login).getId()));
        } catch (DaoException e) {
            return  null;
        }
    }
}