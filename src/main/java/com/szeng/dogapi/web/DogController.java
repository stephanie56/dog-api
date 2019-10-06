package com.szeng.dogapi.web;

import com.szeng.dogapi.entity.Dog;
import com.szeng.dogapi.service.DogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<List<Dog>> getAllDogBreeds() {
        List<Dog> list = dogService.retrieveDogBreed();
        return new ResponseEntity<List<Dog>>(list, HttpStatus.OK);
    }


//    /** Retrieve a list of Dog breeds by Id */
//    @GetMapping("/breeds/${id}")
//    public ResponseEntity<List<Dog>> getDogBreedsById(String id) {
//        List<Dog> list = dogService.retrieveDogBreedById(id);
//        return new ResponseEntity<List<Dog>>(list, HttpStatus.OK);
//    }
//
//    /** Retrieve a list of Dog name */
//    @GetMapping("/names")
//    public ResponseEntity<List<Dog>> getDogNames() {
//        List<Dog> list = dogService.retrieveDogNames();
//        return new ResponseEntity<List<Dog>>(list, HttpStatus.OK);
//    }
}
