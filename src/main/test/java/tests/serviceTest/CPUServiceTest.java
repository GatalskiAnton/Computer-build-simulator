package serviceTest;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.entity.component.CPU;
import by.fpmibsu.PCBuilder.entity.component.Cooler;
import by.fpmibsu.PCBuilder.entity.component.utils.Socket;
import by.fpmibsu.PCBuilder.service.CPUServiceImpl;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CPUServiceTest {

    @DataProvider(name = "tdpProvider")
    public Object[][] cpuTDPTestProvider(){
        return new  Object[][]{
                {300, List.of(new CPU(1, 502, "i5-12400F", "Intel Core", 2400, Socket.LGA1700, 300, 6))},
                {-123, List.of()},
                {0, List.of()}

        };
    }

    @DataProvider(name = "socketProvider")
    public Object[][] coolersSocketTestProvider(){
        return new  Object[][]{
                {Socket.LGA1700, List.of(new CPU(1, 502, "i5-12400F", "Intel Core", 2400, Socket.LGA1700, 300, 6)) }
        };
    }

    @Test(description = "Check getComponentByTDP with correct input", dataProvider = "tdpProvider")
    public void testGetComponentByTDPWithCorrectInput(int tdp, List<CPU> expectedCpus) throws DaoException {
        CPUServiceImpl cpuService = new CPUServiceImpl();
        List<CPU> serviceCpus = cpuService.getCPUsByTDP(tdp);
        Assert.assertEquals(serviceCpus, expectedCpus);
    }


    @Test(description = "Check getAllComponent")
    public void testGetAllComponent() throws DaoException {
        CPUServiceImpl cpuService = new CPUServiceImpl();
        List<CPU> cpus = cpuService.getAllComponents();
        List<CPU> expectedCpus = new ArrayList<>(Arrays.asList(
                new CPU(1, 502, "i5-12400F", "Intel Core", 2400, Socket.LGA1700, 300, 6)));
        Assert.assertEquals(cpus, expectedCpus);
    }

    @Test(description = "Check getComponentBySocket", dataProvider = "socketProvider")
    public void testGetComponentBySocket(Socket socket, List<CPU> expectedCpus) throws DaoException {
        CPUServiceImpl cpuService = new CPUServiceImpl();
        List<CPU> serviceCpus = cpuService.getCPUsBySocket(socket);
        Assert.assertEquals(serviceCpus, expectedCpus);
    }
}
