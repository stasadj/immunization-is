package com.immunization.common.dao;

import java.util.ArrayList;
import java.util.List;

import com.immunization.common.model.User;
import com.immunization.common.repository.Exist;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserDAO {
    private final Exist exist;

    public void save(User user) {
        try {
            exist.save(user.getUsername(), user);
        } catch (Exception e) {
        }
    }

    public List<User> getByUsername(String username) {
        return search("username", username);
    }

    public List<User> getByEmail(String email) {
        return search("email", email);
    }

    private List<User> search(String tagName, String tagValue) {
        List<User> list = new ArrayList<>();
        try {
            exist.query(String.format("//user[%s=\"%s\"]", tagName, tagValue), User.class)
                    .forEach(item -> list.add((User) item));
        } catch (Exception e) {
        }
        return list;
    }
}
