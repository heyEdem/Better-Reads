package com.edem.LibraryManagementSystem.Service.impl;

import com.edem.LibraryManagementSystem.Service.UserService;
import com.edem.LibraryManagementSystem.entity.User;
import com.edem.LibraryManagementSystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    @Override
    public User createUser(String email,  String password) {
        return repository.save( new User(email, password));
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> user = repository.findById(id);
        repository.delete(user.get());
    }


}
