package com.rmrfroot.tasktracker222.controllers;

import com.rmrfroot.tasktracker222.entities.deprecated.Drill;
import com.rmrfroot.tasktracker222.services.DrillDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class DrillSchedulerController {

    //get day collection singleton

    // ONLY GetMapping works for now
    // because front end has no way of importing data into the database
    @Autowired
    private DrillDaoService drillDaoService;

    public DrillSchedulerController(DrillDaoService drillDaoService) {
        super();
        this.drillDaoService = drillDaoService;
    }

    /**
     * For use by a singular recipient.
     * Only shows drills that are assigned to them.
     */
    @GetMapping("/drill-schedule-recipient")
    public String drillScheduleRecipient(Model model) {
        List<Drill> drillsToAdd = new ArrayList<>();
        List<Drill> drillsAll = drillDaoService.findAll();

        String username = getUsername();
        for (Drill drill : drillsAll) {
            /*
                TODO: Add all drills that match user ID
            */
        }


        model.addAttribute("drills", drillsToAdd);
        return "DrillScheduler";
    }

    /**
     * For use by a schedule manager.
     * Shows all scheduled drills that are assigned to officer.
     */
    @GetMapping("/drill-schedule-manager")
    public String drillScheduleManager(Model model) {
        List<Drill> drillsToAdd = new ArrayList<>();
        List<Drill> drillsAll = drillDaoService.findAll();

        String username = getUsername();
        for (Drill drill : drillsAll) {
            /*
                TODO: Update to use username field instead of officer name
            */
            if (drill.getOfficerName().equals(username)) {
                drillsToAdd.add(drill);
            }
        }

        model.addAttribute("drills", drillsToAdd);
        return "DrillScheduler";
    }

    @GetMapping("/drill-schedule-recipient/drills")                       // made a drills.html to check if scheduler
    public String getDrillCollection(Model model) {                          // is able to retrieve database
        model.addAttribute("drills", drillDaoService.findAll());
        return "drills";
    }

    @GetMapping("/drill-schedule-recipient/drills/{id}")
    public String findById(@PathVariable("id") int id, Model model) {
        model.addAttribute("drills", drillDaoService.findById(id));
        return "drills";
    }

    @GetMapping("/drill-schedule-manager/createDrill")
    public String createDrill(Model model) {
        Drill drill = new Drill();
        drill.setTitle("Test title");

        drill.setOfficerName("Test officer");
        drill.setDescription("Test description");

        ArrayList<String> locationList = new ArrayList<>();
        for(int i = 1; i < 10; i++){
            locationList.add("Location " + i);
        }

        ArrayList<String> teamList = new ArrayList();
        for (int i = 1; i < 5; i++) {
            teamList.add("Team " + i);
        }

        model.addAttribute("drill", drill);
        model.addAttribute("editing", false);

        model.addAttribute("locations", locationList);
        model.addAttribute("teams", teamList);
        return "CreateDrill";
    }

    @GetMapping("/drill-schedule-manager/editDrill/{drill-id}")
    public String editDrill(@PathVariable("drill-id") int id, Model model) {
        ArrayList<String> locationList = new ArrayList<>();
        for(int i = 1; i < 10; i++){
            locationList.add("Location " + i);
        }

        Drill drill = drillDaoService.findById(id);

        model.addAttribute("drill", drill);
        model.addAttribute("editing", true);

        model.addAttribute("locations", locationList);
        return "CreateDrill";
    }


    @PostMapping("/create-drill")
    public String save(@ModelAttribute("drills") Drill drill) {
        //drillDaoService.save(drill);
        return "redirect:/drill-schedule-recipient/drills";
    }

    @PutMapping()
    public ResponseEntity<Drill> update(@PathVariable("id") int id, Drill drill) {

        return new ResponseEntity<>(drillDaoService.update(id, drill), HttpStatus.OK);
    }

    @DeleteMapping()
    public void deleteById(@PathVariable("id") int id) {
        drillDaoService.deleteById(id);
    }

    /**
     * @return the username of the active session user
     */
    private String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            return currentUserName;
        }

        return null;
    }
}
