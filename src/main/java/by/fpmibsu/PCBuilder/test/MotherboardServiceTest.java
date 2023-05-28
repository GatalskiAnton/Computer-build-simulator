package by.fpmibsu.PCBuilder.test;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.entity.component.CPU;
import by.fpmibsu.PCBuilder.entity.component.HDD;
import by.fpmibsu.PCBuilder.entity.component.Motherboard;
import by.fpmibsu.PCBuilder.entity.component.utils.Socket;
import by.fpmibsu.PCBuilder.service.CPUService;
import by.fpmibsu.PCBuilder.service.HDDService;
import by.fpmibsu.PCBuilder.service.MotherboardService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MotherboardServiceTest {
    @Test(description = "Check getAllComponent")
    public void testGetAllComponent() throws DaoException {
        MotherboardService motherboardService = new MotherboardService();
        List<Motherboard> motherboards = motherboardService.getAllComponents();
        List<Motherboard> expectedMotherboards = new ArrayList<>(Arrays.asList(
                new Motherboard(1, 376, "B550M Pro4", "ASRock", Socket.AM4),
                new Motherboard(2, 597, "B550M Pro4", "Gigabyte", Socket.AM5),
                new Motherboard(3, 418, "B550M Pro4", "ASRock", Socket.LGA1700),
                new Motherboard(4, 200, "B550M Pro4", "ASRock", Socket.AM3),
                new Motherboard(5, 378, "B550M Pro4", "MSI", Socket.LGA1200),
                new Motherboard(6, 279, "B550M Pro4", "Tecmiyo", Socket.LGA1151),
                new Motherboard(7, 310, "B550M Pro4", "BIOSTAR", Socket.LGA1150),
                new Motherboard(8, 1232, "B550M Pro4", "ASUS", Socket.LGA2066)

        ));
        Assert.assertEquals(motherboards, expectedMotherboards);
    }

    @Test(description = "Check getComponentBySocket")
    public void testGetComponentBySocket() throws DaoException {
        MotherboardService motherboardService = new MotherboardService();
        List<Motherboard> motherboards = motherboardService.getMotherboardsBySocket(Socket.AM4);
        List<Motherboard> expectedMotherboards = new ArrayList<>(Arrays.asList(
                new Motherboard(1, 376, "B550M Pro4", "ASRock", Socket.AM4)

        ));
        Assert.assertEquals(motherboards, expectedMotherboards);
    }
}
