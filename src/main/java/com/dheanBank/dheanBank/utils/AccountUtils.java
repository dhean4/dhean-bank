package com.dheanBank.dheanBank.utils;

import java.time.Year;

public class AccountUtils {
    public static final String ACCOUNT_EXIST_CODE = "001";
    public static final String   ACCOUNT_EXISTS_MESSAGE = "this user already have an account with that email";
    public static final String ACCOUNT_CREATION_SUCCESS = "002  ";
    public static final String ACCOUNT_CREATION_SUCCESS_MESSAGE = "your account has been created successfully";
//    current year + random six digit
    public static String generateAccountNumber() {
        Year currentYear = Year.now();
        int minSixDigits = 100000;
        int maxSixDigits = 999999;
        int randNum = (int) Math.floor (Math.random() * (maxSixDigits - minSixDigits + 1));

        //convert current year and random number to string
        String Year = String.valueOf(currentYear.getValue());
        String randomNum = String.valueOf(randNum);
        StringBuilder accountNumber = new StringBuilder();

        accountNumber.append(Year).append(randomNum);
        return accountNumber.toString();
    }
}
