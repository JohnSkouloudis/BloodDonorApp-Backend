package gr.hua.dit.ds.BloodDonorApp.service;

import gr.hua.dit.ds.BloodDonorApp.entity.Notification;
import gr.hua.dit.ds.BloodDonorApp.entity.User;
import gr.hua.dit.ds.BloodDonorApp.repository.NotificationRepository;
import gr.hua.dit.ds.BloodDonorApp.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Notification saveNotification(Notification notification,Integer userId){
        User user= userRepository.findById(userId).get();
        notification.setUser(user);
        return notificationRepository.save(notification);
    }

    @Transactional
    public void deleteNotification(Integer notificationId){
        notificationRepository.deleteById(notificationId);
    }

    @Transactional
    public List<Notification> getNotifications(){
        return notificationRepository.findAll();
    }

    @Transactional
    public List<Notification> getUserNotifications(Integer userId){
        User user = userRepository.findById(userId).get();
        return user.getNotifications();
    }


}