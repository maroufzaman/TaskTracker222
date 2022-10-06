package com.rmrfroot.tasktracker222.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

//Drill object class
@Entity
@Table(name="drills")
public class Drill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="event_title")
    private String title;

    @Column(name="start_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @Column(name="deadline_date")
    private Date deadlineDate;

    @Column(name="location")
    private String location;

    @Column(name="officer_name")
    private String officerName;

    @Column(name="officer_email")
    private String officerEmail;

    @Column(name="note")
    private String note;


    public Drill(String title, Date startDate, Date deadlineDate, String location, String officerName, String officerEmail, String note) {
        this.title = title;
        this.startDate = startDate;
        this.deadlineDate = deadlineDate;
        this.location = location;
        this.officerName = officerName;
        this.officerEmail = officerEmail;
        this.note = note;
    }

    public Drill() {
    }

    public void setId(int id){this.id = id;}

    public void setTitle(String title){this.title = title;}

    public void setStartDate(Date startDate){this.startDate =  startDate;}

    public void setDeadlineDate(Date deadlineDate){this.deadlineDate = deadlineDate;}

    public void setLocation(String location){this.location = location;}

    public void setOfficerName(String officerName){this.officerName = officerName;}

    public void setOfficerEmail(String officerEmail){this.officerEmail = officerEmail;}

    public void setNote(String note){this.note = note;}
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getStartDate(){return startDate;}

    public Date getDeadlineDate(){return deadlineDate;}

    public String getLocation(){return location;}

    public String getOfficerName(){return officerName;}

    public String getOfficerEmail(){return officerEmail;}

    public String getNote(){return note;}
}

