package by.fpmibsu.PCBuilder.action.component;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.entity.PC;
import by.fpmibsu.PCBuilder.entity.component.Component;
import by.fpmibsu.PCBuilder.service.PCService;
import org.jetbrains.annotations.NotNull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectComponentAction extends ComponentAction{
    public SelectComponentAction(@NotNull HttpServletRequest req, @NotNull HttpServletResponse res) throws DaoException {
        super(req, res);
    }

    @Override
    public void doAction() {
        Component component = componentService.getComponentById(reqData.get("componentId").getAsInt());
        PC pc = new PCService().getPc(reqData.get("login").getAsString());
        componentService.selectComponent(pc.getId(), component);
    }
}
