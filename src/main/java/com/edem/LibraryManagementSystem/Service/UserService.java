package com.edem.LibraryManagementSystem.Service;

import com.edem.LibraryManagementSystem.entity.User;

public interface UserService {
    User createUser(User user);

     void deleteUser(Long id);
}
