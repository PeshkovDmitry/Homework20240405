package ru.gb.homework20240405.repository;

import org.springframework.stereotype.Repository;
import ru.gb.homework20240405.domain.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
