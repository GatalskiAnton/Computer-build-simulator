package by.fpmibsu.PCBuilder.service.servlets;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.UserDao;
import by.fpmibsu.PCBuilder.entity.User;
import by.fpmibsu.PCBuilder.entity.component.utils.Authentication;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(name = "RegistrationServlet", value = "/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        UserDao userDao = new UserDao();
        BufferedReader reader = request.getReader();
        String json = reader.lines().collect(Collectors.joining());
        JsonObject obj = new Gson().fromJson(json, JsonObject.class);

        String login = obj.get("login").getAsString();
        String password = obj.get("password").getAsString();
        String email = obj.get("email").getAsString();
        try {
            userDao.insert(new User(12,login, Authentication.getHashPassword(password),false,email));
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }
}
