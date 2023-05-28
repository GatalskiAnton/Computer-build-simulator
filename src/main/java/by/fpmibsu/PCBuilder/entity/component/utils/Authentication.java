package by.fpmibsu.PCBuilder.entity.component.utils;

import com.password4j.Hash;
import com.password4j.Password;

public class Authentication {

    public static boolean isCorrectPassword(String userPassword, String dbUserPassword){
        try {
            return Password.check(userPassword,dbUserPassword).addPepper("antoshka, sashka, boriska, yuga").withArgon2();
        }
        catch ( Exception e) {
            System.out.println(e);
            return  false;
        }
    }

    public static String getHashPassword(String password) {
        Hash hash =  Password.hash(password).addPepper("antoshka, sashka, boriska, yuga").withArgon2();
        return hash.getResult();
    }
}