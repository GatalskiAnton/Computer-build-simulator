package by.fpmibsu.PCBuilder.service;

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
}
