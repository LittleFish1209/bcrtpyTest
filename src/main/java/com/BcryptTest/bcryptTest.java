package com.BcryptTest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class bcryptTest {


    public static void main(String[] argv) {
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

        List OAuthGroup = new ArrayList<String>();

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        for(String key : input.keySet()){
            String storedHash = input.get(key);
            System.out.println("用户ID"+key);
            boolean passwordValid = passwordEncoder.matches(password, storedHash);
            if(passwordValid == true){
                System.out.println(key + "是OAuth用户");
                System.out.println(passwordValid);
                OAuthGroup.add(key);
            }else{
                System.out.println(key + "不是OAuth用户");
                System.out.println(passwordValid);
            }
        }
        return OAuthGroup;
    }
}