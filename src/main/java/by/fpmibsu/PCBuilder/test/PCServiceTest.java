package by.fpmibsu.PCBuilder.test;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.component.*;
import by.fpmibsu.PCBuilder.entity.component.utils.Color;
import by.fpmibsu.PCBuilder.entity.component.utils.MemoryType;
import by.fpmibsu.PCBuilder.entity.component.utils.Socket;
import by.fpmibsu.PCBuilder.entity.component.utils.VideoMemoryType;
import by.fpmibsu.PCBuilder.service.PCService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PCServiceTest {
    @Test(description = "Check getPrice with correct input")
    public void testGetPriceWithCorrectInput() throws DaoException {
        PCService pcService = new PCService();
        PC pc = new PC();
        pc.setCooler(new Cooler(1, 219, "AK620 Zero Dark R-AK620-BKNNMT-G-1", "DeepCool", Socket.AM5, 260, 120));
        pc.setCpu(new CPU(1, 100, "Ryzen 5 5600x", "AMD", 4600, Socket.AM5, 65, 6));
        pc.setGpu(new GPU(2, 2100, "Quadro P5000 16GB GDDR5 900-5G413-2500-000", "NVIDIA", 1733, VideoMemoryType.GDDR5X, 16));
        pc.setHdd(new HDD(1, 130, "Caviar Blue 1 TB(WD10EZEX)", "WD", 1));
        pc.setMotherboard(new Motherboard(1, 376, "B550M Pro4", "ASRock", Socket.AM4));
        pc.setPCCase(new PCCase(1, 348, "Lancool II Mesh RGB G99.LAN2MRX.50", "Lian Li", Color.BLACK));
        pc.setPowerSupply(new PowerSupply(1, 360, "Leadex III Gold ARGB Pro 650W SF-650F14RG V2.0", "Super Flower", 650));
        pc.setRam(new RAM(1, 489, "Ripjaws S5 2x16ГБ DDR5 5600 МГц F5-5600J3036D16GX2-RS5K", "G.Skill", 5600, MemoryType.DDR5));
        pc.setSsd(new SSD(1, 52, "AS350 256GB AP256GAS350-1", "Apacer Panther", 256));
        int price = pcService.getPrice(pc);
        int expectedPrice = 4174;
        Assert.assertEquals(price, expectedPrice);
    }

    @Test(description = "Check getPrice with incorrect input")
    public void testGetPriceWithIncorrectInput() throws DaoException {
        PCService pcService = new PCService();
        PC pc = new PC();
        pc.setCooler(new Cooler(1, 219, "AK620 Zero Dark R-AK620-BKNNMT-G-1", "DeepCool", Socket.AM5, 260, 120));
        pc.setCpu(new CPU(1, 100, "Ryzen 5 5600x", "AMD", 4600, Socket.AM5, 65, 6));
        pc.setGpu(new GPU(2, 2100, "Quadro P5000 16GB GDDR5 900-5G413-2500-000", "NVIDIA", 1733, VideoMemoryType.GDDR5X, 16));
        pc.setHdd(new HDD(1, 130, "Caviar Blue 1 TB(WD10EZEX)", "WD", 1));
        pc.setMotherboard(new Motherboard(1, 376, "B550M Pro4", "ASRock", Socket.AM4));
        pc.setPCCase(new PCCase(1, 348, "Lancool II Mesh RGB G99.LAN2MRX.50", "Lian Li", Color.BLACK));
        pc.setPowerSupply(new PowerSupply(1, 360, "Leadex III Gold ARGB Pro 650W SF-650F14RG V2.0", "Super Flower", 650));
        pc.setRam(null);
        pc.setSsd(null);
        int price = pcService.getPrice(pc);
        int expectedPrice = 3633;
        Assert.assertEquals(price, expectedPrice);
    }
}
