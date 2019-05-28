package com.ing.test.account.dao;

import com.ing.test.account.model.Attribute;
import org.springframework.data.repository.CrudRepository;

public interface AttributeRepository extends CrudRepository<Attribute,Long> {

    public Attribute findById(String id);
}
