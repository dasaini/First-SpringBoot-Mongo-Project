package com.example.demo_mongodb_springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Creating in Mongo Database
    @RequestMapping(value = "v1/user/post", method = RequestMethod.POST)
    public ResponseEntity<UserData> postUserDataMongoDatabase (@RequestBody UserData userData){


        UserData userData1 = new UserData();
        userData1.setUserFirstName(userData.getUserFirstName());
        userData1.setUserLastName(userData.getUserLastName());
        userData1.setUserDob(userData.getUserDob());
        userData1.setUserAddress(userData.getUserAddress());
        userData1.setUserCity(userData.getUserCity());
        userData1.setUserState(userData.getUserState());
        userData1.setUserZip(userData.getUserZip());

        this.userRepository.save(userData1);


        UserData userRepositoryById = this.userRepository.findById(userData1.getId()).get();

        return new ResponseEntity<>(userData1, HttpStatus.OK);


    }

    // Retrieve all data within Collection in Mongo Database
    @RequestMapping(value = "v1/user/get", method = RequestMethod.GET)
    public List<UserData> getUserData(){
        List<UserData> userData = this.userRepository.findAll();
        return userData;
    }


    // Retrieve by ID
    @RequestMapping(value = "v1/user/post/searchOptional", method = RequestMethod.POST)
    public ResponseEntity<UserData> searchUserId (@RequestBody String id){

        UserData userRepositoryById = this.userRepository.findById(id).get();

        return new ResponseEntity<>(userRepositoryById, HttpStatus.OK);


    }

    //Retrieve data from database and send back to postman in form of JSON
    @RequestMapping(value = "v4/user", method = RequestMethod.GET)
    public List<UserData> getAll(){
        List<UserData> userDataList = this.userRepository.findAll();
        return userDataList;
    }


    //Delete record in database by Id
    //Delete
    @RequestMapping(value = "v5/user/deleteById/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id) {
        this.userRepository.deleteById(id);
    }

}



