package by.fpmibsu.PCBuilder.test;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.entity.component.Cooler;
import by.fpmibsu.PCBuilder.entity.component.utils.Socket;
import by.fpmibsu.PCBuilder.service.CoolerService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoolerServiceTest {

    @Test(description = "Check getComponentByTDP with correct input ")
    public void testGetComponentByTDPWithCorrectInput() throws DaoException {
        CoolerService coolerService = new CoolerService();
        List<Cooler> coolers = coolerService.getCoolersByTDP(180);
        List<Cooler> expectedCoolers = new ArrayList<>(Arrays.asList(
                new Cooler(2, 61, "SE-214-XT ARGB Black", "ID-Cooling", Socket.AM4, 180, 120)));
        Assert.assertEquals(coolers, expectedCoolers);
    }

    @Test(description = "Check getComponentByTDP with incorrect input ")
    public void testGetComponentByTDPWithIncorrectInput() throws DaoException {
        CoolerService coolerService = new CoolerService();
        List<Cooler> coolers = coolerService.getCoolersByTDP(-123);
        List<Cooler> expectedCoolers = new ArrayList<>();
        Assert.assertEquals(coolers, expectedCoolers);
    }

    @Test(description = "Check getAllComponent")
    public void testGetAllComponent() throws DaoException {
        CoolerService coolerService = new CoolerService();
        List<Cooler> coolers = coolerService.getAllComponents();
        List<Cooler> expectedCoolers = new ArrayList<>(Arrays.asList(
                new Cooler(1, 219, "AK620 Zero Dark R-AK620-BKNNMT-G-1", "DeepCool", Socket.AM5, 260, 120),
                new Cooler(2, 61, "SE-214-XT ARGB Black", "ID-Cooling", Socket.AM4, 180, 120),
                new Cooler(3, 320, "Dark Rock Pro 4", "be quiet", Socket.LGA1700, 250, 120),
                new Cooler(4, 58, "GAMMAXX 300", "DeepCool", Socket.LGA1151, 130, 120),
                new Cooler(5, 41, "SE-903-XT", "ID-Cooling", Socket.LGA1200, 130, 92),
                new Cooler(6, 151, "SE-207-XT Black", "ID-Cooling", Socket.LGA1150, 280, 120),
                new Cooler(7, 455, "Pure Loop 360mm BW008", "be quiet", Socket.LGA2066, 300, 120),
                new Cooler(8, 259, "Le GRAND MACHO RT", "Thermalright", Socket.AM3, 320, 140),
                new Cooler(9, 494, "LS720 WH R-LS720-WHAMNT-G-1", "DeepCool", Socket.AM5, 340, 120),
                new Cooler(10, 374, "LT520 R-LT520-BKAMNF-G-1", "DeepCool", Socket.AM5, 340, 120)
        ));
        Assert.assertEquals(coolers, expectedCoolers);
    }

    @Test(description = "Check getComponentBySocket")
    public void testGetComponentBySocket() throws DaoException {
        CoolerService coolerService = new CoolerService();
        List<Cooler> coolers = coolerService.getCoolersBySocket(Socket.AM5);
        List<Cooler> expectedCoolers = new ArrayList<>(Arrays.asList(
                new Cooler(1, 219, "AK620 Zero Dark R-AK620-BKNNMT-G-1", "DeepCool", Socket.AM5, 260, 120),
                new Cooler(9, 494, "LS720 WH R-LS720-WHAMNT-G-1", "DeepCool", Socket.AM5, 340, 120),
                new Cooler(10, 374, "LT520 R-LT520-BKAMNF-G-1", "DeepCool", Socket.AM5, 340, 120)
        ));
        Assert.assertEquals(coolers, expectedCoolers);
    }
}
