package by.fpmibsu.PCBuilder.controller.servlets;

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
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestType = request.getHeader("requestType");
        switch (requestType) {
            case "userRequest": {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/UserServlet");
                dispatcher.forward(request, response);
                break;
            }
            case "componentRequest": {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/ComponentServlet");
                dispatcher.forward(request, response);
                break;
            }
            case "pcRequest":
                response.sendRedirect("http://localhost:9090/PCBuilder_war_exploded/PCServlet");
                break;
        }
    }
}
