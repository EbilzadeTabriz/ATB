package com.Bank.ATB.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "User")
public class User {
    @NotNull
    @Id
    Integer id;
    @NotEmpty
    @NotBlank
    @Column(name = "UserName")
    String name;
    @NotEmpty
    @NotBlank
    @Column(name = "UserSurname")
    String surname;
    private String email;
    private String password;
    @Column(name = "is_active")
    private  Boolean isActive;

}
