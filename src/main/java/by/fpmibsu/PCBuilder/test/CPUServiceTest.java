package by.fpmibsu.PCBuilder.test;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.entity.component.CPU;
import by.fpmibsu.PCBuilder.entity.component.Cooler;
import by.fpmibsu.PCBuilder.entity.component.utils.Socket;
import by.fpmibsu.PCBuilder.service.CPUService;
import by.fpmibsu.PCBuilder.service.CoolerService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CPUServiceTest {

    @Test(description = "Check getComponentByTDP with correct input ")
    public void testGetComponentByTDPWithCorrectInput() throws DaoException {
        CPUService cpuService = new CPUService();
        List<CPU> cpus = cpuService.getCPUsByTDP(65);
        List<CPU> expectedCpus = new ArrayList<>(Arrays.asList(
                new CPU(1, 100, "Ryzen 5 5600x", "AMD", 4600, Socket.AM5, 65, 6)));
        Assert.assertEquals(cpus, expectedCpus);
    }

    @Test(description = "Check getComponentByTDP with incorrect input ")
    public void testGetComponentByTDPWithIncorrectInput() throws DaoException {
        CPUService cpuService = new CPUService();
        List<CPU> cpus = cpuService.getCPUsByTDP(-100);
        List<Cooler> expectedCpus = new ArrayList<>();
        Assert.assertEquals(cpus, expectedCpus);
    }

    @Test(description = "Check getAllComponent")
    public void testGetAllComponent() throws DaoException {
        CPUService cpuService = new CPUService();
        List<CPU> cpus = cpuService.getAllComponents();
        List<CPU> expectedCpus = new ArrayList<>(Arrays.asList(
                new CPU(1, 100, "Ryzen 5 5600x", "AMD", 4600, Socket.AM5, 65, 6)));
        Assert.assertEquals(cpus, expectedCpus);
    }

    @Test(description = "Check getComponentBySocket")
    public void testGetComponentBySocket() throws DaoException {
        CPUService cpuService = new CPUService();
        List<CPU> cpus = cpuService.getCPUsBySocket(Socket.AM5);
        List<CPU> expectedCpus = new ArrayList<>(Arrays.asList(
                new CPU(1, 100, "Ryzen 5 5600x", "AMD", 4600, Socket.AM5, 65, 6)));
        Assert.assertEquals(cpus, expectedCpus);
    }
}
