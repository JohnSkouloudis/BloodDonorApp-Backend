package gr.hua.dit.ds.BloodDonorApp.controller;

import gr.hua.dit.ds.BloodDonorApp.entity.Application;
import gr.hua.dit.ds.BloodDonorApp.entity.Hospital;
import gr.hua.dit.ds.BloodDonorApp.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hospital")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @PostMapping("/new")
    public void saveHospital(@RequestBody Hospital hospital){
        hospitalService.saveHospital(hospital);
    }

    @DeleteMapping("/{hospitalId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteHospital(@PathVariable Integer hospitalId){
        hospitalService.deleteHospital(hospitalId);
        return ResponseEntity.ok("Hospital with ID " + hospitalId + " deleted successfully.");
    }

    @GetMapping("/{hospitalId}")
    @ResponseBody
    public Hospital getHospital(@PathVariable Integer hospitalId){
        Hospital hospital = hospitalService.getHospital(hospitalId);
        return hospital;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Hospital> getHospitals(){
        List<Hospital> hospitals = hospitalService.getHospitals();
        return hospitals;
    }
}
