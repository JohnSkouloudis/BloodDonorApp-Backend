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
@Hidden
public class ApplicationRestController {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BloodTestService bloodTestService;



    @GetMapping("/all")
    @ResponseBody
    public List<Application> getApplications() {
        List<Application> applications = applicationService.getApplications();
        return applications;
    }

    @GetMapping("/{applicationId}")
    @ResponseBody
    public Application getApplication(@PathVariable Integer applicationId){
        Application application = applicationService.getApplication(applicationId);
        return application;
    }

    @DeleteMapping("/{applicationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteApplication(@PathVariable Integer applicationId){
        applicationService.deleteApplication(applicationId);
        return ResponseEntity.ok("Application with ID " + applicationId + " deleted successfully.");
    }

    @PostMapping("/new")
    public Application saveApplication(@RequestBody Application application, @RequestBody BloodTest bloodtest,@RequestBody User user){
        bloodTestService.saveBloodTest(bloodtest);
        application.setUser(user);
        application.setBloodTest(bloodtest);
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