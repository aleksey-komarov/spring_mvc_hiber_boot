package ru.komarov.springmvchiber.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.komarov.springmvchiber.model.User;
import ru.komarov.springmvchiber.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users/index";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {

        return "users/new";
    }

    @PostMapping("/save")
    public String createUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "users/edit";
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam("id") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "users/edit";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @RequestParam("id") long id) {
        if (bindingResult.hasErrors()) return "users/edit";
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
