package by.fpmibsu.PCBuilder.action.PC;

import by.fpmibsu.PCBuilder.action.Action;
import by.fpmibsu.PCBuilder.action.ActionError;
import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.service.PCService;
import by.fpmibsu.PCBuilder.service.PCServiceImpl;
import org.jetbrains.annotations.NotNull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class PCAction extends Action {

    PC pc;

    protected PCService service = new PCServiceImpl();

    protected PCAction(@NotNull HttpServletRequest req, @NotNull HttpServletResponse res) throws DaoException {
        super(req, res);
        try {
            if(reqData.get("login").getAsString().equals("guest")) {
                ActionError.sendError(res, "guest");
                return;
            }
            pc = service.getPc(reqData.get("login").getAsString());
        }
        catch (Exception e) {
            ActionError.sendError(res);
        }
    }
}
