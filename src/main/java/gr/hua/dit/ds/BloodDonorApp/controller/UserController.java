package gr.hua.dit.ds.BloodDonorApp.controller;

import gr.hua.dit.ds.BloodDonorApp.entity.User;
import gr.hua.dit.ds.BloodDonorApp.payload.response.ApiResponse;
import gr.hua.dit.ds.BloodDonorApp.repository.RoleRepository;
import gr.hua.dit.ds.BloodDonorApp.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private RoleRepository roleRepository;;

    @GetMapping("/register")
    @ResponseBody
    public User register(){
        User user = new User();
        return user;
    }

    @PostMapping("/saveUser")
    public ApiResponse saveUser(@RequestBody User user){
        Integer id = userDetailsServiceImpl.saveUser(user);
        String message = "User '"+id+"' saved successfully !";
        return new ApiResponse(true,message);
    }




}
