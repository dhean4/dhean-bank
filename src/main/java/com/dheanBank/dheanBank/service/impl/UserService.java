package com.dheanBank.dheanBank.service.impl;

import com.dheanBank.dheanBank.dto.*;

public interface UserService {
    BankResponse createAccount(UserRequest userRequest);
    String nameEnquiry(EnquiryRequest request);
    BankResponse debitAccount(CreditDebitRequest request);

    BankResponse balanceEnquiry(EnquiryRequest request);

    BankResponse creditAccount(CreditDebitRequest request);

    BankResponse transfer(TransferRequest request);
}