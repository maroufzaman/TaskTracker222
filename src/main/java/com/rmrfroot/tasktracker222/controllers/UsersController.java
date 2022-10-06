package com.rmrfroot.tasktracker222.controllers;

import com.rmrfroot.tasktracker222.entities.Users;
import com.rmrfroot.tasktracker222.services.UsersDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UsersController {

    @Autowired
    private UsersDaoService usersDaoService;

    public UsersController(UsersDaoService usersDaoService) {
        super();
        this.usersDaoService = usersDaoService;
    }



    @GetMapping("/users")
    public String getUsersCollection(Model model) {
        model.addAttribute("users", usersDaoService.findAll());
        return "users";
    }

    @GetMapping("/users/{id}")
    public String findById(@PathVariable("id") int id, Model model) {
        model.addAttribute("users", usersDaoService.findById(id));
        return "users";
    }

    @GetMapping("/users/addUser")
    public String addUser(Model model) {
        Users user = new Users();
        model.addAttribute("users");
        return "users";

    }
    @PostMapping("/addUser")
        public String save(@ModelAttribute("users") Users users) {
            usersDaoService.save(users);
            return "redirect:/users";
        }

    @PutMapping("users/{id}")
    public ResponseEntity<Users> update(@PathVariable("id") int id, Users users) {

        return new ResponseEntity<>(usersDaoService.update(id, users), HttpStatus.OK);
    }

    @DeleteMapping("users/{id}")
    public void deleteById(@PathVariable("id") int id) {
        usersDaoService.deleteById(id);
    }
}
