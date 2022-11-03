package com.rmrfroot.tasktracker222.controllers;

import com.rmrfroot.tasktracker222.entities.DrillSchedules;
import com.rmrfroot.tasktracker222.entities.deprecated.Drill;
import com.rmrfroot.tasktracker222.services.DrillDaoService;
import com.rmrfroot.tasktracker222.services.DrillScheduleService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@WebMvcTest(DrillEditController.class)
class DrillEditControllerTest {

    @MockBean
    private DrillDaoService drillDaoService;

    @MockBean
    private DrillScheduleService drillScheduleService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    MockMvc mockMvc;

    private DrillSchedules drillSchedules = new DrillSchedules("event_title", "start_date", "deadline_date",
            "location", "admin_name", "officer_email@root.com","note", "created_timestamp");



    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .build();
    }

    @WithMockUser(username = "admin",roles={"USER","ADMIN"})
    @Test
    void editDrill() {

        //given(drillScheduleService.save(drillSchedules)).willReturn(drillSchedules);

    }

    @Test
    void deleteDrillById() {


    }
}