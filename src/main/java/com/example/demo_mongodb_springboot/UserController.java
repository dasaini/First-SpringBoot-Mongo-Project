package com.example.demo_mongodb_springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "v1/user", method = RequestMethod.POST)
    public ResponseEntity<UserData> postUserDataMongoDatabase (@RequestBody UserData userData){

        UserData userData1 = new UserData();
        userData1.setUserFirstName(userData.getUserFirstName());
        userData1.setUserLastName(userData.getUserLastName());
        userData1.setUserDob(userData.getUserDob());
        userData1.setUserId(userData.getUserId());
        userData1.setUserAddress(userData.getUserAddress());
        userData1.setUserCity(userData.getUserCity());
        userData1.setUserState(userData.getUserState());
        userData1.setUserZip(userData.getUserZip());

        this.userRepository.save(userData1);

        return new ResponseEntity<>(userData1, HttpStatus.OK);


    }




}
