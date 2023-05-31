package by.fpmibsu.PCBuilder.action.docs;

import by.fpmibsu.PCBuilder.action.ActionError;
import by.fpmibsu.PCBuilder.dao.DaoException;
import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetCPUAction extends DocsAction{
    public GetCPUAction(@NotNull HttpServletRequest req, @NotNull HttpServletResponse res) throws DaoException {
        super(req, res);
    }

    @Override
    public void doAction() {
        res.setCharacterEncoding("UTF-8");
        res.setContentType("application/json");
        try {
            PrintWriter writer = res.getWriter();
            writer.write(new Gson().toJson(pc.getCpu()));
        } catch (IOException e) {
            ActionError.sendError(res);
        }
    }
}
