package com.chilkatsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChilkatExample {

    static {
        try {
            System.loadLibrary("chilkat");
//        System.loadLibrary("D:\\CompanyProjects\\chilkat-9.5.0-jdk11-x64");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Native code library failed to load.\n" + e);
            System.exit(1);
        }
    }

    public static void main(String argv[]) {
        // This example assumes the Chilkat API to have been previously unlocked.
        // See Global Unlock Sample for sample code.

        //明文
        String password = "mySecretPassword";
        //Hash
        HashMap<String, String> input = new HashMap<String, String>();
        input.put("1", "$2a$10$H5kIVktMGzAPKGKNAe9DVu0iwEqfhv/o4MMJ/Dzw/MPy1leOE9NOK");
        input.put("2", "$2a$10$H5kIVktMGzAPKGKNAe9DVu0iwEqfhv/o4MMJ/Dzw/MPy1leOE9NOK");
        input.put("3", "$2a$10$H5kIVktMGzAPKGKNAe9DVu0iwEqfhv/o4MMJ/Dzw/MPy1leOE9NOB");
        input.put("4", "$2a$10$H5kIVktMGzAPKGKNAe9DVu0iwEqfhv/o4MMJ/Dzw/MPy1leOE9NOC");
        input.put("5", "$2a$10$H5kIVktMGzAPKGKNAe9DVu0iwEqfhv/o4MMJ/Dzw/MPy1leOE9NOM");

        System.out.println("OAuth用户id一览：" + getOAuthUsers(password, input));
    }

    //得到list
    public static List<String> getOAuthUsers(String password, HashMap<String, String> input){
        CkCrypt2 crypt = new CkCrypt2();

        List OAuthGroup = new ArrayList<String>();

        for (String key : input.keySet()) {
            String storedHash = input.get(key);
            System.out.println(key);
            boolean passwordValid = crypt.BCryptVerify(password, storedHash);
            if (passwordValid == true) {
                System.out.println(key + "是OAUTHs");
                System.out.println(passwordValid);
                OAuthGroup.add(key);
            } else {
                System.out.println(passwordValid);
            }
        }
        return OAuthGroup;
    }
}