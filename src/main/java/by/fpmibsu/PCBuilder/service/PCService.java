package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.PCDao;
import by.fpmibsu.PCBuilder.dao.UserDao;
import by.fpmibsu.PCBuilder.entity.PC;


public class PCService implements PCServiceI {

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
        PCDao pcDao = new PCDao();
        try {
            return pcDao.findPCById(pcId);
        } catch (DaoException e) {
            return null;
        }
    }

    @Override
    public PC getPc(String login) {
        UserDao userDao = new UserDao();
        try {
            return getPC(userDao.getPcById(userDao.findUserByLogin(login).getId()));
        } catch (DaoException e) {
            return  null;
        }
    }
}