package com.example.demo_mongodb_springboot;

import com.sun.org.apache.xpath.internal.objects.XNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserData, String> {

    public UserData findById ()








}
