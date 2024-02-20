package gr.hua.dit.ds.BloodDonorApp.controller;

import gr.hua.dit.ds.BloodDonorApp.entity.Application;
import gr.hua.dit.ds.BloodDonorApp.entity.Notification;
import gr.hua.dit.ds.BloodDonorApp.entity.User;
import gr.hua.dit.ds.BloodDonorApp.payload.request.UpdatePersonalInfoRequest;
import gr.hua.dit.ds.BloodDonorApp.repository.ApplicationRepository;
import gr.hua.dit.ds.BloodDonorApp.repository.UserRepository;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@Hidden
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
    public void deleteUser(@PathVariable Integer userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Optional<Application> applicationOptional = applicationRepository.findByUser(user);

            if (applicationOptional.isPresent()) {
                Application application = applicationOptional.get();
                Integer appId = application.getId();

                applicationRepository.deleteById(appId);
            }
            userRepository.deleteById(userId);
        }
    }


    @PatchMapping("/edit/{userId}")
    public void updatePersonalInfo(@PathVariable Integer userId, @RequestBody UpdatePersonalInfoRequest update){
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            if (update.getUsername() != null && !update.getUsername().isEmpty()) {
                user.setUsername(update.getUsername());
            }

            if (update.getEmail() != null && !update.getEmail().isEmpty()) {
                user.setEmail(update.getEmail());
            }

            if (update.getUsername() != null && !update.getPhoneNumber().isEmpty()) {
                user.setPhoneNumber(update.getPhoneNumber());
            }

            userRepository.save(user);
        }
    }

}
