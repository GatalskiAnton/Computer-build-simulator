package by.fpmibsu.PCBuilder.service.servlets;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.dao.UserDao;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CPUServlet", value = "/CPUServlet")
public class CPUServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao userDao = new UserDao();


        Gson gson = new Gson();
        UserDao dao = new UserDao();
        String json;
        try {
            json = gson.toJson(dao.findAll());
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }

        PrintWriter writer = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        writer.write("{\"users\": ");
        writer.write(json);
        writer.write("}");
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
