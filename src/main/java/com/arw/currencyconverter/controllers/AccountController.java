package com.arw.currencyconverter.controllers;

import com.arw.currencyconverter.dto.UserRegistrationDto;
import com.arw.currencyconverter.entities.Person;
import com.arw.currencyconverter.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        return "login";
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto, BindingResult result) {
        Person existing = accountService.findByEmail(userDto.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "Account with this email already registered!");
        }
        if (result.hasErrors()) {
            return "registration";
        }

        accountService.save(userDto);
        return "redirect:/";
    }
}
