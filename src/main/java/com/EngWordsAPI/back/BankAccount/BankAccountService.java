package com.EngWordsAPI.back.BankAccount;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    public List<BankAccount> getAllAccounts() {
        return bankAccountRepository.findAll();
    }

    public Optional<BankAccount> getAccountById(Long id) {
        return bankAccountRepository.findById(id);
    }

    public BankAccount createAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    public BankAccount updateAccount(Long id, BankAccount bankAccountDetails) {
        BankAccount bankAccount = bankAccountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("BankAccount not found for this id :: " + id));
        bankAccount.setAccountHolderName(bankAccountDetails.getAccountHolderName());
        bankAccount.setBalance(bankAccountDetails.getBalance());
        return bankAccountRepository.save(bankAccount);
    }

    public void deleteAccount(Long id) {
        BankAccount bankAccount = bankAccountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("BankAccount not found for this id :: " + id));
        bankAccountRepository.delete(bankAccount);
    }
}