package gr.hua.dit.ds.BloodDonorApp.controller;

import gr.hua.dit.ds.BloodDonorApp.entity.Application;
import gr.hua.dit.ds.BloodDonorApp.entity.Notification;
import gr.hua.dit.ds.BloodDonorApp.entity.User;
import gr.hua.dit.ds.BloodDonorApp.repository.ApplicationRepository;
import gr.hua.dit.ds.BloodDonorApp.repository.UserRepository;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

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

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable Integer userId){
        User user = userRepository.findById(userId).get();
        Application application = applicationRepository.findByUser(user).get();
        Integer appId = application.getId();

        applicationRepository.deleteById(appId);

        userRepository.deleteById(userId);
    }
}