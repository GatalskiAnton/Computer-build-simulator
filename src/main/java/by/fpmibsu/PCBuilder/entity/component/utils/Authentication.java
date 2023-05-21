package by.fpmibsu.PCBuilder.entity.component.utils;

import com.password4j.Hash;
import com.password4j.Password;

public class Authentication {

    public static boolean isCorrectPassword(String userPassword, String dbUserPassword){
        return Password.check(userPassword, dbUserPassword).addPepper("antoshka, sashka, boriska, yuga").withArgon2();
    }

    public static String getHashPassword(String password) {
        Hash hash =  Password.hash(password).addRandomSalt(32).addPepper("antoshka, sashka, boriska, yuga").withArgon2();
        return hash.getResult();
    }
}
