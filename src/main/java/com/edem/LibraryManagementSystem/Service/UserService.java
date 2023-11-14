package com.edem.LibraryManagementSystem.Service;

import com.edem.LibraryManagementSystem.entity.User;

public interface UserService {
     User createUser(String email, String password);
     void deleteUser(Long id);
}
