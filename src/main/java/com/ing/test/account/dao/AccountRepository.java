package com.ing.test.account.dao;

import com.ing.test.account.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountRepository extends CrudRepository<Account,Long> {
    public Account findByUserId(Long userId);
}
