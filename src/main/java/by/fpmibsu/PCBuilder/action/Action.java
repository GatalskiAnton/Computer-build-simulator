package by.fpmibsu.PCBuilder.action;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.entity.User;
import by.fpmibsu.PCBuilder.service.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.jetbrains.annotations.NotNull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

public abstract class  Action {
    protected JsonObject reqData;
    protected  int userId;
    protected  HttpServletRequest req;
    protected HttpServletResponse res;

    protected boolean guest = false;
    protected  Action(@NotNull HttpServletRequest req, @NotNull HttpServletResponse res) throws DaoException {
        this.req = req;
        this.res = res;
        BufferedReader reader = null;
        try {
            reader = req.getReader();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String json = reader.lines().collect(Collectors.joining());
        Gson gson = new Gson();
        reqData = gson.fromJson(json, JsonObject.class);
        UserService service = new UserService();
        if(reqData.get("login").getAsString().equals("guest")) {
            guest = true;
        }
        else {
            User user = service.getUser(reqData.get("login").getAsString());
            if(user == null) {
                ActionError.sendError(res, "noConnection");
                throw new DaoException("no connection");
            }
            else {
                userId = service.getUser(reqData.get("login").getAsString()).getId();
            }
        }
    }
    public abstract void doAction();
}
