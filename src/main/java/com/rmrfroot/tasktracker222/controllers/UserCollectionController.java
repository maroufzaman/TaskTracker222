package com.rmrfroot.tasktracker222.controllers;

import com.rmrfroot.tasktracker222.entities.Users;
import com.rmrfroot.tasktracker222.services.UsersDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userCollection")
public class UserCollectionController {

    @Autowired
    private UsersDaoService usersDaoService;

    public UserCollectionController(UsersDaoService usersDaoService) {
        super();
        this.usersDaoService = usersDaoService;
    }

    public String main(Model model) {
        List<Users> userList = usersDaoService.findAll();

        model.addAttribute("users", userList);
        return "userCollection";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> findById(@PathVariable("id") int id) {
        return new ResponseEntity<>(usersDaoService.findById(id), HttpStatus.OK);
    }


    /*@PostMapping
    public ResponseEntity<Users> save(@RequestBody Users user) {
        return new ResponseEntity<>(usersDaoService.save(user), HttpStatus.CREATED);
    }*/



    @PutMapping("/{id}")
    public ResponseEntity<Users> update(@PathVariable("id") int id, @RequestBody Users user) {
        return new ResponseEntity<>(usersDaoService.update(id,user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id) {
        usersDaoService.deleteById(id);
    }
}
