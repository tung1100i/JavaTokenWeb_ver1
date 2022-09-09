package com.example.JavaTokenWeb_ver1.services;

import com.example.JavaTokenWeb_ver1.entities.AccountEntity;
import com.example.JavaTokenWeb_ver1.repositories.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService, UserDetailsService {

    @Autowired
    AccountRepo accountRepo;

//    @Bean


    @Override
    public List<AccountEntity> findAll() {
        return accountRepo.findAll();
    }

    @Override
    public AccountEntity addAccount(AccountEntity account) {
        AccountEntity newaccount = new AccountEntity();
        newaccount.setUsername(account.getUsername());
        String newpass = account.bCryptPasswordEncoder(account.getPassword()).encode(account.getPassword());
        newaccount.setPassword(newpass);
        newaccount.setFullname(account.getFullname());
        newaccount.setRole(account.getRole());
        accountRepo.save(newaccount);

        return newaccount;
    }

    @Override
    public Optional<AccountEntity> findUsername(String username) {
        return accountRepo.findById(username);
    }

    @Override
    public Optional<AccountEntity> findName(String name) {
        return accountRepo.findByName(name);
    }

    @Override
    public void deleteAccountByUsername(String username) {
        accountRepo.deleteById(username);
    }

    @Override
    public AccountEntity updateAccount(AccountEntity account) {
        AccountEntity updateAcc = accountRepo.findByUsername(account.getUsername());
        String newpass = account.bCryptPasswordEncoder(account.getPassword()).encode(account.getPassword());
        updateAcc.setPassword(newpass);
        updateAcc.setFullname(account.getFullname());
        accountRepo.save(updateAcc);
        return updateAcc;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDetails user = accountRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }
        return user;
    }
}
