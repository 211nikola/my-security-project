package com.example.mysecurityproject.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

import java.util.ArrayList;
import java.util.List;

public class AppUserDetailsManager implements UserDetailsManager {

    private List<UserDetails> users = new ArrayList<>();


    @Override
    public void createUser(UserDetails user) {
        users.add(user);
    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return users.stream().filter(u -> u.getUsername().equals(username))
                .findAny()
                .isPresent();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.stream().filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElseThrow(()-> new UsernameNotFoundException("not found :)"));
    }
}
