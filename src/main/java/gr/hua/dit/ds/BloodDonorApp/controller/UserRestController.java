package gr.hua.dit.ds.BloodDonorApp.controller;

import gr.hua.dit.ds.BloodDonorApp.entity.Application;
import gr.hua.dit.ds.BloodDonorApp.entity.Notification;
import gr.hua.dit.ds.BloodDonorApp.entity.User;
import gr.hua.dit.ds.BloodDonorApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable Integer userId){

        return userRepository.findById(userId).get();
    }

    @GetMapping("/all")
    public List<User> getUsers(){

        return  userRepository.findAll();
    }

    @PostMapping("/new")
    public  User saveUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable Integer userId){
        userRepository.deleteById(userId);
    }
}