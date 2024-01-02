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
    public Application saveApplication(Application application){
         return ApplicationRepository.save(application);

    }

    @Transactional
    public void deleteApplication(Integer applicationId){
        ApplicationRepository.deleteById(applicationId);
    }

    @Transactional
    public Application approveApplication(Integer applicationId){
        Application application= ApplicationRepository.findById(applicationId).get();
        application.setApproved(true);
        ApplicationRepository.save(application);
        return application;
    }

    @Transactional
    public Application rejectApplication(Integer applicationId){
        Application application= ApplicationRepository.findById(applicationId).get();
        application.setApproved(false);
        ApplicationRepository.save(application);
        return application;
    }


}
