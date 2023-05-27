package by.fpmibsu.PCBuilder.action.component;

import by.fpmibsu.PCBuilder.action.ActionError;
import by.fpmibsu.PCBuilder.dao.DaoException;
import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetAllAction extends ComponentAction{

    public GetAllAction(@NotNull HttpServletRequest req, @NotNull HttpServletResponse res) throws DaoException {
        super(req, res);
    }

    @Override
    public void doAction() {
        try(PrintWriter writer = res.getWriter()) {
            res.setCharacterEncoding("UTF-8");
            Gson gson = new Gson();
            String jsonComponents = gson.toJson(componentService.getAllComponents());
            writer.write("{\"" + componentName + "\": ");
            writer.write(jsonComponents);
            writer.write("}");
        } catch (IOException | DaoException e) {
            ActionError.sendError(res);
        }
    }
}
