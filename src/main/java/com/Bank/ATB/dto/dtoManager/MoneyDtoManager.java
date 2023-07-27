package com.Bank.ATB.dto.dtoManager;

import com.Bank.ATB.dto.MoneyDto;
import com.Bank.ATB.entity.Money;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class MoneyDtoManager implements Function<Money, MoneyDto> {
    @Override
    public MoneyDto apply(Money money) {
        return new  MoneyDto(money.getTypeOfMoney(),money.getLimitOfMoneyTransaction());
    }
}
