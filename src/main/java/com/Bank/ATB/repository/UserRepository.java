package com.Bank.ATB.repository;

import com.Bank.ATB.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


//    @Query
//    List<User> getUserWhoIsOlder(@Param("age") Integer age);
Optional<User> findUserByEmail(String email);
}
