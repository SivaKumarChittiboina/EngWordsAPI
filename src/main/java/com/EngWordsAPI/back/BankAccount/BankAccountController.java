package com.EngWordsAPI.back.BankAccount;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bankaccounts")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping
    public List<BankAccount> getAllAccounts() {
        return bankAccountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankAccount> getAccountById(@PathVariable(value = "id") Long id) {
        BankAccount bankAccount = bankAccountService.getAccountById(id).orElseThrow(() -> new ResourceNotFoundException("BankAccount not found for this id :: " + id));
        return ResponseEntity.ok().body(bankAccount);
    }

    @PostMapping
    public BankAccount createAccount(@RequestBody BankAccount bankAccount) {
        return bankAccountService.createAccount(bankAccount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankAccount> updateAccount(@PathVariable(value = "id") Long id, @RequestBody BankAccount bankAccountDetails) {
        BankAccount updatedBankAccount = bankAccountService.updateAccount(id, bankAccountDetails);
        return ResponseEntity.ok(updatedBankAccount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable(value = "id") Long id) {
        bankAccountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }
}