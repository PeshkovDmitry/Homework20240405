package ru.gb.homework20240405.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.homework20240405.domain.User;
import ru.gb.homework20240405.interfaces.DataProcessingService;

import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    private DataProcessingService dataProcessingService;

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    public List<User> getAllUsers() {
        return dataProcessingService.getAll();
    }

    public void processRegistration(User user) {
        dataProcessingService.addUserToList(user);
        notificationService.notifyUser(user);
    }

    public void processRegistration(String name, int age, String email) {
        processRegistration(
                userService.createUser(name, age, email)
        );
    }
}
