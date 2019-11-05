package com.szeng.dogapi.service;

import com.szeng.dogapi.entity.Dog;
import com.szeng.dogapi.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {

    /** Inject DogRepository */
    @Autowired
    DogRepository dogRepository;

    @Override
    public List<String> retrieveDogBreed() {
        return dogRepository.finAllBreeds();
    }

    @Override
    public String retrieveDogBreedById(Long id) {
        /* Optional is intended to provide a mechanism for method return types
         * where there needed to be a clear way to represent "no result"
         */
        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findBreedById(id));
        /* Use orElseThrow Not Found exception in case the result is null */
        String breed = optionalBreed.orElseThrow(DogNotFoundException::new);
        return breed;
    }

    @Override
    public List<String> retrieveDogNames() {
        return dogRepository.findAllDogNames();
    }
}
