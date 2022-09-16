package com.example.JavaTokenWeb_ver1.services;


import com.example.JavaTokenWeb_ver1.entities.AccountEntity;

import java.util.List;
import java.util.Optional;

public interface IAccountService {

    //GET ALL ACCOUNT
    List<AccountEntity> findAll();

    //ADD ACCOUNT
    AccountEntity addAccount(AccountEntity account);

    // FIND BY USERNAME
    Optional<AccountEntity> findUsername(String username);

    Optional<AccountEntity> findName(String name);

    //DELETE
    void deleteAccountByUsername(String username);

    //UPDATE
    AccountEntity updateAccount(AccountEntity account);
//    String findTransByusername(String username);

}
