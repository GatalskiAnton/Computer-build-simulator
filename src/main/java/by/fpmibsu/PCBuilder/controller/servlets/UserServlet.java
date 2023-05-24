package by.fpmibsu.PCBuilder.controller.servlets;

import by.fpmibsu.PCBuilder.entity.component.utils.Authentication;
import by.fpmibsu.PCBuilder.entity.User;
import by.fpmibsu.PCBuilder.service.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;


@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {

    private static final String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String json = reader.lines().collect(Collectors.joining());
        Gson gson = new Gson();
        JsonObject obj = gson.fromJson(json, JsonObject.class);
        String op = obj.get("operation").getAsString();
        UserService service = new UserService();
        switch (op) {
            case "login" -> {
                String login = obj.get("login").getAsString();
                String password = obj.get("password").getAsString();
                try {
                    if (!service.isCorrectUser(login, password)) {
                        if(service.isExist(login)) {
                            resp.setHeader("errorType", "incorrect password");
                        }
                        else {
                            resp.setHeader("errorType", "user not found");
                        }
                        resp.setStatus(999);
                    }
                } catch (Exception e) {
                    resp.setHeader("errorType", "error");
                    resp.setStatus(999);
                }
            }
            case "register" -> {
                String login = obj.get("login").getAsString();
                String password = obj.get("password").getAsString();
                try {
                    if(service.isExist(login)) {
                        resp.setHeader("errorType", "user with this login is exists");
                        resp.setStatus(999);
                        return;
                    }
                    if(!login.toLowerCase().matches(regex)) {
                        resp.setHeader("errorType", "invalid login");
                        resp.setStatus(999);
                        return;
                    }
                    if(password.length() < 6) {
                        resp.setHeader("errorType", "password should be at least 6 characters");
                        resp.setStatus(999);
                        return;
                    }
                    service.createUser(login, password);
                } catch (Exception e) {
                    resp.setHeader("errorType", "error");
                    resp.setStatus(999);
                }
            }
            case "changePass" -> {
                String login = obj.get("login").getAsString();
                String newPassword = obj.get("newPassword").getAsString();
                try {
                    if(!service.isExist(login)) {
                        resp.setHeader("errorType", "no user with this login");
                        resp.setStatus(999);
                        return;
                    }
                    User user = service.getUser(login);
                    if(user.isFromGoogle()) {
                        resp.setHeader("errorType", "google account");
                        resp.setStatus(999);
                        return;
                    }
                    if(Authentication.isCorrectPassword(newPassword, user.getHashPassword())) {
                        resp.setHeader("errorType", "old password");
                        resp.setStatus(999);
                        return;
                    }
                    if(newPassword.length() < 6) {
                        resp.setHeader("errorType", "password should be at least 6 characters");
                        resp.setStatus(999);
                        return;
                    }
                    service.changePassword(user,newPassword);
                } catch (Exception e) {
                    resp.setHeader("errorType", "error");
                    resp.setStatus(999);
                }
            }
        }
    }
}
