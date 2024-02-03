package gr.hua.dit.ds.BloodDonorApp.repository;

import gr.hua.dit.ds.BloodDonorApp.entity.Application;
import gr.hua.dit.ds.BloodDonorApp.entity.User;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path= "application")
public interface ApplicationRepository extends JpaRepository<Application,Integer> {

    Optional<Application> findByUser(User user);
    Optional<Application> findByUserId(Integer userId);
}
