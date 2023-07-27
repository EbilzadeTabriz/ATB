package com.Bank.ATB.service;

import com.Bank.ATB.dto.MoneyDto;
import com.Bank.ATB.dto.PageResponse;
import com.Bank.ATB.entity.Money;
import com.Bank.ATB.entity.User;

import java.util.List;

public interface MoneyService {
   PageResponse getAllTypeOfMoney(Integer page, Integer count);

    MoneyDto getByIdWillTransfer(Integer id);

    void saveTransferedMoney(Money money);



    void deleteAllTransaction();
    void updateTransaction(Integer id,Money money);







}
