package com.revature.demo.services;

import com.revature.demo.entities.Account;
import com.revature.demo.exceptions.AccountNotFoundException;
import com.revature.demo.exceptions.InsufficientFundsException;
import com.revature.demo.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.nio.channels.AcceptPendingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account insert(Account account) {
        return accountRepository.save(account);
    }

    // This method is calling repository methods so we can annotate it with @Transactional
    // Here, we are specifying that these database commands should be read-only and not read any uncommitted data
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public Account getById(Long id) {
        Optional<Account> accountOptional = this.accountRepository.findById(id);
        if(accountOptional.isPresent()) return accountOptional.get();
        else return null;
    }

    @Transactional(readOnly = false, rollbackFor = InsufficientFundsException.class)
    public List<Account> transferFunds(Long donorId, Long recipId, int amount) throws AccountNotFoundException, InsufficientFundsException{
        List<Account> accounts = new ArrayList<>();
        Account account2 = addFunds(recipId, amount);
        Account account1 = deductFunds(donorId, amount);
        accounts.add(account1);
        accounts.add(account2);
        return accounts;
    }

    //propagation required means that we either use the existing transaction (if it exists)
    // or throw an exception
    @Transactional(propagation = Propagation.MANDATORY, rollbackFor = InsufficientFundsException.class)
    // Set up 2 methods, one to add money to an account and one to withdraw money
    public Account deductFunds(Long id, int difference) throws AccountNotFoundException, InsufficientFundsException {
        Optional<Account> accountOptional = this.accountRepository.findById(id);
        if(accountOptional.isPresent()) {
            // do logic of deducting money
            Account account = accountOptional.get();
            int currentAmount = account.getAmount();
            int newAmount = currentAmount - difference;
            if(newAmount < 0) throw new InsufficientFundsException();
            account.setAmount(newAmount);
            // persist changes back to the repository
            account = this.accountRepository.save(account);
            return account;
        }
        else {
            throw new AcceptPendingException();
        }
    }
    //
    @Transactional(propagation = Propagation.MANDATORY, rollbackFor = InsufficientFundsException.class)
    // Set up 2 methods, one to add money to an account and one to withdraw money
    public Account addFunds(Long id, int moneyToAdd) throws AccountNotFoundException {
        Optional<Account> accountOptional = this.accountRepository.findById(id);
        if(accountOptional.isPresent()) {
            // do logic of deducting money
            Account account = accountOptional.get();
            int currentAmount = account.getAmount();
            int newAmount = currentAmount + moneyToAdd;
            account.setAmount(newAmount);
            // persist changes back to the repository
            account = this.accountRepository.save(account);
            return account;
        }
        else {
            throw new AcceptPendingException();
        }
    }


}
