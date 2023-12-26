package gr.hua.dit.ds.BloodDonorApp.service;

import gr.hua.dit.ds.BloodDonorApp.entity.Application;
import gr.hua.dit.ds.BloodDonorApp.entity.User;
import gr.hua.dit.ds.BloodDonorApp.repository.ApplicationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository ApplicationRepository;

    @Transactional
    public List<Application> getApplications(){
        return ApplicationRepository.findAll();
    }

    @Transactional
    public Application getApplication(Integer applicationId){
        return ApplicationRepository.findById(applicationId).get();
    }

    @Transactional
    public Application findApplicationByUser(User user) {
        return ApplicationRepository.findByUser(user).get();
    }

    @Transactional
    public void saveApplication(Application application){
        ApplicationRepository.save(application);

    }

    @Transactional
    public void deleteApplication(Integer applicationId){
        ApplicationRepository.deleteById(applicationId);
    }


}
