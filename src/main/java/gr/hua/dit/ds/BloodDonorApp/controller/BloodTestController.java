package gr.hua.dit.ds.BloodDonorApp.controller;

import gr.hua.dit.ds.BloodDonorApp.entity.Application;
import gr.hua.dit.ds.BloodDonorApp.entity.BloodTest;
import gr.hua.dit.ds.BloodDonorApp.service.BloodTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bloodtest")
public class BloodTestController {

    private BloodTestService bloodTestService;

    @Autowired
    public BloodTestController(BloodTestService bloodTestService){
        this.bloodTestService = bloodTestService;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<BloodTest> getBloodTests(){
        List<BloodTest> bloodTests = bloodTestService.getBloodTests();
        return bloodTests;

    }

    @GetMapping("/{bloodTestId}")
    @ResponseBody
    public BloodTest getBloodTest(@PathVariable Integer bloodTestId){
        BloodTest bloodTest = bloodTestService.getBloodTest(bloodTestId);
        return bloodTest;
    }

    @DeleteMapping("/{bloodTestId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteBloodTest(@PathVariable Integer bloodTestId){
        bloodTestService.deleteBloodTest(bloodTestId);
        return ResponseEntity.ok("BloodTest with ID " + bloodTestId + " deleted successfully.");
    }

    @PostMapping("/new")
    public ResponseEntity<BloodTest> saveBloodTest(@RequestBody BloodTest bloodTest){
        BloodTest savedBloodTest = bloodTestService.saveBloodTest(bloodTest);
        return ResponseEntity.ok(savedBloodTest);
    }


}
