package com.revature.demo.controllers;

import com.revature.demo.dto.TransferDTO;
import com.revature.demo.entities.Account;
import com.revature.demo.exceptions.AccountNotFoundException;
import com.revature.demo.exceptions.InsufficientFundsException;
import com.revature.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/accounts")
    public ResponseEntity<Account> insert(@RequestBody Account account) {
        account = this.accountService.insert(account);
        if(account != null) return new ResponseEntity<>(account, HttpStatus.CREATED);
        else return new ResponseEntity<>(new Account(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<Account> getById(@PathVariable("id") Long id) {
        Account account = this.accountService.getById(id);
        if(account != null) return new ResponseEntity<>(account, HttpStatus.OK);
        else return new ResponseEntity<>(new Account(), HttpStatus.BAD_REQUEST);

    }

    // Patch requests can be used for updating only a handful of fields
    @PatchMapping("/accounts")
    public ResponseEntity<List<Account>> transfer(@RequestBody TransferDTO transfer) throws AccountNotFoundException, InsufficientFundsException {
        Long donorId = transfer.getDonorId();
        Long recipId = transfer.getRecipId();
        int amount = transfer.getAmount();
        List<Account> accounts = this.accountService.transferFunds(donorId, recipId, amount);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
}
