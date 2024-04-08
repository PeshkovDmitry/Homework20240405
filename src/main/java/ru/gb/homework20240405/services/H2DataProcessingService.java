package ru.gb.homework20240405.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.gb.homework20240405.domain.User;
import ru.gb.homework20240405.interfaces.DataProcessingService;
import ru.gb.homework20240405.repository.H2UserRepository;

import java.util.List;

@Service
@Primary
public class H2DataProcessingService implements DataProcessingService {

    @Autowired
    private H2UserRepository repository;

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public void addUserToList(User user) {
        repository.addUserToList(user);
    }

    @Override
    public List<User> sortUsersByAge() {
        return repository.sortUsersByAge();
    }

    @Override
    public List<User> filterUsersByAge(int age) {
        return repository.filterUsersByAge(age);
    }

    @Override
    public double calculateAverageAge() {
        return repository.calculateAverageAge();
    }

}
