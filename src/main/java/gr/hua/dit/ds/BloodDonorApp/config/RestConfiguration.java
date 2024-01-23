package gr.hua.dit.ds.BloodDonorApp.config;

import gr.hua.dit.ds.BloodDonorApp.entity.Hospital;
import gr.hua.dit.ds.BloodDonorApp.entity.Notification;
import gr.hua.dit.ds.BloodDonorApp.entity.User;
import gr.hua.dit.ds.BloodDonorApp.entity.Application;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(
            RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Hospital.class);
        config.exposeIdsFor(User.class);
        config.exposeIdsFor(Application.class);
        config.exposeIdsFor(Notification.class);
    }
}
