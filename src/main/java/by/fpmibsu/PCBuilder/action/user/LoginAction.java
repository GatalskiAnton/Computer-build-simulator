package by.fpmibsu.PCBuilder.action.user;
import by.fpmibsu.PCBuilder.action.ActionError;
import by.fpmibsu.PCBuilder.dao.DaoException;
import org.jetbrains.annotations.NotNull;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction extends UserAction{

    public LoginAction(@NotNull HttpServletRequest req, @NotNull HttpServletResponse res) throws DaoException {
        super(req, res);
    }
    @Override
    public void doAction() {
        String login = reqData.get("login").getAsString();
        String password = reqData.get("password").getAsString();
        boolean fromGoogleAcc = reqData.get("googleAccount").getAsBoolean();
        try {
            if(password == null || password.isEmpty() && fromGoogleAcc) {
                if(!service.isExist(login)) {
                    ActionError.sendError(res, "userNotFound");
                }
                else {
                    return;
                }
            }
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
        try {
            if (!service.isCorrectUser(login, password)) {
                if(service.isExist(login)) {

                    ActionError.sendError(res, "incorrectPassword");
                }
                else {
                    ActionError.sendError(res, "userNotFound");
                }
            }
        } catch (Exception e) {
            ActionError.sendError(res);
        }
    }
}
