package ru.gb.homework20240405.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.homework20240405.domain.User;
import ru.gb.homework20240405.interfaces.DataProcessingService;
import ru.gb.homework20240405.repository.ListUserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListDataProcessingService implements DataProcessingService {

    @Autowired
    private ListUserRepository repository;

    @Override
    public List<User> getAll() {
        return repository.getUsers();
    }

    @Override
    public void  addUserToList(User user)
    {
        repository.getUsers().add(user);
    }

    @Override
    public List<User> sortUsersByAge() {
        return repository.getUsers().stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    @Override
    public List<User> filterUsersByAge(int age) {
        return repository.getUsers().stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    @Override
    public double calculateAverageAge() {
        return repository.getUsers().stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

}
