package com.szeng.dogapi.service;

import com.szeng.dogapi.entity.Dog;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DogService {
    List<String> retrieveDogBreed ();

    String retrieveDogBreedById(Long id);

    List<String> retrieveDogNames();
}
