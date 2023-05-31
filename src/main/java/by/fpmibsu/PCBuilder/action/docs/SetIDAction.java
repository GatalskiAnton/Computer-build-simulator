package by.fpmibsu.PCBuilder.action.docs;

import by.fpmibsu.PCBuilder.dao.DaoException;
import org.jetbrains.annotations.NotNull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetIDAction extends DocsAction{

    public SetIDAction(@NotNull HttpServletRequest req, @NotNull HttpServletResponse res) throws DaoException {
        super(req, res);
        System.out.println(1234);
    }

    @Override
    public void doAction() {
        pc.setId(reqData.get("id").getAsInt());
    }
}
