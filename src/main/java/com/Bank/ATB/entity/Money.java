package com.Bank.ATB.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Money")
public class Money {

    @Id
    @NotNull
   Integer WillBeTransferedId;


    @NotEmpty
    @NotBlank
    @Column(name = "Kind of Money")
    String TypeOfMoney;

    @NotNull
    @Column(name = "Limit for money")
    Integer LimitOfMoneyTransaction;




}
