package by.fpmibsu.PCBuilder.controller.filter;

import by.fpmibsu.PCBuilder.action.Action;
import by.fpmibsu.PCBuilder.action.component.GetAllAction;
import by.fpmibsu.PCBuilder.action.component.GetInfoAction;
import by.fpmibsu.PCBuilder.action.component.SelectComponentAction;
import by.fpmibsu.PCBuilder.action.user.ChangePasswordAction;
import by.fpmibsu.PCBuilder.action.user.LoginAction;
import by.fpmibsu.PCBuilder.action.user.RegisterAction;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainFilter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(!(servletRequest instanceof HttpServletRequest request)
                || !(servletResponse instanceof HttpServletResponse)) {
            return;
        }
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse res  = (HttpServletResponse)servletResponse;
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
            }
            if(action == null) {
                filterChain.doFilter(servletRequest, servletResponse);
            }
            else {
                req.setAttribute("action", action);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/MainServlet");
                requestDispatcher.forward(req, res);
            }
        }
        catch (Exception r) {
            System.out.println(r);
        }
    }

    @Override
    public void destroy() {}
}
