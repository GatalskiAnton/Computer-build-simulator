package by.fpmibsu.PCBuilder.test;

import by.fpmibsu.PCBuilder.dao.DaoException;
import by.fpmibsu.PCBuilder.entity.User;
import by.fpmibsu.PCBuilder.entity.component.SSD;
import by.fpmibsu.PCBuilder.service.SSDService;
import by.fpmibsu.PCBuilder.service.UserService;
import by.fpmibsu.PCBuilder.service.utils.GoogleException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.util.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class UserServiceTest {
    @Test(description = "Check isExist with correct input")
    public void testIsExistWithCorrectInput() throws DaoException {
        UserService userService = new UserService();
        boolean isExist = userService.isExist("fpm.videvich@bsu.by");
        boolean expectedResult = true;
        Assert.assertEquals(isExist, expectedResult);
    }

    @Test(description = "Check isExist with incorrect input")
    public void testIsExistWithIncorrectInput() throws DaoException {
        UserService userService = new UserService();
        boolean isExist = userService.isExist("");
        boolean expectedResult = false;
        Assert.assertEquals(isExist, expectedResult);
    }

    @Test(description = "Check IsCorrectUser with correct input")
    public void testIsCorrectUserWithCorrectInput() throws DaoException, GoogleException {
        UserService userService = new UserService();
        boolean isCorrectUser = userService.isCorrectUser("java1@mail.com", "qwerty1");
        boolean expectedResult = true;
        Assert.assertEquals(isCorrectUser, expectedResult);
    }

    @Test(description = "Check IsCorrectUser with incorrect input")
    public void testIsCorrectUserWithIncorrectInput() throws DaoException, GoogleException {
        UserService userService = new UserService();
        boolean isCorrectUser = userService.isCorrectUser("java1@mail.com", "qwссс");
        boolean expectedResult = false;
        Assert.assertEquals(isCorrectUser, expectedResult);
    }

    @Test(description = "Check IsCorrectUser with correct input")
    public void testGetUserWithCorrectInput() throws DaoException, GoogleException {
        UserService userService = new UserService();
        User user = userService.getUser("java1@mail.com");
        User expectedUser = new User(7, "java1@mail.com", "$argon2id$v=19$m=15360,t=2,p=1$JTMw4W9XbUi1e30Za8Lgv1nu247CkhvO7O8IR7Neld8$StUNMNfSM5Rxk/NF1OLdnyK51v5c6H/d1HJ33Yfp9x8", false, "java1@mail.com", false);
        Assert.assertEquals(user, expectedUser);
    }

    @Test(description = "Check getUser with incorrect input")
    public void testGetUserWithIncorrectInput() throws DaoException, GoogleException {
        UserService userService = new UserService();
        User user = userService.getUser("");
        User expectedUser = new User();
        Assert.assertEquals(user, expectedUser);
    }
}
