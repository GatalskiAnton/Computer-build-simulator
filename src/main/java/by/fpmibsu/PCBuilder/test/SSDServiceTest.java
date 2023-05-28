package by.fpmibsu.PCBuilder.test;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.entity.component.RAM;
import by.fpmibsu.PCBuilder.entity.component.SSD;
import by.fpmibsu.PCBuilder.entity.component.utils.MemoryType;
import by.fpmibsu.PCBuilder.service.RamService;
import by.fpmibsu.PCBuilder.service.SSDService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SSDServiceTest {
    @Test(description = "Check getAllComponent")
    public void testGetComponentByTDPWithCorrectInput() throws DaoException {
        SSDService ssdService = new SSDService();
        List<SSD> ssds = ssdService.getAllComponents();
        List<SSD> expectedSsds = new ArrayList<>(Arrays.asList(
                new SSD(1, 52, "AS350 256GB AP256GAS350-1", "Apacer Panther", 256),
                new SSD(2, 124, "Falcon 512GB AFALCON-512G-C", "ADATA", 512),
                new SSD(3, 135, "CL100 Gen. 3 480GB SSDPR-CL100-480-G3", "GOODRAM", 480),
                new SSD(4, 387, "980 Pro 1TB MZ-V8P1T0BW", "Samsung", 1000),
                new SSD(5, 667, "980 Pro 2TB MZ-V8P2T0BW", "Samsung", 2)

        ));
        Assert.assertEquals(ssds, expectedSsds);
    }
}
