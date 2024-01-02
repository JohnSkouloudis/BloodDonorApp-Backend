package gr.hua.dit.ds.BloodDonorApp.controller;

import gr.hua.dit.ds.BloodDonorApp.entity.Application;
import gr.hua.dit.ds.BloodDonorApp.entity.BloodTest;
import gr.hua.dit.ds.BloodDonorApp.service.ApplicationService;
import gr.hua.dit.ds.BloodDonorApp.service.BloodTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("application")
public class ApplicationController {
    private ApplicationService applicationService;
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
    public ResponseEntity<Application> saveApplication(@RequestBody Application application){
        Application savedApplication = applicationService.saveApplication(application);
        return ResponseEntity.ok(savedApplication);
    }

//    @PostMapping("/{applicationId}/approve")
//    public ResponseEntity<Application> approveApplication(@PathVariable Integer applicationId){
//        Application approvedApplication = applicationService.approveApplication(applicationId);
//        if (approvedApplication != null) {
//            return ResponseEntity.ok(approvedApplication);
//        }else{
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PostMapping("/{applicationId}/reject")
//    public ResponseEntity<Application> rejectApplication(@PathVariable Integer applicationId) {
//        Application rejectedApplication = applicationService.rejectApplication(applicationId);
//        if (rejectedApplication != null) {
//            return ResponseEntity.ok(rejectedApplication);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @GetMapping("/bloodtest/all")
    @ResponseBody
    public List<BloodTest> getBloodTests(){
        List<BloodTest> bloodTests = bloodTestService.getBloodTests();
        return bloodTests;

    }

    @GetMapping("/bloodtest/{bloodTestId}")
    @ResponseBody
    public BloodTest getBloodTest(@PathVariable Integer bloodTestId){
        BloodTest bloodTest = bloodTestService.getBloodTest(bloodTestId);
        return bloodTest;
    }

    @DeleteMapping("/bloodtest/{bloodTestId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteBloodTest(@PathVariable Integer bloodTestId){
        bloodTestService.deleteBloodTest(bloodTestId);
        return ResponseEntity.ok("BloodTest with ID " + bloodTestId + " deleted successfully.");
    }

    @PostMapping("/bloodtest/new")
    public ResponseEntity<BloodTest> saveBloodTest(@RequestBody BloodTest bloodTest){
        BloodTest savedBloodTest = bloodTestService.saveBloodTest(bloodTest);
        return ResponseEntity.ok(savedBloodTest);
    }

}
