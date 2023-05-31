package by.fpmibsu.PCBuilder.action.PC;

import by.fpmibsu.PCBuilder.dao.DaoException;
import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetPCAction extends  PCAction{
    public GetPCAction(@NotNull HttpServletRequest req, @NotNull HttpServletResponse res) throws DaoException {
        super(req, res);
    }

    @Override
    public void doAction() {
        try {
            Gson gson = new Gson();
            PrintWriter writer = res.getWriter();
            writer.write("{\"PC\":{\"id\":" + gson.toJson(pc.getId()) + ",\"GPU\":" +gson.toJson(pc.getGpu())   +",\"HDD\":" +gson.toJson(pc.getHdd()) + ",\"SSD\":" +gson.toJson(pc.getSsd()) +",\"Cooler\":" +gson.toJson(pc.getCooler())
                    +",\"CPU\":" +gson.toJson(pc.getCpu()) + ",\"RAM\":" +gson.toJson(pc.getRam())+",\"Motherboard\":" + gson.toJson(pc.getMotherboard()) +
                    ",\"PCCase\":" +gson.toJson(pc.getPCCase()) +  ",\"PowerSupply\":" + gson.toJson(pc.getPowerSupply()) + "}}");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
