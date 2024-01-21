package gr.hua.dit.ds.BloodDonorApp.service;

import gr.hua.dit.ds.BloodDonorApp.entity.BloodTest;
import gr.hua.dit.ds.BloodDonorApp.repository.BloodTestRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodTestService {

    @Autowired
    private BloodTestRepository bloodTestRepository;
    @Transactional
    public BloodTest saveBloodTest(BloodTest bloodTest){
        bloodTestRepository.save(bloodTest);
        return bloodTest;
    }

    @Transactional
    public void deleteBloodTest(Integer bloodTestId){
        bloodTestRepository.deleteById(bloodTestId);
    }

    @Transactional
    public List<BloodTest> getBloodTests(){
        return bloodTestRepository.findAll();
    }
    @Transactional
    public BloodTest getBloodTest(Integer bloodTestId){
        return bloodTestRepository.findById(bloodTestId).get();
    }

}