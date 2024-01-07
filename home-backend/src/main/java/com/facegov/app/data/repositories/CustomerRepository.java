package com.facegov.app.data.repositories;

import com.facegov.app.data.entities.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {

  CustomerEntity findByEmail(String email);

}
