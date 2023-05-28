package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.component.Component;

import java.util.List;

public interface PCServiceI {
    int getPrice(PC pc);

    PC getPC(int pcId);

    PC getPc(String login);
}