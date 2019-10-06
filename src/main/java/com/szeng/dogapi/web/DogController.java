package com.szeng.dogapi.web;

import com.szeng.dogapi.entity.Dog;
import com.szeng.dogapi.service.DogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {
    private DogServiceImpl dogService;

    /** Inject Dog Service */
    @Autowired
    public void setDogService(DogServiceImpl dogServiceImpl) {
        this.dogService = dogServiceImpl;
    }

    /** Retrieve a list of Dog breeds */
    @GetMapping("/breeds")
    public ResponseEntity<List<String>> getAllDogBreeds() {
        List<String> list = dogService.retrieveDogBreed();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }


    /** Retrieve a list of Dog breeds by Id */
    @GetMapping("/breeds/{id}")
    public ResponseEntity<String> getDogBreedsById(@PathVariable Long id) {
        String dogName = dogService.retrieveDogBreedById(id);
        return new ResponseEntity<String>(dogName, HttpStatus.OK);
    }

    /** Retrieve a list of Dog name */
    @GetMapping("/names")
    public ResponseEntity<List<String>> getDogNames() {
        List<String> list = dogService.retrieveDogNames();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }
}
