package gr.hua.dit.ds.BloodDonorApp.controller;

import gr.hua.dit.ds.BloodDonorApp.entity.Application;
import gr.hua.dit.ds.BloodDonorApp.entity.BloodTest;
import gr.hua.dit.ds.BloodDonorApp.entity.User;
import gr.hua.dit.ds.BloodDonorApp.repository.UserRepository;
import gr.hua.dit.ds.BloodDonorApp.service.ApplicationService;
import gr.hua.dit.ds.BloodDonorApp.service.BloodTestService;
import gr.hua.dit.ds.BloodDonorApp.repository.ApplicationRepository;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/application")

public class ApplicationRestController {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private BloodTestService bloodTestService;

    @Autowired
    private UserRepository userRepository;



    @GetMapping("/all")
    @ResponseBody
    public List<Application> getApplications() {
        List<Application> applications = applicationService.getApplications();
        return applications;
    }

    @DeleteMapping("/delete/{applicationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteApplication(@PathVariable Integer applicationId){
        applicationService.deleteApplication(applicationId);
        return ResponseEntity.ok("Application with ID " + applicationId + " deleted successfully.");
    }


    @PostMapping("/new/{userId}")
    public Application saveApplication(@RequestBody Application application,@PathVariable Integer userId){
        User user = userRepository.findById(userId).get();
        application.setUser(user);
        return applicationService.saveApplication(application);


    }

    @PostMapping("/approve/{applicationId}")
    public ResponseEntity<Application> approveApplication(@PathVariable Integer applicationId){
        Application approvedApplication = applicationService.approveApplication(applicationId);
        if (approvedApplication != null) {
            return ResponseEntity.ok(approvedApplication);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/reject/{applicationId}")
    public ResponseEntity<Application> rejectApplication(@PathVariable Integer applicationId) {
        Application rejectedApplication = applicationService.rejectApplication(applicationId);
        if (rejectedApplication != null) {
            return ResponseEntity.ok    (rejectedApplication);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{applicationId}")
    public Application getUserApplication(@PathVariable Integer applicationId){

        return  applicationRepository.findById(applicationId).get();

    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<Application> findByUser(@PathVariable Integer userId) {
        Optional<Application> application = applicationRepository.findByUserId(userId);

        return application.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }



}