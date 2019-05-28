package com.ing.test.account.service;

import com.ing.test.account.dao.AccountRepository;
import com.ing.test.account.dao.AttributeRepository;
import com.ing.test.account.dao.UserRepository;
import com.ing.test.account.dto.AccountDTO;
import com.ing.test.account.dto.UserPrincipal;
import com.ing.test.account.model.Account;
import com.ing.test.account.model.Attribute;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    /*
        @Autowired
        AttributeRepository attributeRepository;
    */
    @Autowired
    AttributeRepository attributeRepository;
    @Autowired
    UserRepository userRepository;

    /**
     * This method created an account using information provided by user.
     * It created a six digit account number for the user
     * @param accountDTO
     */
    @Transactional
    public void saveAccount(AccountDTO accountDTO) {

        long accountNo=1;
        // load last generated account number from database
        Optional<Attribute> attributeOptional =Optional.ofNullable( attributeRepository.findById(Attribute.LAST_GENERATED_ACCOUNT_NO));
        Attribute attribute;
        // if we already generated account number then increament it to get a new account number
        if (attributeOptional.isPresent()) {

            attribute = attributeOptional.get();
            accountNo = Long.valueOf(attribute.getValue()) + 1;
        } else {
            //otherwise the initial accountNo will be 0000001
            attribute = new Attribute();
            attribute.setId(Attribute.LAST_GENERATED_ACCOUNT_NO);
            attribute.setValue(Long.toString(accountNo));
        }
        Account account = new Account();
        BeanUtils.copyProperties(accountDTO, account);
        NumberFormat nf = new DecimalFormat("000000");
        String accountNoStr = nf.format(accountNo);
        account.setAccountNO(accountNoStr);

        accountRepository.save(account);
        attributeRepository.save(attribute);
        BeanUtils.copyProperties(account, accountDTO);

    }
    public boolean userHasAccount(UserPrincipal user){
       Account account = accountRepository.findByUserId(user.getUser().getId());
       if(account==null){
           return false;
       }
       return true;
    }

    /**
     * Finds user using user id.
     * In case the it can't find the user the returns and AccountDO with null properties.
     * @param user
     * @return
     */
    public AccountDTO getUserAccount(UserPrincipal user){
        Account account = accountRepository.findByUserId(user.getUser().getId());
        AccountDTO accountDTO = new AccountDTO();
        if (account != null) {
            BeanUtils.copyProperties(account, accountDTO);
        }


        return accountDTO;
    }



}

