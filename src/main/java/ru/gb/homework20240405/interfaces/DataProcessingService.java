package ru.gb.homework20240405.interfaces;

import ru.gb.homework20240405.domain.User;
import ru.gb.homework20240405.repository.UserRepository;

import java.util.List;

public interface DataProcessingService {

    List<User> getAll();

    void addUserToList(User user);

    List<User> sortUsersByAge();

    List<User> filterUsersByAge(int age);

    double calculateAverageAge();
}
