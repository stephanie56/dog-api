package com.szeng.dogapi.repository;

import com.szeng.dogapi.entity.Dog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/** Create, read, update and delete Dog objects */
@Repository
public interface DogRepository extends CrudRepository<Dog, Long> {
}
