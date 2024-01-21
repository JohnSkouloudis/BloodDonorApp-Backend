package gr.hua.dit.ds.BloodDonorApp.service;

import com.github.javafaker.Faker;
import gr.hua.dit.ds.BloodDonorApp.entity.Application;
import gr.hua.dit.ds.BloodDonorApp.entity.BloodTest;
import gr.hua.dit.ds.BloodDonorApp.entity.Notification;
import gr.hua.dit.ds.BloodDonorApp.entity.Role;
import gr.hua.dit.ds.BloodDonorApp.entity.Hospital;
import gr.hua.dit.ds.BloodDonorApp.entity.User;
import gr.hua.dit.ds.BloodDonorApp.repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Service
public class InitialDataService {


    private static final int LAST_HOSPITAL_ID = 10;
    private static final int LAST_NOTIFICATION_ID= 4;


    private final UserRepository userRepository;

    private final RoleRepository roleRepository;
    private final HospitalRepository hospitalRepository;
    private final ApplicationRepository applicationRepository;
    private final BloodTestRepository bloodTestRepository;

    private final NotificationRepository notificationRepository;
    private final PasswordEncoder passwordEncoder;

    public InitialDataService(UserRepository userRepository,
                              RoleRepository roleRepository,
                              HospitalRepository hospitalRepository,
                              ApplicationRepository applicationRepository,
                              BloodTestRepository bloodTestRepository,
                              NotificationRepository notificationRepository,
                              PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.hospitalRepository = hospitalRepository;
        this.applicationRepository = applicationRepository;
        this.bloodTestRepository = bloodTestRepository;
        this.notificationRepository = notificationRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private void createUsersAndRoles() {
        final List<String> rolesToCreate = List.of("ROLE_ADMIN", "ROLE_DONOR", "ROLE_USER","ROLE_SECRETARY");
        for (final String roleName : rolesToCreate) {
            roleRepository.findByName(roleName).orElseGet(() -> {
                roleRepository.save(new Role(roleName));
                return null;
            });
        }

        this.userRepository.findByUsername("user").orElseGet(() -> {
            User user = new User("user", "user@hua.gr", this.passwordEncoder.encode("1234"));
            Set<Role> roles = new HashSet<>();
            roles.add(this.roleRepository.findByName("ROLE_USER").orElseThrow());
            roles.add(this.roleRepository.findByName("ROLE_ADMIN").orElseThrow());
            roles.add(this.roleRepository.findByName("ROLE_DONOR").orElseThrow());
            user.setRoles(roles);
            userRepository.save(user);
            return null;
        });
        this.userRepository.findByUsername("secretary").orElseGet(() -> {
            User user = new User("secretary", "secretary@hua.gr", this.passwordEncoder.encode("1234"));
            Set<Role> roles = new HashSet<>();
            roles.add(this.roleRepository.findByName("ROLE_USER").orElseThrow());
            roles.add(this.roleRepository.findByName("ROLE_SECRETARY").orElseThrow());
            user.setRoles(roles);
            userRepository.save(user);
            return null;
        });
        this.userRepository.findByUsername("admin").orElseGet(() -> {
            User user = new User("admin", "admin@hua.gr", this.passwordEncoder.encode("1234"));
            Set<Role> roles = new HashSet<>();
            roles.add(this.roleRepository.findByName("ROLE_USER").orElseThrow());
            roles.add(this.roleRepository.findByName("ROLE_SECRETARY").orElseThrow());
            roles.add(this.roleRepository.findByName("ROLE_ADMIN").orElseThrow());
            user.setRoles(roles);
            userRepository.save(user);
            return null;
        });
    }

    private void createHospitals() {
        for (int i=1; i<=LAST_HOSPITAL_ID; i++) {
            final String name = "Course " + i;

            this.hospitalRepository.findByName(name).orElseGet(() -> {
                Hospital hospital = new Hospital();
                hospital.setName(name);
                this.hospitalRepository.save(hospital);
                return null;
            });
        }
    }



    private void createApplications(){
        BloodTest bloodTest= new BloodTest(1,
                2,
                3,
                4,
                5,
                6,
                "1/1/2023",
                "AgiosDimitrios");
        this.bloodTestRepository.save(bloodTest);

        this.applicationRepository.findByUser(userRepository.findByUsername("user").get()).orElseGet(() -> {
            Application application = new Application(13,"John","Doe","O-","Kallithea");
            application.setApproved(false);
            application.setBloodTest(bloodTest);
            application.setUser(this.userRepository.findByUsername("user").get());

            return null;
        });




    }

    private void createNotifications(){
        User user = userRepository.findByUsername("user").get();
        for (int i=1; i<=LAST_NOTIFICATION_ID; i++){
            Notification notification = new Notification();
            notification.setType("emergency "+ i);
            notification.setHospitalName("hospital "+ i);
            this.notificationRepository.save(notification);
        }

    }


}
