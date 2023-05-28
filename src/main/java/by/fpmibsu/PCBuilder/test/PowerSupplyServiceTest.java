package by.fpmibsu.PCBuilder.test;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.entity.component.GPU;
import by.fpmibsu.PCBuilder.entity.component.PowerSupply;
import by.fpmibsu.PCBuilder.entity.component.utils.VideoMemoryType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import by.fpmibsu.PCBuilder.service.*;

public class PowerSupplyServiceTest {
    @Test(description = "Check getAllComponent")
    public void testGetComponentByTDPWithCorrectInput() throws DaoException {
        PowerSupplyService powerSupplyService = new PowerSupplyService();
        List<PowerSupply> powerSupplies = powerSupplyService.getAllComponents();
        List<PowerSupply> expectedPowerSupplies = new ArrayList<>(Arrays.asList(
                new PowerSupply(1, 360, "Leadex III Gold ARGB Pro 650W SF-650F14RG V2.0", "Super Flower", 650),
                new PowerSupply(2, 233, "PK800D", "DeepCool", 800),
                new PowerSupply(3, 172, "PF750", "DeepCool", 750),
                new PowerSupply(4, 243, "Core BBS-700S", "Chieftec", 700),
                new PowerSupply(5, 142, "Wattbit II ZM500-XEII", "Zalman", 500),
                new PowerSupply(6, 152, "PF600", "DeepCool", 600),
                new PowerSupply(7, 142, "PF550", "DeepCool", 550),
                new PowerSupply(8, 527, "Pure Power 12 M 850W BN344", "be quiet", 850)
        ));

        Assert.assertEquals(powerSupplies, expectedPowerSupplies);
    }
}
