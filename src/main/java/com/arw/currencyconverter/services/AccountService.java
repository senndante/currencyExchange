package com.arw.currencyconverter.services;

import com.arw.currencyconverter.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.arw.currencyconverter.entities.Person;
import com.arw.currencyconverter.repositories.PersonRepository;

@Service
public class AccountService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Person save(UserRegistrationDto registrationDto) {
        if (registrationDto.getPassword().equals(registrationDto.getConfirmPassword())) {
            Person user = new Person();
            user.setEmail(registrationDto.getEmail());
            user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
            return personRepository.saveAndFlush(user);
        }
        return null;
    }

    public Person findByEmail(String email) {
        return personRepository.findByEmail(email);
    }

    public Person getCurrentUser(){
        return personRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
