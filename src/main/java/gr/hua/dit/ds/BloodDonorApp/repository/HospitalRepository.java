package gr.hua.dit.ds.BloodDonorApp.repository;

import gr.hua.dit.ds.BloodDonorApp.entity.Hospital;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RepositoryRestResource(path= "hospital")
public interface HospitalRepository extends JpaRepository<Hospital,Integer> {

    Optional<Hospital> findByName(String name);
}
