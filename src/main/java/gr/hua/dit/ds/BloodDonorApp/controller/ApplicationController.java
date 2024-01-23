package gr.hua.dit.ds.BloodDonorApp.controller;

import gr.hua.dit.ds.BloodDonorApp.entity.Application;
import gr.hua.dit.ds.BloodDonorApp.entity.BloodTest;
import gr.hua.dit.ds.BloodDonorApp.entity.User;
import gr.hua.dit.ds.BloodDonorApp.repository.UserRepository;
import gr.hua.dit.ds.BloodDonorApp.service.ApplicationService;
import gr.hua.dit.ds.BloodDonorApp.service.BloodTestService;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/application")

public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private BloodTestService bloodTestService;

    @Autowired
    private UserRepository userRepository;









    @PostMapping("/new/{userId}")
    public Application saveApplication(@RequestBody Application application,@PathVariable Integer userId){
         User user = userRepository.findById(userId).get();
         application.setUser(user);
         return applicationService.saveApplication(application);


    }

    @PostMapping("/{applicationId}/approve")
    public ResponseEntity<Application> approveApplication(@PathVariable Integer applicationId){
        Application approvedApplication = applicationService.approveApplication(applicationId);
        if (approvedApplication != null) {
            return ResponseEntity.ok(approvedApplication);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{applicationId}/reject")
    public ResponseEntity<Application> rejectApplication(@PathVariable Integer applicationId) {
        Application rejectedApplication = applicationService.rejectApplication(applicationId);
        if (rejectedApplication != null) {
            return ResponseEntity.ok(rejectedApplication);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{username}")
    public Application getUserApplication(@PathVariable String username){

        User user = userRepository.findByUsername(username).get();

        return  applicationService.findApplicationByUser(user);

    }

}
