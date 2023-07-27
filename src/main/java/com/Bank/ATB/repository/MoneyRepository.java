package com.Bank.ATB.repository;

import com.Bank.ATB.entity.Money;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyRepository  extends JpaRepository<Money,Integer> {

}
