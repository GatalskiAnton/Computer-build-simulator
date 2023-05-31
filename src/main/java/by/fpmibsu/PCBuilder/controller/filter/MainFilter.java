package by.fpmibsu.PCBuilder.controller.filter;

import by.fpmibsu.PCBuilder.action.Action;
import by.fpmibsu.PCBuilder.action.ActionError;
import by.fpmibsu.PCBuilder.action.component.GetAllAction;
import by.fpmibsu.PCBuilder.action.component.GetInfoAction;
import by.fpmibsu.PCBuilder.action.component.SelectComponentAction;
import by.fpmibsu.PCBuilder.action.docs.*;
import by.fpmibsu.PCBuilder.action.user.ChangePasswordAction;
import by.fpmibsu.PCBuilder.action.user.LoginAction;
import by.fpmibsu.PCBuilder.action.user.RegisterAction;
import by.fpmibsu.PCBuilder.action.PC.*;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainFilter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.setProperty("log4j.configurationFile", this.getClass().getResource("/") + "../log4j2.xml");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(!(servletRequest instanceof HttpServletRequest request)
                || !(servletResponse instanceof HttpServletResponse)) {
            return;
        }

        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse res  = (HttpServletResponse)servletResponse;

        res.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        res.addHeader("Access-Control-Allow-Headers", "*");
        res.addHeader("Access-Control-Allow-Methods",
                "GET, OPTIONS, HEAD, PUT, POST, DELETE");

        if("OPTIONS".equals(req.getMethod())) {
            return;
        }

        try {
            String actionStr = req.getRequestURI().replace(req.getContextPath() + '/', "");
            Action action = null;
            switch (actionStr) {
                case "user/login" -> {
                    action = new LoginAction(req, res);
                }
                case "user/register" -> {
                    action = new RegisterAction(req,res);
                }
                case "user/changePassword" -> {
                    System.out.println(12321321);
                    action = new ChangePasswordAction(req,res);
                }
                case "component/getAll" -> {
                    action = new GetAllAction(req, res);
                }
                case "component/select" -> {
                    action = new SelectComponentAction(req, res);
                }
                case "component/getInfo" -> {
                    action = new GetInfoAction(req, res);
                }
                case "PC/getPC" ->{
                    action = new GetPCAction(req, res);
                }
                case "docs/getId" -> {
                    action = new GetIDAction(req, res);
                }
                case "docs/getCooler" -> {
                    action = new GetCoolerAction(req, res);
                }
                case "docs/getCPU" -> {
                    action = new GetCPUAction(req, res);
                }
                case "docs/getSSD" -> {
                    action = new GetSSDAction(req, res);
                }
                case "docs/getHDD" -> {
                    action = new GetHDDAction(req, res);
                }
                case "docs/getMotherboard" -> {
                    action = new GetMotherboardAction(req, res);
                }
                case "docs/getPowerSupply" -> {
                    action = new GetPowerSupplyAction(req, res);
                }
                case "docs/getUserId" -> {
                    action = new GetUserIDAction(req, res);
                }
                case "docs/setId" -> {
                    action = new SetIDAction(req, res);
                }
            }
            if(action == null) {
                ActionError.sendError(res, "NoValidAction");
            }
            else {
                req.setAttribute("action", action);
                filterChain.doFilter(req, res);
            }
        }
        catch (Exception r) {
            ActionError.sendError(res);
        }
    }

    @Override
    public void destroy() {}
}
