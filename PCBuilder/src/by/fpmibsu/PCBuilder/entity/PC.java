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

    private GPU gpu;

    public PC(Case pcCase, Cooler cooler, CPU cpu, ROM rom, RAM ram, Motherboard motherboard, PowerSupply powerSupply, GPU gpu) {
        PCCase = pcCase;
        this.cooler = cooler;
        this.cpu = cpu;
        this.rom = rom;
        this.ram = ram;
        this.motherboard = motherboard;
        this.powerSupply = powerSupply;
        this.gpu = gpu;
    }
}

