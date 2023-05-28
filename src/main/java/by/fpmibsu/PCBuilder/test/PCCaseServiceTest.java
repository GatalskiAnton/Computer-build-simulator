package by.fpmibsu.PCBuilder.test;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.entity.component.Motherboard;
import by.fpmibsu.PCBuilder.entity.component.PCCase;
import by.fpmibsu.PCBuilder.entity.component.utils.Color;
import by.fpmibsu.PCBuilder.entity.component.utils.Socket;
import by.fpmibsu.PCBuilder.service.MotherboardService;
import by.fpmibsu.PCBuilder.service.PCCaseService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PCCaseServiceTest {
    @Test(description = "Check getAllComponent")
    public void testGetAllComponent() throws DaoException {
        PCCaseService pcCaseService = new PCCaseService();
        List<PCCase> pcCases = pcCaseService.getAllComponents();
        List<PCCase> expectedPCCases = new ArrayList<>(Arrays.asList(
                new PCCase(1, 348, "Lancool II Mesh RGB G99.LAN2MRX.50", "Lian Li", Color.BLACK),
                new PCCase(2, 183, "Macube 110 WH R-MACUBE110-WHNGM1N-G-1", "DeepCool", Color.WHITE),
                new PCCase(3, 208, "i3 Neo", "Zalman", Color.GREY),
                new PCCase(4, 225, "V9", "Jonsbo", Color.GREY),
                new PCCase(5, 1045, "TR03-A", "Jonsbo", Color.GREY),
                new PCCase(6, 379, "Lancool 216 ARGB G99.LAN216RW.00", "Lian Li", Color.WHITE),
                new PCCase(7, 174, "Mistral X4 Mesh LED", "Powercase", Color.BLACK)
        ));
        Assert.assertEquals(pcCases, expectedPCCases);
    }
}
