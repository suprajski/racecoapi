package com.raceco.apii.Service;

import com.raceco.apii.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> signIn(String email, String password);
    User addUser(User user);
    User getUserById(Long userId);
    User getUserByEmail(String email);
    List<User> getUsersByRole(String roleName);
    List<User> getEmployees();
    void deleteUser(Long userId);
}
