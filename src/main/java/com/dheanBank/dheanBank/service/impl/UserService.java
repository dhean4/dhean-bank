package com.dheanBank.dheanBank.service.impl;

import com.dheanBank.dheanBank.dto.BankResponse;
import com.dheanBank.dheanBank.dto.CreditDebitRequest;
import com.dheanBank.dheanBank.dto.EnquiryRequest;
import com.dheanBank.dheanBank.dto.UserRequest;

public interface UserService {
    BankResponse createAccount(UserRequest userRequest);
    String nameEnquiry(EnquiryRequest request);
    BankResponse debitAccount(CreditDebitRequest request);

    BankResponse balanceEnquiry(EnquiryRequest request);

    BankResponse creditAccount(CreditDebitRequest request);
}