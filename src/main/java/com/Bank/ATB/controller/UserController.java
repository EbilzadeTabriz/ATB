package com.Bank.ATB.controller;

import com.Bank.ATB.dto.RegisterRequest;
import com.Bank.ATB.dto.UserDto;
import com.Bank.ATB.entity.User;
import com.Bank.ATB.manager.UserManager;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ATB/User")
@RequiredArgsConstructor
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    private  final UserManager userManager;


    @GetMapping
    public List<UserDto> getAll() {
        logger.info("get AllRequest accepted");
        return userManager.getAll() ;
    }@GetMapping("/{id}")
    public UserDto getById(@PathVariable Integer id) {
        logger.info("got it");
        return userManager.getById(id);
    }
    @PostMapping
    @PreAuthorize("hasRole('User')")

    public void saveUser(@RequestBody @Valid  User user) {
        logger.info("Saved");
      userManager.saveUser(user);

    }@DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        logger.info("deleted");

      userManager.deleteById(id);

    }@DeleteMapping
    public void deleteAll() {
        logger.info("Empty");
        userManager.deleteAll();

    }@PutMapping("/{id}")
    public void updateInfo(@PathVariable Integer id,@RequestBody User user){
        logger.info("updated");
        userManager.updateInfo(id, user);

    }
    @PostMapping("/register")
    public void register(@RequestBody @Valid RegisterRequest request){

        userManager.register(request);
    }

}
