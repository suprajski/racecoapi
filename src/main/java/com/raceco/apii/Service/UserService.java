package com.raceco.apii.Service;

import com.raceco.apii.Entity.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    User getUserById(Long userId);
    User getUserByEmail(String email);
    List<User> getUsersByRole(String roleName);
    void deleteUser(Long userId);
}
