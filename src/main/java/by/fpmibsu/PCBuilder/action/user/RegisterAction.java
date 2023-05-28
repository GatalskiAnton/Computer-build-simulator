package by.fpmibsu.PCBuilder.action.user;

import by.fpmibsu.PCBuilder.action.ActionError;
import by.fpmibsu.PCBuilder.dao.DaoException;
import org.jetbrains.annotations.NotNull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterAction extends UserAction{
    private static final String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    public RegisterAction(@NotNull HttpServletRequest req, @NotNull HttpServletResponse res) throws DaoException {
        super(req, res);
    }
    @Override
    public void doAction() {
        if(guest) {
            ActionError.sendError(res, "guest");
        }
        String login = reqData.get("login").getAsString();
        String password = reqData.get("password").getAsString();
        boolean fromGoogleAcc = reqData.get("googleAccount").getAsBoolean();
        if(fromGoogleAcc) {
            try {
                service.createUserByGoogle(login);
            } catch (DaoException e) {
                ActionError.sendError(res);
            }
            return;
        }
        try {
            if(service.isExist(login)) {
                ActionError.sendError(res, "userExists");
                return;
            }
            if(!login.toLowerCase().matches(regex)) {
                ActionError.sendError(res, "invalidLogin");
                return;
            }
            if(password.length() < 6) {
                ActionError.sendError(res, "shortPassword");
                return;
            }
            service.createUser(login, password);
        } catch (Exception e) {
            ActionError.sendError(res);
        }
    }
}
