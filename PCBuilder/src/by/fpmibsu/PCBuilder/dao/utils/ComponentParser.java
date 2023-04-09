package by.fpmibsu.PCBuilder.dao.utils;

import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.component.*;
import by.fpmibsu.PCBuilder.entity.component.utils.Socket;
import netscape.javascript.JSObject;
import org.json.JSONObject;

public class ComponentParser {
    public Cooler parseCooler(String coolerJsonString){
        Cooler cooler = new Cooler();
        JSONObject coolerJson = new JSONObject(coolerJsonString);
        cooler.setId(coolerJson.getInt("id"));
        cooler.setPrice(coolerJson.getInt("price"));
        cooler.setName(coolerJson.getString("name"));
        cooler.setBrand(coolerJson.getString("brand"));
        cooler.setTDP(coolerJson.getInt("TDP"));
        cooler.setSocket(Socket.valueOf(coolerJson.getString("socket")));
        cooler.setDiameter(coolerJson.getInt("diameter"));
        return cooler;
    }

    public CPU parseCPU(String cpuJsonString){
        CPU cpu = new CPU();
        JSONObject cpuJson = new JSONObject(cpuJsonString);
        cpu.setId(cpuJson.getInt("id"));
        cpu.setPrice(cpuJson.getInt("price"));
        cpu.setName(cpuJson.getString("name"));
        cpu.setBrand(cpuJson.getString("brand"));
        cpu.setClockSpeed(cpuJson.getInt("clockSpeed"));
        cpu.setSocket(Socket.valueOf(cpuJson.getString("socket")));
        cpu.setTDP(cpuJson.getInt("TDP"));
        cpu.setCore(cpuJson.getInt("core"));
        return cpu;
    }

    public GPU parseGPU(String gpuJsonString){
        GPU gpu = new GPU();
        return  gpu;
    }

    public HDD parseHDD(String hddJsonString){
        HDD hdd = new HDD();
        return hdd;
    }

    public Motherboard parseMotherboard(String motherboardJsonString){
        Motherboard motherboard = new Motherboard();
        return motherboard;
    }

    public PCCase parsePCCase(String pcCaseJsonString){
        PCCase pcCase = new PCCase();
        return pcCase;
    }

    public PowerSupply parsePowerSupply(String powerSupplyJsonString){
        PowerSupply powerSupply = new PowerSupply();
        return powerSupply;
    }

    public RAM parseRAM(RAM ramJsonString){
        RAM ram = new RAM();
        return ram;
    }

    public ROM parseROM(ROM romJsonString){
        ROM rom = new ROM();
        return rom;
    }

    public SSD parseSSD(SSD ssdJsonString){
        SSD ssd  = new SSD();
        return ssd;
    }
}
