package by.fpmibsu.PCBuilder.entity;

import by.fpmibsu.PCBuilder.entity.component.*;

import java.util.Objects;

public class PC {

    private int id;

    private int userId;

    private PCCase PCCase;
    private Cooler cooler;
    private CPU cpu;

    private SSD ssd;

    private HDD hdd;
    private RAM ram;
    private Motherboard motherboard;
    private PowerSupply powerSupply;

    private GPU gpu;

    public PC(int userId, PCCase pcCase, Cooler cooler, CPU cpu, SSD ssd, HDD hdd, RAM ram, Motherboard motherboard, PowerSupply powerSupply, GPU gpu) {
        this.userId = userId;
        this.PCCase = pcCase;
        this.cooler = cooler;
        this.cpu = cpu;
        this.ssd = ssd;
        this.hdd = hdd;
        this.ram = ram;
        this.motherboard = motherboard;
        this.powerSupply = powerSupply;
        this.gpu = gpu;
    }

    public PC() {
        this.PCCase = null;
        this.cooler = null;
        this.cpu = null;
        this.ssd = null;
        this.hdd = null;
        this.ram = null;
        this.motherboard = null;
        this.powerSupply = null;
        this.gpu = null;
    }

    public PCCase getPCCase() {
        return PCCase;
    }

    public void setPCCase(PCCase PCCase) {
        this.PCCase = PCCase;
    }

    public Cooler getCooler() {
        return cooler;
    }

    public void setCooler(Cooler cooler) {
        this.cooler = cooler;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public SSD getSsd() {
        return ssd;
    }

    public void setSsd(SSD ssd) {
        this.ssd = ssd;
    }

    public HDD getHdd() {
        return hdd;
    }

    public void setHdd(HDD hdd) {
        this.hdd = hdd;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    public PowerSupply getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(PowerSupply powerSupply) {
        this.powerSupply = powerSupply;
    }

    public GPU getGpu() {
        return gpu;
    }

    public void setGpu(GPU gpu) {
        this.gpu = gpu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PC pc = (PC) o;
        return id == pc.id && userId == pc.userId && Objects.equals(PCCase, pc.PCCase) && Objects.equals(cooler, pc.cooler) && Objects.equals(cpu, pc.cpu) && Objects.equals(ssd, pc.ssd) && Objects.equals(hdd, pc.hdd) && Objects.equals(ram, pc.ram) && Objects.equals(motherboard, pc.motherboard) && Objects.equals(powerSupply, pc.powerSupply) && Objects.equals(gpu, pc.gpu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, PCCase, cooler, cpu, ssd, hdd, ram, motherboard, powerSupply, gpu);
    }

    @Override
    public String toString() {
        return "PC{" +
                "id=" + id +
                ", PCCase=" + PCCase +
                ", cooler=" + cooler +
                ", cpu=" + cpu +
                ", hhd=" + hdd +
                ", ssd=" + ssd +
                ", ram=" + ram +
                ", motherboard=" + motherboard +
                ", powerSupply=" + powerSupply +
                ", gpu=" + gpu +
                '}';
    }
}

