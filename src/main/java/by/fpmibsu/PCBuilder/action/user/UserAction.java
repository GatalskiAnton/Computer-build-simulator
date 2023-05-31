package by.fpmibsu.PCBuilder.action.user;
import by.fpmibsu.PCBuilder.action.Action;
import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.service.UserServiceImpl;
import org.jetbrains.annotations.NotNull;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class UserAction extends Action {

    protected UserServiceImpl service = new UserServiceImpl();

    protected UserAction(@NotNull HttpServletRequest req, @NotNull HttpServletResponse res) throws DaoException {
        super(req, res);
    }
    public abstract void doAction();
}
