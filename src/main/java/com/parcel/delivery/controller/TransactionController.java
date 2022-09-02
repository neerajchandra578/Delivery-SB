package com.parcel.delivery.controller;

import com.parcel.delivery.error.DepartmentNotFound;
import com.parcel.delivery.model.Transaction;
import com.parcel.delivery.model.TransactionRequestBody;
import com.parcel.delivery.model.User;
import com.parcel.delivery.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins={"http://localhost:3000", "http://3.16.158.189:3000"})
@RestController
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(TransactionController.class);

    @PostMapping("/transactions")
    public Transaction saveUser(@Valid @RequestBody Transaction department) {
        LOGGER.info("Inside saveTransaction of TransactionController");
        return transactionService.saveTransaction(department);
    }

    @PostMapping("/transactions/mob")
    public Transaction saveTransaction(@Valid @RequestBody TransactionRequestBody department) {
        LOGGER.info("Inside save Transaction of TransactionController");

        return transactionService.saveTransactionFromMob(department);
    }

    @GetMapping("/transactions")
    public List<Transaction> fetchTransactionList() {
        LOGGER.info("Inside fetchTransactionList of TransactionController");
        return transactionService.fetchTransactionList();
    }

    @GetMapping("/transactions/trip/{id}")
    public List<Transaction> fetchTransactionListByTripId(@PathVariable("id") Long departmentId) {
        LOGGER.info("Inside fetchBy Trip Id  TransactionList of TransactionController");
        return transactionService.fetchTransactionListByTripId(departmentId);
    }
    //

    @GetMapping("/transactions/{id}")
    public Transaction fetchTransactionById(@PathVariable("id") Long departmentId)
            throws DepartmentNotFound {
        return transactionService.fetchvById(departmentId);
    }

    @DeleteMapping("/transactions/{id}")
    public String deleteTransactionById(@PathVariable("id") Long departmentId) {
        transactionService.deleteTransactionById(departmentId);
        return "Transaction deleted Successfully!!";
    }

    @PutMapping("/transactions/{id}")
    public Transaction updateDepartment(@PathVariable("id") Long departmentId,
                                 @RequestBody Transaction department) {
        return transactionService.updateTransaction(departmentId,department);
    }
}
