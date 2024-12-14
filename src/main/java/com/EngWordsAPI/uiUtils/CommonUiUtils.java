package com.EngWordsAPI.uiUtils;


//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Random;

public class CommonUiUtils {
    public static String concatenateFirstLetters(String name) {
        if(name == null || name.isEmpty()){
            return "";
        }
        String output = "";
        for (String word : name.split(" ")) {
            output += word.charAt(0);
        }
        return output;
    }

    public static String generateRandomNumber(String generatedNumber, int noOfDigits){
        if(generatedNumber == null || generatedNumber.isEmpty() || generatedNumber.isBlank()){
            return "";
        }

        Random random = new Random();
        String randomNumber = "";
        // Generate noOfDigits random indices to select digits from the mobile number
        for (int i = 0; i < noOfDigits; i++) {
            int randomIndex = random.nextInt(generatedNumber.toString().length());
            randomNumber = randomNumber + generatedNumber.charAt(randomIndex);
        }
        return randomNumber;
    }

//    public static String encryptPassword(String password){
//        BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
//        String hashedPassword = pwdEncoder.encode(password);
//        return hashedPassword;
//    }
//
//    public static boolean isValidEncryptPwd(String password, String encryptedPassword){
//        BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
//        return pwdEncoder.matches(password, encryptedPassword);
//    }

}
