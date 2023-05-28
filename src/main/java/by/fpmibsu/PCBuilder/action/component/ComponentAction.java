package by.fpmibsu.PCBuilder.action.component;

import by.fpmibsu.PCBuilder.action.Action;
import by.fpmibsu.PCBuilder.action.ActionError;
import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.component.Component;
import by.fpmibsu.PCBuilder.service.*;
import org.jetbrains.annotations.NotNull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public abstract class ComponentAction extends Action {
    protected  String componentName;
    PC currentPc;
    ComponentServiceI componentService;

    protected ComponentAction(@NotNull HttpServletRequest req, @NotNull HttpServletResponse res) throws DaoException {
        super(req, res);
        componentName = reqData.get("componentName").getAsString();
        switch (componentName) {
            case "CPU" -> componentService = new CPUService();
            case "GPU" -> componentService = new GPUService();
            case "Cooler" -> componentService = new CoolerService();
            case "HDD" -> componentService = new HDDService();
            case "Motherboard" -> componentService = new MotherboardService();
            case "PCCase" -> componentService = new PCCaseService();
            case "PowerSupply" -> componentService = new PowerSupplyService();
            case "RAM" -> componentService = new RamService();
            case "SSD" -> componentService = new SSDService();
            default -> componentService = null;
        }
        if(componentService == null) {
            ActionError.sendError(res, "noSuchComponent");
            return;
        }
        if(reqData.get("login").getAsString().equals("guest")) {
            return;
        }
        PCService service = new PCService();
        currentPc = service.getPc(reqData.get("login").getAsString());
    }

    public abstract void doAction();
}
