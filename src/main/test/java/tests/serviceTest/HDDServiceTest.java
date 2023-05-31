package serviceTest;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.entity.component.HDD;
import by.fpmibsu.PCBuilder.service.HDDServiceImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HDDServiceTest {
    @Test(description = "Check getAllComponent")
    public void testGetComponentByTDPWithCorrectInput() throws DaoException {
        HDDServiceImpl hddService = new HDDServiceImpl();
        List<HDD> hdds = hddService.getAllComponents();
        List<HDD> expectedHdds = new ArrayList<>(Arrays.asList(
                new HDD(1, 130, "Caviar Blue 1 TB(WD10EZEX)", "WD", 1),
                new HDD(2, 162, "Barracuda 2TB ST2000DM008", "WD", 2),
                new HDD(3, 126, "P300 1TB [HDWD110UZSVA]", "WD", 1),
                new HDD(4, 200, "Ultrastar 7K4000 4TB HUS724040ALE641", "WD", 4)
        ));

        Assert.assertEquals(hdds, expectedHdds);
    }
}
