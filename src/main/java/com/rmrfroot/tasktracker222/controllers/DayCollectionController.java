package com.rmrfroot.tasktracker222.controllers;

import com.rmrfroot.tasktracker222.entities.Day;
import com.rmrfroot.tasktracker222.services.DaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dayCollection")
public class DayCollectionController {


    @Autowired
    private DaoService daoService;


    @GetMapping
    public String main(Model model){
        List<Day> dayList =daoService.findAll();

        model.addAttribute("days", dayList);
        return "dayCollection";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Day> findById(@PathVariable("id") int id) {
        return new ResponseEntity<>(daoService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Day> save(@RequestBody Day day) {
        return new ResponseEntity<>(daoService.save(day), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Day> update(@PathVariable("id") int id, @RequestBody Day day) {
        return new ResponseEntity<>(daoService.update(id, day), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id) {
        daoService.deleteById(id);
    }

}
