package com.ing.test.account.dto;

import com.ing.test.account.model.User;

public class AccountDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String accountNO;
    private User user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAccountNO() {
        return accountNO;
    }

    public void setAccountNO(String accountNo) {
        this.accountNO = accountNo;
    }
}
