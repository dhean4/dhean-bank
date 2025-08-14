package com.dheanBank.dheanBank.service.impl.impl;

import com.dheanBank.dheanBank.dto.AccountInfo;
import com.dheanBank.dheanBank.dto.BankResponse;
import com.dheanBank.dheanBank.dto.EmailDetails;
import com.dheanBank.dheanBank.dto.UserRequest;
import com.dheanBank.dheanBank.entity.User;
import com.dheanBank.dheanBank.repository.UserRepository;
import com.dheanBank.dheanBank.service.impl.EmailService;
import com.dheanBank.dheanBank.service.impl.UserService;
import com.dheanBank.dheanBank.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class userServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public BankResponse createAccount(UserRequest userRequest) {
        //check if the user already have an account
//        creating an account is saving a new user into the DB-builder pattern
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            return  BankResponse
                    .builder()
                    .responseCode(AccountUtils.ACCOUNT_EXIST_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_EXISTS_MESSAGE)
                    .accountInfo(null)
                    .build();
        }
        User newUser = User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .otherName(userRequest.getOtherName())
                .gender(userRequest.getGender())
                .address(userRequest.getAddress())
                .stateOfOrigin(userRequest.getStateOfOrigin())
                .accountNumber(AccountUtils.generateAccountNumber())
                .accountBalance(BigDecimal.ZERO)
                .email(userRequest.getEmail())
                .phoneNumber(userRequest.getPhoneNumber())
                .alternatePhoneNumber(userRequest.getAlternatePhoneNumber())
                .status("ACTIVE")
                .build();

        User savedUser= userRepository.save(newUser);
        //send email Alert
        EmailDetails emailDetails = EmailDetails.builder()
                .recipient(userRequest.getEmail())
                .subject("ACCOUNT CREATION")
                .attachment(userRequest.getAddress())
                .messageBody("Congratulations your account has been successfully created! Your account details is \n Account Name: " + savedUser.getFirstName() + " "  + savedUser.getLastName() + " " + savedUser.getOtherName() + "\nAccount Number: " + savedUser.getAccountNumber() )
                .build();
        emailService.sendEmailAlert(emailDetails);
        return BankResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_CREATION_SUCCESS)
                .responseMessage(AccountUtils.ACCOUNT_EXISTS_MESSAGE)
                .accountInfo(AccountInfo.builder()
                        .accountNumber(savedUser.getAccountNumber())
                        .accountBalance(savedUser.getAccountBalance())
                        .accountName(savedUser.getFirstName() + " " + savedUser.getLastName() + " " + savedUser.getOtherName())
                        .build())
                .build();
    }
}
