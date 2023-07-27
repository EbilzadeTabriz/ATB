package com.Bank.ATB.mapper;

import com.Bank.ATB.dto.MoneyDto;
import com.Bank.ATB.entity.Money;
import org.mapstruct.Mapper;

@Mapper(componentModel ="spring" )

public interface MoneyMapper {

    MoneyDto toMoneyDto(Money money);

    Money toMoney(MoneyDto moneyDto);
}
