package com.immunization.common.dao;

import com.immunization.common.model.User;
import com.immunization.common.repository.Exist;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UserDAO {
    private final Exist exist;

    public void save(User user) throws Exception {
        exist.save(user.getUsername(), user);
    }

    public List<User> getByUsername(String username) throws Exception {
        return search("username", username);
    }

    public List<User> getByEmail(String email) throws Exception {
        return search("email", email);
    }

    private List<User> search(String tagName, String tagValue) throws Exception {
        return exist.query(String.format("//user[%s=\"%s\"]", tagName, tagValue), User.class)
                    .stream().map(o -> (User) o).collect(Collectors.toList());
    }
}
