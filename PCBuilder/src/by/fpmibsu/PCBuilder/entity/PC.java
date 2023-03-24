package by.fpmibsu.PCBuilder.entity;

import by.fpmibsu.PCBuilder.entity.component.*;


public class PC {
    private Case PCCase;
    private Cooler cooler;
    private CPU cpu;

    private ROM rom;
    private RAM ram;
    private Motherboard motherboard;
    private PowerSupply powerSupply;

    public PC(Case PCCase, Cooler cooler, CPU cpu, ROM rom, RAM ram, Motherboard motherboard, PowerSupply powerSupply) {
        this.PCCase = PCCase;
        this.cooler = cooler;
        this.cpu = cpu;
        this.rom = rom;
        this.ram = ram;
        this.motherboard = motherboard;
        this.powerSupply = powerSupply;
    }
}

