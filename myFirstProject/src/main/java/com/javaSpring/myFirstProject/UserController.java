
package com.javaSpring.myFirstProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/delete/{name}")
    public String deleteUser(@PathVariable String name) {
        userRepository.deleteByName(name);
        return "User deleted successfully";
    }

    @PutMapping("/update/{email}")
    public String updateUser(@PathVariable String email, @RequestBody User updatedUser) {
        Optional<User> existingUser = userRepository.findByEmail(email);

        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());

            userRepository.save(user);
            return "User updated successfully";
        }
        return "User not found";
    }

    @GetMapping("/getUsers")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
