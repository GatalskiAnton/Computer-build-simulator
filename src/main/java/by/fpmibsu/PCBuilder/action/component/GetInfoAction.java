package by.fpmibsu.PCBuilder.action.component;

import by.fpmibsu.PCBuilder.action.ActionError;
import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.entity.component.Component;
import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetInfoAction extends  ComponentAction{
    public GetInfoAction(@NotNull HttpServletRequest req, @NotNull HttpServletResponse res) throws DaoException {
        super(req, res);
    }

    @Override
    public void doAction() {
        Component component = componentService.getComponentById(reqData.get("id").getAsInt());
        try(PrintWriter writer = res.getWriter()){
            Gson gson = new Gson();
            String componentStr = gson.toJson(component);
            writer.write(componentStr);
        } catch (Exception e) {
            ActionError.sendError(res);
        }
    }
}
