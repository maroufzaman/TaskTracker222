package com.rmrfroot.tasktracker222.controllers;

import com.rmrfroot.tasktracker222.entities.DrillSchedules;
import com.rmrfroot.tasktracker222.entities.UserEditRequest;
import com.rmrfroot.tasktracker222.entities.Users;
import com.rmrfroot.tasktracker222.services.DrillScheduleService;
import com.rmrfroot.tasktracker222.services.UsersDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@Controller
public class UsersController {

    @Autowired
    private UsersDaoService usersDaoService;

    @Autowired
    private DrillScheduleService drillScheduleService;

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
    public String userEditSubmit(@ModelAttribute("userEditRequest") UserEditRequest request) {
        Users u = usersDaoService.findById(Integer.parseInt(request.getId()));

        u.setFirstName(request.getFirstName());
        u.setLastName(request.getLastName());
        u.setMilitaryEmail(request.getMilitaryEmail());
        u.setCivilianEmail(request.getCivilianEmail());
        u.setPhoneNumber(request.getPhoneNumber());
        u.setOfficeNumber(request.getOfficeNumber());
        u.setRank(request.getRank());
        u.setWorkCenter(request.getWorkCenter());
        u.setFlight(request.getFlight());
//        u.setTeams(request.getTeams());   //TODO - Integrate ArrayList-style team list

        usersDaoService.update(u.getId(), u);

        return "redirect:/users";
    }

    @PostMapping(value = "/users", params = "delete")
    public String userEditDelete(@ModelAttribute("userEditRequest") UserEditRequest request) {
        System.out.println("delete");
        Users u = usersDaoService.findById(Integer.parseInt(request.getId()));


        usersDaoService.deleteById(u.getId());
        //TODO - Add functionality to delete user from database and cognito

        return "redirect:/users";
    }


    @GetMapping("/users/{id}")
    public String findById(@PathVariable("id") int id, Model model) {
        model.addAttribute("users", usersDaoService.findById(id));
        return "users";
    }

    /**
     *
     * Skeleton Code for controller access after user login
     * depending on the role of user (officer or not)
     *
     * With having no way of differentiating user from another
     * can't be used
     */
    @GetMapping("users/accessControl")
    public String accessControl(Model model) {
        Users user = new Users();
        model.addAttribute("users", user);
    /*  if(user.isAdmin())
            return "redirect:/drill-schedule-manager";
        else*/
            return "redirect:/drill-schedule-recipient";
    }

    @GetMapping("/users/newUser")
    public String addUser(Model model) {
        Users user = new Users();
        model.addAttribute("users", user);
        DrillSchedules drillSchedules1=new DrillSchedules(
               "lorem" ,
                "start_date",
                "deadline_date",
                "location",
                "admin_name",
                "officer_email",
                "note",
                "create_timestamp"
        );
        DrillSchedules drillSchedules2=new DrillSchedules(
                "lorem" ,
                "start_date",
                "deadline_date",
                "location",
                "admin_name",
                "officer_email",
                "note",
                "create_timestamp"
        );
        ArrayList<String> team =new ArrayList<>();
        team.add("team1");
        team.add("team2");
        Users addUser1=new Users(
                "visoth99",
                "visoth",
                "cheam",
                "visoth99@gmail.com",
                "visothMili@gmail.com",
                "912431234892349",
                "23432",
                "Lorem",
                "Clafornia branch",
                "f22",
                team
                );
        Users addUser2=new Users(
                "visoth99",
                "visoth",
                "cheam",
                "visoth99@gmail.com",
                "visothMili@gmail.com",
                "912431234892349",
                "23432",
                "Lorem",
                "Clafornia branch",
                "f22",
                team
        );
        Users addUserAdmin=new Users(
                "adderUserAdmin",
                "visoth",
                "cheam",
                "visoth99@gmail.com",
                "visothMili@gmail.com",
                "912431234892349",
                "23432",
                "Lorem",
                "Clafornia branch",
                "f22",
                team
        );
        /*drillScheduleService.save(drillSchedules1);
        drillSchedules1.addUsers(addUser1);
        drillSchedules1.addUsers(addUser2);
        usersDaoService.save(addUser1);
        usersDaoService.save(addUser2);

        //create new users and add to exist drill_schedules
        DrillSchedules drillSchedules=drillScheduleService.findDrillSchedulesById(53);
        drillSchedules.addUsers(addUser1);
        drillSchedules.addUsers(addUser2);
        usersDaoService.save(addUser1);
        usersDaoService.save(addUser2);

        //exist users with exist drill_schedules
        DrillSchedules drillSchedules=drillScheduleService.findDrillSchedulesById(54);
        Users usersExist=usersDaoService.findById(77);
        drillSchedules.addUsers(usersExist);
        usersDaoService.save(usersExist);

        //a new drill_schedule with exists an admin user, and recipient users
        Users usersExist=usersDaoService.findById(77);
        drillSchedules1.addUsers(usersDaoService.findUsersById(78));
        drillSchedules1.addUsers(usersDaoService.findUsersById(79));
        usersExist.addDrillSchedule(drillSchedules1);
        usersDaoService.save(usersExist);*/
        return "registration_form";

    }
    @PostMapping("/register")
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
