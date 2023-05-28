package by.fpmibsu.PCBuilder.test;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.entity.component.CPU;
import by.fpmibsu.PCBuilder.entity.component.Cooler;
import by.fpmibsu.PCBuilder.entity.component.GPU;
import by.fpmibsu.PCBuilder.entity.component.utils.Socket;
import by.fpmibsu.PCBuilder.entity.component.utils.VideoMemoryType;
import by.fpmibsu.PCBuilder.service.CPUService;
import by.fpmibsu.PCBuilder.service.GPUService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GPUServiceTest {

    @Test(description = "Check getAllComponent")
    public void testGetComponentByTDPWithCorrectInput() throws DaoException {
        GPUService gpuService = new GPUService();
        List<GPU> gpus = gpuService.getAllComponents();
        List<GPU> expectedGpus = new ArrayList<>(Arrays.asList(
                new GPU(2, 2100, "Quadro P5000 16GB GDDR5 900-5G413-2500-000", "NVIDIA", 1733, VideoMemoryType.GDDR5X, 16),
                new GPU(3, 635, "Radeon RX 580 8GB GDDR5 AFRX580-8192D5H3-V2", "AFOX", 1284, VideoMemoryType.GDDR5, 8),
                new GPU(4, 3770, "GeForce RTX 4070 Ti GameRock Classic NED407T019K9-1046G", "Palit", 2610, VideoMemoryType.GDDR6X, 12),
                new GPU(5, 1312, "GeForce RTX 3060 Dual 12GB GDDR6 NE63060019K9-190AD", "Palit", 1777, VideoMemoryType.GDDR6, 12),
                new GPU(6, 322, "GeForce GT 1030 Aero ITX OC 2GB DDR4", "MSI", 1430, VideoMemoryType.DDR4, 2)));

        Assert.assertEquals(gpus, expectedGpus);
    }
}
