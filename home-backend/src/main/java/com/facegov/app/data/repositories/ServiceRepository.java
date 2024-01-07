package com.facegov.app.data.repositories;

import com.facegov.app.data.entities.ServiceEntity;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<ServiceEntity, Long> {

}
