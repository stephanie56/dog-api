package com.szeng.dogapi.web;

import com.szeng.dogapi.service.DogServiceImpl;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ApiResponses(value = {
        @ApiResponse(code=400, message="This is a bad request, please follow the API documentation for the proper request format."),
        @ApiResponse(code=401, message="Due to security constrains, your access request cannot be authorized."),
        @ApiResponse(code=500, message="The server is down. Please make sure that the Dog microservice is running")
})
@RequestMapping("/dogs")
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


    /** Retrieve the dog breed by Id */
    @GetMapping("/{id}/breed")
    public ResponseEntity<String> getDogBreedById(@PathVariable Long id) throws Exception {
        String dogName = dogService.retrieveDogBreedById(id);
        return new ResponseEntity<String>(dogName, HttpStatus.OK);
    }

    /** Retrieve a list of dog names */
    @GetMapping("/breeds/names")
    public ResponseEntity<List<String>> getDogNames() {
        List<String> list = dogService.retrieveDogNames();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }
}
