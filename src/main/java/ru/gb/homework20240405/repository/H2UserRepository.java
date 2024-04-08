package ru.gb.homework20240405.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.gb.homework20240405.domain.User;

import java.util.List;

@Repository
public class H2UserRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public List<User> getAll() {
        String sql = "SELECT * FROM userTable";
        return jdbc.query(sql, getMapper());
    }

    public void addUserToList(User user) {
        String sql = "INSERT INTO userTable (name, age, email) VALUES (?, ?, ?)";
        jdbc.update(sql, user.getName(), user.getAge(), user.getEmail());
    }

    public List<User> sortUsersByAge() {
        String sql = "SELECT * FROM userTable ORDER BY age";
        return jdbc.query(sql, getMapper());
    }

    public List<User> filterUsersByAge(int age) {
        String sql = "SELECT * FROM userTable WHERE age > ?";
        return jdbc.query(sql, getMapper(), age);
    }

    public double calculateAverageAge() {
        return getAll().stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    private RowMapper<User> getMapper() {
        return (r, i) -> {
            User rowObject = new User();
            rowObject.setAge(r.getInt("age"));
            rowObject.setName(r.getString("name"));
            rowObject.setEmail(r.getString("email"));
            return rowObject;
        };
    }
}
