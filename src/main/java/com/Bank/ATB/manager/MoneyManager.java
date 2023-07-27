package com.Bank.ATB.manager;

import com.Bank.ATB.dto.MoneyDto;
import com.Bank.ATB.dto.PageResponse;
import com.Bank.ATB.dto.dtoManager.MoneyDtoManager;
import com.Bank.ATB.entity.Money;
import com.Bank.ATB.mapper.MoneyMapper;
import com.Bank.ATB.repository.MoneyRepository;
import com.Bank.ATB.service.MoneyService;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service

public class MoneyManager implements MoneyService {

    private final MoneyRepository moneyRepository;
//    private  final  MoneyDtoManager moneyDtoManager;

    private final MoneyMapper moneyMapper;
//    @Mapping(target = "user_id",source = "user_idisi")
    @Override
    public PageResponse getAllTypeOfMoney(Integer page, Integer count) {
      Page<Money>monyePage = moneyRepository.findAll(PageRequest.of(page,count));

        return new PageResponse(monyePage .getContent().stream().map(moneyMapper::toMoneyDto).toList(),

                monyePage .getTotalElements(),
                monyePage .getTotalPages(),
                monyePage .hasNext()
                );

    }



    @Override
    public MoneyDto getByIdWillTransfer(Integer id) {
        return moneyRepository.findById(id)
                .stream()
                .map(moneyMapper::toMoneyDto)
                .findFirst()
                .get();

    }

    @Override
    public void saveTransferedMoney(Money money) {
        moneyRepository.save(money);


    }




    @Override
    public void deleteAllTransaction() {
        moneyRepository.deleteAll();

    }

    @Override
    public void updateTransaction(Integer id,Money money) {
        Money updated = moneyRepository.findById(id).get();
        updated.setLimitOfMoneyTransaction(money.getLimitOfMoneyTransaction());
        updated.setTypeOfMoney(money.getTypeOfMoney());
        updated.setWillBeTransferedId(money.getWillBeTransferedId());

        moneyRepository.save(updated);

    }
}
