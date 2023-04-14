//package main.java.by.fpmibsu.PCBuilder.dao.utils;
//import main.java.by.fpmibsu.PCBuilder.entity.*;
//import com.google.gson.*;
//
//
//public class ComponentParser {
//    public by.fpmibsu.PCBuilder.entity.component.Cooler parseCooler(String coolerJsonString){
//
//
//
//        GsonBuilder builder = new GsonBuilder();
//
//        Cooler cooler = new Cooler();
//        JSONObject coolerJson = new JSONObject(coolerJsonString);
//        cooler.setId(coolerJson.getInt("id"));
//        cooler.setPrice(coolerJson.getInt("price"));
//        cooler.setName(coolerJson.getString("name"));
//        cooler.setBrand(coolerJson.getString("brand"));
//        cooler.setTDP(coolerJson.getInt("TDP"));
//        cooler.setSocket(Socket.valueOf(coolerJson.getString("socket")));
//        cooler.setDiameter(coolerJson.getInt("diameter"));
//        return cooler;
//    }
//
//    public CPU parseCPU(String cpuJsonString){
//        CPU cpu = new CPU();
//        JSONObject cpuJson = new JSONObject(cpuJsonString);
//        cpu.setId(cpuJson.getInt("id"));
//        cpu.setPrice(cpuJson.getInt("price"));
//        cpu.setName(cpuJson.getString("name"));
//        cpu.setBrand(cpuJson.getString("brand"));
//        cpu.setClockSpeed(cpuJson.getInt("clockSpeed"));
//        cpu.setSocket(Socket.valueOf(cpuJson.getString("socket")));
//        cpu.setTDP(cpuJson.getInt("TDP"));
//        cpu.setCore(cpuJson.getInt("core"));
//        return cpu;
//    }
//
//    public GPU parseGPU(String gpuJsonString){
//        GPU gpu = new GPU();
//        JSONObject gpuJson = new JSONObject(gpuJsonString);
//        gpu.setId(gpuJson.getInt("id"));
//        gpu.setPrice(gpuJson.getInt("price"));
//        gpu.setName(gpuJson.getString("name"));
//        gpu.setBrand(gpuJson.getString("brand"));
//        gpu.setClockSpeed(gpuJson.getInt("clockSpeed"));
//        gpu.setVideoMemoryType(VideoMemoryType.valueOf(gpuJson.getString("videoMemoryType")));
//        gpu.setVideoMemory(gpuJson.getInt("videoMemory"));
//        return  gpu;
//    }
//
//    public HDD parseHDD(String hddJsonString){
//        HDD hdd = new HDD();
//        JSONObject hddJson = new JSONObject(hddJsonString);
//        hdd.setId(hddJson.getInt("id"));
//        hdd.setPrice(hddJson.getInt("price"));
//        hdd.setName(hddJson.getString("name"));
//        hdd.setBrand(hddJson.getString("brand"));
//        hdd.setCapacity(hddJson.getInt("capacity"));
//        return hdd;
//    }
//
//    public Motherboard parseMotherboard(String motherboardJsonString){
//        Motherboard motherboard = new Motherboard();
//        JSONObject motherboardJson = new JSONObject(motherboardJsonString);
//        motherboard.setId(motherboardJson.getInt("id"));
//        motherboard.setPrice(motherboardJson.getInt("price"));
//        motherboard.setName(motherboardJson.getString("name"));
//        motherboard.setBrand(motherboardJson.getString("brand"));
//        motherboard.setSocket(Socket.valueOf(motherboardJson.getString("socket")));
//        return motherboard;
//    }
//
//    public PCCase parsePCCase(String pcCaseJsonString){
//        PCCase pcCase = new PCCase();
//        JSONObject pcCaseJson = new JSONObject(pcCaseJsonString);
//        pcCase.setId(pcCaseJson.getInt("id"));
//        pcCase.setPrice(pcCaseJson.getInt("price"));
//        pcCase.setName(pcCaseJson.getString("name"));
//        pcCase.setBrand(pcCaseJson.getString("brand"));
//        pcCase.setColor(Color.valueOf(pcCaseJson.getString("color")));
//        return pcCase;
//    }
//
//    public PowerSupply parsePowerSupply(String powerSupplyJsonString){
//        PowerSupply powerSupply = new PowerSupply();
//        JSONObject pcCaseJson = new JSONObject(powerSupplyJsonString);
//        powerSupply.setId(pcCaseJson.getInt("id"));
//        powerSupply.setPrice(pcCaseJson.getInt("price"));
//        powerSupply.setName(pcCaseJson.getString("name"));
//        powerSupply.setBrand(pcCaseJson.getString("brand"));
//        powerSupply.setPower(pcCaseJson.getInt("power"));
//        return powerSupply;
//    }
//
//    public RAM parseRAM(String ramJsonString){
//        RAM ram = new RAM();
//        JSONObject ramJson = new JSONObject(ramJsonString);
//        ram.setId(ramJson.getInt("id"));
//        ram.setPrice(ramJson.getInt("price"));
//        ram.setName(ramJson.getString("name"));
//        ram.setBrand(ramJson.getString("brand"));
//        ram.setSpeed(ramJson.getInt("speed"));
//        ram.setMemoryType(MemoryType.valueOf(ramJson.getString("memoryType")));
//        return ram;
//    }
//
//
//    public SSD parseSSD(String ssdJsonString){
//        SSD ssd  = new SSD();
//        JSONObject ssdJson = new JSONObject(ssdJsonString);
//        ssd.setId(ssdJson.getInt("id"));
//        ssd.setPrice(ssdJson.getInt("price"));
//        ssd.setName(ssdJson.getString("name"));
//        ssd.setBrand(ssdJson.getString("brand"));
//        ssd.setCapacity(ssdJson.getInt("capacity"));
//        return ssd;
//    }
//}
