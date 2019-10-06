package com.szeng.dogapi.service;

import com.szeng.dogapi.entity.Dog;
import com.szeng.dogapi.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogServiceImpl implements DogService {

    /** Inject DogRepository */
    @Autowired
    DogRepository dogRepository;

    public List<String> retrieveDogBreed() {
        return (List<String>) dogRepository.finAllBreeds();
    }

    public String retrieveDogBreedById(Long id) {
        return (String) dogRepository.findBreedById(id);
    }

    public List<String> retrieveDogNames() {
        return dogRepository.findAllDogNames();
    }
}
