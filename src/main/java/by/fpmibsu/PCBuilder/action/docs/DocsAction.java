package by.fpmibsu.PCBuilder.action.docs;

import by.fpmibsu.PCBuilder.action.Action;
import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.component.PowerSupply;
import by.fpmibsu.PCBuilder.entity.component.SSD;
import org.jetbrains.annotations.NotNull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class DocsAction extends Action {

    protected PC pc;
    protected DocsAction(@NotNull HttpServletRequest req, @NotNull HttpServletResponse res) throws DaoException {
        super(req, res);
        pc  = new PC();
        pc.setSsd(new SSD());
        pc.setUserId(1);
        pc.setPowerSupply(new PowerSupply());
    }
}
