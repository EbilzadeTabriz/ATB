package com.Bank.ATB.manager;

import com.Bank.ATB.dto.RegisterRequest;
import com.Bank.ATB.dto.UserDto;
import com.Bank.ATB.dto.dtoManager.UserDtoManager;
import com.Bank.ATB.entity.User;
import com.Bank.ATB.exception.UserNotFoundException;
import com.Bank.ATB.mapper.UserMapper;
import com.Bank.ATB.repository.UserRepository;
import com.Bank.ATB.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;




@RequiredArgsConstructor
@Service
public class UserManager implements UserService {
    private final UserMapper mapper;
private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

private final UserDtoManager userDtoManager;
    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll()
                .stream().map(mapper::toUserDto).toList();
    }

    @Override
    public UserDto getById(Integer id) {
        return userRepository.findById(id)
                .stream()
                .map(mapper::toUserDto)
                .findFirst()
                .orElseThrow(()->new UserNotFoundException("not found"));

    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);

    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);

    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();

    }

    @Override
    public void updateInfo(Integer id, User user) {
        User updated = userRepository.findById(id).get();
        updated.setId(user.getId());
        updated.setName(user.getName());
        updated.setSurname(user.getSurname());

        userRepository.save(updated);

    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email)
                .orElseThrow(()-> new UserNotFoundException("not found"));
    }

    @Override
    public void register(RegisterRequest request) {
     User user =   mapper.touserFromRegisterRequest(request);
                     user.setPassword(passwordEncoder.encode(request.password()));
userRepository.save(user);
    }


}
