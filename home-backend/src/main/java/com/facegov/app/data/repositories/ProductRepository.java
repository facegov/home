package com.facegov.app.data.repositories;

import com.facegov.app.data.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

}
