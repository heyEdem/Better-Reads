package com.edem.LibraryManagementSystem.Runner;


import com.edem.LibraryManagementSystem.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
    private final UserServiceImpl userService;

    @Override
    public void run(String... args) throws Exception {
        User user1 = userService.createUser("user1@gmail.com","pass1");
        User user2 = userService.createUser("user2@gmail.com","pass2");

    }
}
