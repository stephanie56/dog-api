package com.szeng.dogapi.repository;

import com.szeng.dogapi.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/** Create, read, update and delete Dog objects */
@Repository
public interface DogRepository extends CrudRepository<Dog, Long> {
    @Query("select d.breed from Dog d")
    List<String> finAllBreeds();

    @Query("select d.breed from Dog d where d.id=:id")
    String findBreedById(Long id);

    @Query("select d.name from Dog d")
    List<String> findAllDogNames();
}
