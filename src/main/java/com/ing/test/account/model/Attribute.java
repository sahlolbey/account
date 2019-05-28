package com.ing.test.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Attribute {
    public static final String LAST_GENERATED_ACCOUNT_NO="lastGeneratedAccountNo";
    @Id
    private String id;
    @Column(nullable = false, unique = false)
    private String value;

    public Attribute() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
