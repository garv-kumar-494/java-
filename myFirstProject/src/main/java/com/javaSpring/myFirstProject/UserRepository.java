
package com.javaSpring.myFirstProject;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String>{
    void deleteByName(String name);
    Optional<User> findByEmail(String email);
}

