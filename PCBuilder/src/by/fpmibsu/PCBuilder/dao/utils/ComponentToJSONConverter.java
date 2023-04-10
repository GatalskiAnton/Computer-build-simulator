package by.fpmibsu.PCBuilder.dao.utils;

import by.fpmibsu.PCBuilder.entity.component.CPU;
import by.fpmibsu.PCBuilder.entity.component.Cooler;
import by.fpmibsu.PCBuilder.entity.component.GPU;
import by.fpmibsu.PCBuilder.entity.component.Motherboard;
import by.fpmibsu.PCBuilder.entity.component.PCCase;
import by.fpmibsu.PCBuilder.entity.component.PowerSupply;
import by.fpmibsu.PCBuilder.entity.component.RAM;
import by.fpmibsu.PCBuilder.entity.component.ROM;

public class ComponentToJSONConverter {

    public static String PowerSupplyToJSON(PowerSupply object) {
        return "{\"id\": \"" + object.getId() + "\", " +
                "\"name\": \"" + object.getName() + "\", " +
                "\"brand\": \"" + object.getBrand() + "\", " +
                "\"power\": " + object.getPower() + ", " +
                "\"price\": " + object.getPrice() + "}";
    }

    public static String ROMToJSON(ROM object) {
        return "{\"id\": \"" + object.getId() + "\", " +
                "\"name\": \"" + object.getName() + "\", " +
                "\"brand\": \"" + object.getBrand() + "\", " +
                "\"price\": " + object.getPrice() + ", " +
                "\"capacity\": " + object.getCapacity() + "}";
    }

    public static String PCCaseToJSON(PCCase object) {
        return "{\"id\": \"" + object.getId() + "\", " +
                "\"name\": \"" + object.getName() + "\", " +
                "\"brand\": \"" + object.getBrand() + "\", " +
                "\"color\": " + "\"" + object.getColor() + "\", " +
                "\"price\": " + object.getPrice() + "}";
    }

    public static String MotherboardToJSON(Motherboard object) {
        return "{\"id\": \"" + object.getId() + "\", " +
                "\"name\": \"" + object.getName() + "\", " +
                "\"brand\": \"" + object.getBrand() + "\", " +
                "\"price\": " + object.getPrice() + ", " +
                "\"socket\": " + "\"" + object.getSocket() + "\"}";
    }

    public static String GPUToJSON(GPU object) {
        return "{\"id\": \"" + object.getId() + "\", " +
                "\"name\": \"" + object.getName() + "\", " +
                "\"brand\": \"" + object.getBrand() + "\", " +
                "\"price\": " + object.getPrice() + ", " +
                "\"clockSpeed\": " + object.getClockSpeed() + ", " +
                "\"videoMemory\": " + object.getVideoMemory() + ", " +
                "\"videoMemoryType\": " + "\"" + object.getVideoMemoryType() + "\"}";
    }

    public static String CPUToJSON(CPU object) {
        return "{\"id\": \"" + object.getId() + "\", " +
                "\"TDP\": " + object.getTDP() + ", " +
                "\"core\": " + object.getCore() + ", " +
                "\"name\": \"" + object.getName() + "\", " +
                "\"brand\": \"" + object.getBrand() + "\", " +
                "\"price\": " + object.getPrice() + ", " +
                "\"socket\": " + "\"" + object.getSocket() + "\", " +
                "\"clockSpeed\": " + object.getClockSpeed() + "}";
    }

    public static String CoolerToJSON(Cooler object) {
        return "{\"id\": \"" + object.getId() + "\", " +
                "\"TDP\": " + object.getTDP() + ", " +
                "\"name\": \"" + object.getName() + "\", " +
                "\"brand\": \"" + object.getBrand() + "\", " +
                "\"price\": " + object.getPrice() + ", " +
                "\"socket\": " + "\"" + object.getSocket() + "\", " +
                "\"diameter\": " + object.getDiameter() + "}";
    }

    public static String RAMToJSON(RAM object) {
        return "{\"id\": \"" + object.getId() + "\", " +
                "\"name\": \"" + object.getName() + "\", " +
                "\"brand\": \"" + object.getBrand() + "\", " +
                "\"price\": " + object.getPrice() + ", " +
                "\"speed\": " + object.getSpeed() + ", " +
                "\"memoryType\": " + "\"" + object.getMemoryType() + "\"}";
    }
}
