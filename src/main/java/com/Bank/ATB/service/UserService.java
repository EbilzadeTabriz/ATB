package com.Bank.ATB.service;

import com.Bank.ATB.dto.RegisterRequest;
import com.Bank.ATB.dto.UserDto;
import com.Bank.ATB.entity.User;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface UserService {

    List<UserDto> getAll();
    UserDto getById(Integer id);
     void saveUser(User user);
     void deleteById(Integer id);
     void deleteAll();
     void updateInfo(Integer id,User user);

User getUserByEmail(String email);
void register(RegisterRequest request);

}
