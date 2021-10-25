package com.blog.controller.user;

import com.blog.model.user.User;
import com.blog.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(){
        return "Welcome";
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody User user){
        userService.saveUser(user);
        System.out.println(user);
        return ResponseEntity.ok("User created Successfully");
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<?> getUser(@PathVariable String username){
        return ResponseEntity.ok(userService.findByUserName(username));
    }

    @PutMapping("/users")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        User updatedUser = userService.updateUser(user);
        if(updatedUser==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User doesn't exist");
        return ResponseEntity.ok("Updated Successfully");
    }

    @DeleteMapping("/users/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username){
        if(userService.deleteUser(username)){
            return ResponseEntity.ok("Deleted Successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User doesn't exist");
    }
}
