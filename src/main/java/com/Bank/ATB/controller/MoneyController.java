package com.Bank.ATB.controller;

import com.Bank.ATB.dto.MoneyDto;
import com.Bank.ATB.dto.PageResponse;
import com.Bank.ATB.entity.Money;
import com.Bank.ATB.manager.MoneyManager;

import lombok.RequiredArgsConstructor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ATB/Money")
@RequiredArgsConstructor

public class MoneyController {
Logger logger = LoggerFactory.getLogger(MoneyController.class);
    private final MoneyManager moneyManager;

    @GetMapping
    public PageResponse getAllTypeOfMoney(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "count") int count
    ) {
        logger.info("Okay");
        return moneyManager.getAllTypeOfMoney(page,count);

    }@GetMapping("/{id}")
    public MoneyDto getByWillTransfer(@PathVariable Integer id) {
        logger.info("got it");
        return moneyManager.getByIdWillTransfer(id);}
 @PostMapping()
 @ResponseStatus(code = HttpStatus.CREATED)

 public void saveTransferedMoney(@RequestBody  Money money) {
        logger.info("Saved");
        moneyManager.saveTransferedMoney(money);

    }@DeleteMapping
    public void deleteAllTransaction() {
        logger.info("Deleted");
        moneyManager.deleteAllTransaction();

    }@PutMapping("/{id}")
    public void updateTransaction(@PathVariable Integer id,@RequestBody Money money) {
        logger.info("Updated");
        moneyManager.updateTransaction(id, money);


    }

}

