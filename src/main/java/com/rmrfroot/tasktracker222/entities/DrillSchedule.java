package com.rmrfroot.tasktracker222.entities;


import java.time.LocalDate;

public class DrillSchedule {

    private String event_title;
    private String location;
    private String officer_name;
    private String officer_email;
    private String note;
    private LocalDate start_date;
    private LocalDate deadline_date;
    private int id;

    public DrillSchedule(int id, String officer_name,
                  String officer_email, String event_title, String location,
                         String note, LocalDate start_date, LocalDate deadline_date) {
        //this(officer_name, officer_email, event_title, location, note, start_date, deadline_date);
        this.officer_name = officer_name;
        this.officer_email = officer_email;
        this.event_title = event_title;
        this.location = location;
        this.note = note;
        this.start_date = start_date;
        this.deadline_date = deadline_date;
        this.id = id;
    }
    public DrillSchedule(String firstName, String lastName, LocalDate dob) {
        this.officer_name = officer_name == null ? "" : officer_name;
        this.event_title = event_title == null ? "" : event_title;
        this.location = location == null ? "" : location;
        this.note = note == null ? "" : note;
        this.start_date = start_date == null ? LocalDate.parse("") : start_date;
        this.deadline_date = deadline_date == null ? LocalDate.parse("") : deadline_date;

        if(officer_email == null){
            throw new RuntimeException("Officer's email is null");
        }
        this.officer_email = officer_email;
    }

    public DrillSchedule(String officer_name, String officer_email, String event_title,
                         String location, String note, LocalDate start_date, LocalDate deadline_date) {
    }

    public String getOfficer_name() { return officer_name; }
    public String getOfficer_email() {return officer_email; }
    public String getEvent_title() { return event_title; }
    public String getNote() { return note;}
    public LocalDate getStart_date() { return start_date; }
    public LocalDate getDeadline_date() { return deadline_date; }
}
