package com.ing.test.account.dao;

import com.ing.test.account.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // where LOWER(user.username)=LOWER(:username)
   // @Query("SELECT user from User user ")
    User findByUsername(String username);
}
