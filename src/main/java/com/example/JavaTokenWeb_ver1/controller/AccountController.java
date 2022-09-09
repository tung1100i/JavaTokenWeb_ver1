package com.example.JavaTokenWeb_ver1.controller;


import com.example.JavaTokenWeb_ver1.entities.AccountEntity;
import com.example.JavaTokenWeb_ver1.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    IAccountService iAccountService;


    //GET ALL
    @GetMapping("/getAll")
    public List<AccountEntity> getAll() {
        System.out.printf("send oke");
        return iAccountService.findAll();
    }

    // CREATE NEW USER
    @PostMapping("/add")
    public AccountEntity createAccount(@RequestBody AccountEntity account) {
        return iAccountService.addAccount(account);
    }

    //FIND BY USERNAME
    @GetMapping("/find-username/{username}")
    public Optional<AccountEntity> findByUsername(@PathVariable String username) {
        return iAccountService.findUsername(username);
    }

    //FIND ALL BY NAME
    @GetMapping("/find-name/{name}")
    public Optional<AccountEntity> findByname(@PathVariable String name) {
        return iAccountService.findName(name);
    }

    //DELETE BY USERNAME
    @DeleteMapping("/delete-username/{username}")
    public void deleteAccountByUsername(@PathVariable String username) {
        iAccountService.deleteAccountByUsername(username);
    }

    //EDIT BY USERNAME
    @PutMapping("/edit/{username}")
    public AccountEntity updateAcc(@RequestBody AccountEntity updateUserById, @PathVariable String username) {

            return iAccountService.updateAccount(updateUserById);
    }


}
