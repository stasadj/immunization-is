package com.immunization.common.service;

import java.util.List;

import com.immunization.common.dao.UserDAO;
import com.immunization.common.model.User;

import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserDAO userDao;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> matches = userDao.getByUsername(username);
        User user = matches.size() > 0 ? matches.get(0) : null;
        if (user == null) {
            // Obfuscated message for security reasons
            throw new UsernameNotFoundException("Invalid credentials");
        }
        return user;
    }
    
}
