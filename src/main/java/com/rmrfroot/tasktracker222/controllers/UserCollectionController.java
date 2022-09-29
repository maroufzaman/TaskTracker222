package com.rmrfroot.tasktracker222.controllers;

import com.rmrfroot.tasktracker222.entities.Users;
import com.rmrfroot.tasktracker222.services.DaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userCollection")
public class UserCollectionController {

    @Autowired
    private DaoService userDaoService;

    public UserCollectionController(DaoService userDaoService) {
        super();
        this.userDaoService = userDaoService;
    }

    public String main(Model model) {
        List<Users> userList = userDaoService.findAll();

        model.addAttribute("users", userList);
        return "userCollection";
    }
}
