package com.example.springsecurityandhibernate.controllers;

import com.example.springsecurityandhibernate.dto.UserRegistrationDto;
import com.example.springsecurityandhibernate.model.User;
import com.example.springsecurityandhibernate.repository.UserService;
import com.example.springsecurityandhibernate.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("user") UserRegistrationDto user) {
        return "users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") UserRegistrationDto user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.findById(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.update(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
