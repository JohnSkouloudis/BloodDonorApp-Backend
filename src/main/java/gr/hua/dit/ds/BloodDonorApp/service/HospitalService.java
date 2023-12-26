package gr.hua.dit.ds.BloodDonorApp.service;

import gr.hua.dit.ds.BloodDonorApp.entity.Hospital;
import gr.hua.dit.ds.BloodDonorApp.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;


import java.util.List;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Transactional
    public void saveHospital(Hospital hospital){
        hospitalRepository.save(hospital);
    }

    @Transactional
    public void deleteHospital(Integer hospitalId){
        hospitalRepository.deleteById(hospitalId);
    }

    @Transactional
    public List<Hospital> getHospitals(){
        return hospitalRepository.findAll();
    }

    @Transactional
    public Hospital getHospital(Integer hospitalId){
        return  hospitalRepository.findById(hospitalId).get();
    }

}
