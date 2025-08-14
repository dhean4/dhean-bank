package com.dheanBank.dheanBank.service.impl;

import com.dheanBank.dheanBank.dto.BankResponse;
import com.dheanBank.dheanBank.dto.UserRequest;

public interface UserService {
    BankResponse createAccount(UserRequest userRequest);
}
