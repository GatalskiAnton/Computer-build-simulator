package by.fpmibsu.PCBuilder.service.servlets;

import by.fpmibsu.PCBuilder.dao.*;
import by.fpmibsu.PCBuilder.entity.component.Component;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

@WebServlet(name = "ComponentServlet", value = "/ComponentServlet")
public class ComponentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NullPointerException {
        request.setCharacterEncoding("UTF-8");

        BufferedReader reader = request.getReader();
        String json = reader.lines().collect(Collectors.joining());
        Gson gson = new Gson();
        JsonObject obj = gson.fromJson(json, JsonObject.class);

        ComponentDaoI dao;
        String componentName = obj.get("componentName").getAsString();

        switch (componentName) {
            case "CPU" :
                dao = new CPUDao();
                break;
            case "GPU":
                dao = new GPUDao();
                break;
            case "Cooler":
                dao = new CoolerDao();
                break;
            case "HDD":
                dao = new HDDDao();
                break;
            case "Motherboard":
                dao = new MotherboardDao();
                break;
            case "PCCase":
                dao = new PCCaseDao();
                break;
            case "PowerSupply":
                dao = new PowerSupplyDao();
                break;
            case "RAM":
                dao = new RAMDao();
                break;
            case "SSD":
                dao = new SSDDao();
                break;
            default:
                dao = null;
                break;
        }

        if(dao == null) {
            throw  new NullPointerException();
        }

        String jsonComponents;

        try {
            jsonComponents = gson.toJson(dao.findAll());
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }

        PrintWriter writer = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        writer.write("{\"" + componentName + "\": ");
        writer.write(jsonComponents);
        writer.write("}");
        writer.close();

    }
}
