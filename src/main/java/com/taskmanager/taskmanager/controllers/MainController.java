package com.taskmanager.taskmanager.controllers;


import com.taskmanager.taskmanager.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.taskmanager.taskmanager.model.User;

@Controller
public class MainController {
    private final UserService userService;


    public MainController(UserService userService) {

        this.userService = userService;
    }
    @GetMapping(value = "/")
    public String getIndex(ModelMap model) {
        model.addAttribute("users", userService.getAllUser());
        return "index";
    }

    @GetMapping(value = "/add")
    public String addForm(ModelMap model) {
        model.addAttribute("users", new User());
        return "add";
    }

    @PostMapping(value = "/add")
    public String addSumbit(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String editPage(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("user", userService.getById(id));
        return "edit";
    }

    @PatchMapping(value = "/edit")
    public String editSubmit(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

}
