package com.rmrfroot.tasktracker222.controllers;

import com.rmrfroot.tasktracker222.entities.DrillSchedules;
import com.rmrfroot.tasktracker222.entities.Users;
import com.rmrfroot.tasktracker222.entities.deprecated.Drill;
import com.rmrfroot.tasktracker222.services.DrillDaoService;
import com.rmrfroot.tasktracker222.services.DrillScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DrillEditController {

    @Autowired
    private DrillDaoService drillDaoService;
    @Autowired
    private DrillScheduleService drillScheduleService;

    public DrillEditController(DrillDaoService drillDaoService){
        //super();
        this.drillDaoService = drillDaoService;
    }

//    @GetMapping("/drill-schedule-recipient/drills/{id}")
//    public String getDrillSchedules(@PathVariable("id") int id, Model model) {
//        model.addAttribute("drillSchedules", drillScheduleService.findDrillSchedulesById(id));
//        return "drillSchedules";
//    }

    @PostMapping
    public String editDrill(@ModelAttribute("drill_name") DrillSchedules drillSchedules) {
        //sanitization
        drillScheduleService.save(drillSchedules);
        return "redirect:/drill-schedule-recipient/drills";
    }

//    @PutMapping("/drill-schedule-recipient/drills/{id}")
//    public ResponseEntity<DrillSchedules> update(@PathVariable("id") int id, DrillSchedules drillSchedules) {
//
//        return new ResponseEntity<>(drillScheduleService.update(id, drillSchedules), HttpStatus.OK);
//    }

    @DeleteMapping("drills/{id}")
    public void deleteDrillById(@PathVariable("id") int id) {
        drillDaoService.deleteById(id);
    }

}
