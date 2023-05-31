package by.fpmibsu.PCBuilder.action.component;

import by.fpmibsu.PCBuilder.action.Action;
import by.fpmibsu.PCBuilder.action.ActionError;
import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.service.*;
import org.jetbrains.annotations.NotNull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ComponentAction extends Action {
    protected  String componentName;
    PC currentPc;
    ComponentService componentService;

    protected ComponentAction(@NotNull HttpServletRequest req, @NotNull HttpServletResponse res) throws DaoException {
        super(req, res);
        componentName = reqData.get("componentName").getAsString();
        switch (componentName) {
            case "CPU" -> componentService = new CPUServiceImpl();
            case "GPU" -> componentService = new GPUServiceImpl();
            case "Cooler" -> componentService = new CoolerServiceImpl();
            case "HDD" -> componentService = new HDDServiceImpl();
            case "Motherboard" -> componentService = new MotherboardServiceImpl();
            case "PCCase" -> componentService = new PCCaseServiceImpl();
            case "PowerSupply" -> componentService = new PowerSupplyServiceImpl();
            case "RAM" -> componentService = new RamServiceImpl();
            case "SSD" -> componentService = new SSDServiceImpl();
            default -> componentService = null;
        }
        if(componentService == null) {
            ActionError.sendError(res, "noSuchComponent");
            return;
        }
        if(reqData.get("login").getAsString().equals("guest")) {
            return;
        }
        PCServiceImpl service = new PCServiceImpl();
        currentPc = service.getPc(reqData.get("login").getAsString());
    }

    public abstract void doAction();
}
