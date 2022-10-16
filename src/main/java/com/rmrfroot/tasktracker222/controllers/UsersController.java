package com.rmrfroot.tasktracker222.controllers;

import com.rmrfroot.tasktracker222.entities.UserEditRequest;
import com.rmrfroot.tasktracker222.entities.Users;
import com.rmrfroot.tasktracker222.services.UsersDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;


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
        List<Users> allUsers = usersDaoService.findAll();
        List<Users> usersToAdd = new ArrayList<>();

        for (Users u : allUsers) {
//            System.out.println(u.getEmail());
            if (u.getId() >= 41 || u.getId() == 42) {
                usersToAdd.add(u);
            }
        }

        model.addAttribute("users", usersToAdd);
        model.addAttribute("userEditRequest", new UserEditRequest());
        return "UserManagement";
    }

    @PostMapping(value = "/users", params = "submit")
    public RedirectView userEditSubmit(@ModelAttribute("userEditRequest") UserEditRequest request) {
        System.out.println(request.getFirst_name());


        return new RedirectView("users");
    }

    @PostMapping(value = "/users", params = "delete")
    public RedirectView userEditDelete(Model model) {
        System.out.println("delete");

        //TODO - Add functionality to delete user from database and cognito

        return new RedirectView("users");
    }


    @GetMapping("/users/{id}")
    public String findById(@PathVariable("id") int id, Model model) {
        model.addAttribute("users", usersDaoService.findById(id));
        return "users";
    }

    /**
     * Skeleton Code for controller access after user login
     * depending on the role of user (officer or not)
     * <p>
     * With having no way of differentiating user from another
     * can't be used
     */
    @GetMapping("users/accessControl")
    public String accessControl(Model model) {
        Users user = new Users();
        model.addAttribute("users", user);
        // if user is admin
        //    return "redirect:/drill-schedule-manager";
        // if not
        return "redirect:/drill-schedule-recipient";
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
