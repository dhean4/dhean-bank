package com.dheanBank.dheanBank.utils;

import java.time.Year;

public class AccountUtils {
    public static final String ACCOUNT_EXIST_CODE = "001";
    public static final String ACCOUNT_EXISTS_MESSAGE = "This user already has an account Created!";
    public static final String ACCOUNT_CREATION_SUCCESS = "002";
    public static final String ACCOUNT_CREATION_MESSAGE = "Account has been successfully created!";
    public static final String ACCOUNT_NOT_EXIST_CODE = "003";
    public static final String ACCOUNT_NOT_EXIST_MESSAGE = "User with the provided Account Number does not exist";
    public static final String ACCOUNT_FOUND_CODE = "004";
    public static final String ACCOUNT_FOUND_SUCCESS = "User Account Found";
    public static final String ACCOUNT_CREDITED_SUCCESS = "005";
    public static final String ACCOUNT_CREDITED_SUCCESS_MESSAGE = "User Account was credited successfully";
    public static final String INSUFFICIENT_BALANCE_CODE = "006";
    public static final String INSUFFICIENT_BALANCE_MESSAGE = "Insufficient Balance";
    public static final String ACCOUNT_DEBITED_SUCCESS = "007";
    public static final String ACCOUNT_DEBITED_MESSAGE = "Account has been successfully debited";

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
