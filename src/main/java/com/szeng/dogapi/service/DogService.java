package com.szeng.dogapi.service;

import com.szeng.dogapi.entity.Dog;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DogService {
    List<Dog> retrieveDogBreed ();

}