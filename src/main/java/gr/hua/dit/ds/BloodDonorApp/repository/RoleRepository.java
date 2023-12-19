package gr.hua.dit.ds.BloodDonorApp.repository;


import gr.hua.dit.ds.BloodDonorApp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

    Optional<Role> findByName(String roleName);

}
