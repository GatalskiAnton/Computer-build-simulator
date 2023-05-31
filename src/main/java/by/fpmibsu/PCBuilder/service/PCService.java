package by.fpmibsu.PCBuilder.service;

import by.fpmibsu.PCBuilder.entity.PC;

public interface PCService {
    int getPrice(PC pc);

    PC getPC(int pcId);

    PC getPc(String login);
}