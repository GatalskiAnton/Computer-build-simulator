package by.fpmibsu.PCBuilder.test;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.entity.component.PowerSupply;
import by.fpmibsu.PCBuilder.entity.component.RAM;
import by.fpmibsu.PCBuilder.entity.component.utils.MemoryType;
import by.fpmibsu.PCBuilder.service.PowerSupplyService;
import by.fpmibsu.PCBuilder.service.RamService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RamServiceTest {
    @Test(description = "Check getAllComponent")
    public void testGetComponentByTDPWithCorrectInput() throws DaoException {
        RamService ramService = new RamService();
        List<RAM> rams = ramService.getAllComponents();
        List<RAM> expectedRams = new ArrayList<>(Arrays.asList(
                new RAM(1, 489, "Ripjaws S5 2x16ГБ DDR5 5600 МГц F5-5600J3036D16GX2-RS5K", "G.Skill", 5600, MemoryType.DDR5),
                new RAM(2, 140, "Ripjaws V 2x8GB DDR4 PC4-25600 [F4-3200C16D-16GVKB]", "G.Skill", 3200, MemoryType.DDR4),
                new RAM(3, 114, "II Black 16ГБ DDR4 2666МГц NTSWD4P26SP-16K", "Netac Shadow", 2600, MemoryType.DDR4),
                new RAM(4, 150, "FURY Beast 2x8GB DDR4 PC4-24000 KF430C15BBK2/16", "Kingston ", 3000, MemoryType.DDR4),
                new RAM(5, 54, "Aegis 8GB DDR3 PC3-12800 F3-1600C11S-8GIS", "G.Skill", 1600, MemoryType.DDR3),
                new RAM(6, 152, "Viper 3 Black Mamba 2x8GB KIT DDR3 PC3-12800 (PV316G160C0K)", "Patriot", 1600, MemoryType.DDR3),
                new RAM(7, 50, "ValueRAM KVR800D2N6/2G", "Kingston", 800, MemoryType.DDR2),
                new RAM(8, 48, "Signature 2GB DDR2 PC2-6400 (PSD22G80026)", "Patriot", 800, MemoryType.DDR2),
                new RAM(9, 20, "1GB DDR PC-3200 (QUM1U-1G400T3)", "QUMO", 400, MemoryType.DDR1)
        ));
        Assert.assertEquals(rams, expectedRams);
    }
}
