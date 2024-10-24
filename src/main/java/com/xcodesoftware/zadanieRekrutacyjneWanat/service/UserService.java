package com.xcodesoftware.zadanieRekrutacyjneWanat.service;

import com.xcodesoftware.zadanieRekrutacyjneWanat.model.User;
import com.xcodesoftware.zadanieRekrutacyjneWanat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
   private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public User getUserByFirstAndSecondName(String firstName, String lastName)
    {
        return userRepository.findByFirstNameAndLastName(firstName,lastName);
    }
}
