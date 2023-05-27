package by.fpmibsu.PCBuilder.controller.servlets;

import by.fpmibsu.PCBuilder.action.Action;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MainServlet", value = "/MainServlet")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("hello");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {;
        Action action = (Action) request.getAttribute("action");
        if(action == null) {
            return;
        }
        action.doAction();
    }
}
