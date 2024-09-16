package com.sptech.Quiz_app_mono.service;

import com.sptech.Quiz_app_mono.Repository.UserRepo;
import com.sptech.Quiz_app_mono.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    @Autowired
    private UserRepo repo;
    BCryptPasswordEncoder encoder =new BCryptPasswordEncoder(12);

    public User registrationServ(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
        return repo.save(user);
    }
}
