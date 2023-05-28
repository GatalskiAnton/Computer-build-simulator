package by.fpmibsu.PCBuilder.action.user;

import by.fpmibsu.PCBuilder.action.ActionError;
import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.entity.User;
import by.fpmibsu.PCBuilder.entity.component.utils.Authentication;
import org.jetbrains.annotations.NotNull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangePasswordAction extends UserAction{
    public ChangePasswordAction(@NotNull HttpServletRequest req, @NotNull HttpServletResponse res) throws DaoException {
        super(req, res);
    }
    @Override
    public void doAction() {
        String login = reqData.get("login").getAsString();
        String newPassword = reqData.get("newPassword").getAsString();
        System.out.println(newPassword);
        boolean fromGoogleAcc = reqData.get("googleAccount").getAsBoolean();
        if(fromGoogleAcc) {
            ActionError.sendError(res, "googleAccount");
            return;
        }
        if(guest) {
            ActionError.sendError(res, "guest");
        }
        try {
            if(!service.isExist(login)) {
                ActionError.sendError(res, "noUser");
                return;
            }
            User user = service.getUser(login);
            if(user.isFromGoogle()) {
                ActionError.sendError(res, "googleAccount");
                return;
            }
            if(Authentication.isCorrectPassword(newPassword, user.getHashPassword())) {
                ActionError.sendError(res, "oldPassword");
                return;
            }
            if(newPassword.length() < 6) {
                ActionError.sendError(res, "shortPassword");
                return;
            }
            service.changePassword(user,newPassword);
        } catch (Exception e) {
            ActionError.sendError(res);
        }
    }
}
