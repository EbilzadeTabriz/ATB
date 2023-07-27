package com.Bank.ATB.mapper;

import com.Bank.ATB.dto.RegisterRequest;
import com.Bank.ATB.dto.UserDto;
import com.Bank.ATB.entity.User;
import com.Bank.ATB.security.UserDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel ="spring")
public interface UserMapper {
    UserDto  toUserDto(User user);
    User toUser(UserDto userDto);

    UserDetails toUserDetails(User user);

User touserFromRegisterRequest(RegisterRequest request);
// test methof






}
