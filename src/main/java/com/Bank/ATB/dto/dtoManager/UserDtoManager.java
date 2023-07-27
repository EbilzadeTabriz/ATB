package com.Bank.ATB.dto.dtoManager;

import com.Bank.ATB.dto.UserDto;
import com.Bank.ATB.entity.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class UserDtoManager implements Function<User, UserDto> {
    @Override
    public UserDto apply(User user) {
        return new UserDto(user.getName(),user.getSurname());
    }
}
