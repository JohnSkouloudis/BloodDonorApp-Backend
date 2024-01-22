package gr.hua.dit.ds.BloodDonorApp.controller;

import gr.hua.dit.ds.BloodDonorApp.entity.Notification;
import gr.hua.dit.ds.BloodDonorApp.repository.UserRepository;
import gr.hua.dit.ds.BloodDonorApp.service.NotificationService;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@Hidden
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/{userId}")
    public List<Notification> getUserNotifications(@PathVariable Integer userId){

        return notificationService.getUserNotifications(userId);
    }

    @DeleteMapping("/{notificationId}")
    public ResponseEntity<String> deleteNotification(@PathVariable  Integer notificationId){
        notificationService.deleteNotification(notificationId);
        return ResponseEntity.ok("Application with ID " + notificationId + " deleted successfully.");
    }

    @PostMapping("/new/{userId}")
    public Notification saveNotification(@RequestBody Notification notification,@PathVariable Integer userId){
        return notificationService.saveNotification(notification,userId);
    }

}
