package com.rmrfroot.tasktracker222.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="drill_schedule")
public class DrillSchedules {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="event_title")
    private String event_title;
    @Column(name="start_date")
    private String start_date;
    @Column(name="deadline_date")
    private String deadline_date;
    @Column(name="location")
    private String location;
    @Column(name="admin_name")
    private String admin_name;
    @Column(name="officer_email")
    private String officer_email;
    @Column(name="note")
    private String note;
    @Column(name="created_timestamp")
    private String created_timestamp;

    @ManyToMany(
            fetch=FetchType.LAZY,
            cascade = {CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH
            })
    @JoinTable(
            name="users_drill_schedule",
            joinColumns =@JoinColumn(name="drill_schedule_id"),
            inverseJoinColumns = @JoinColumn(name="users_id")
    )
    private List<User> userList;

    public DrillSchedules() {
    }

    public DrillSchedules(String event_title, String start_date, String deadline_date, String location, String admin_name, String officer_email, String note, String created_timestamp) {
        this.event_title = event_title;
        this.start_date = start_date;
        this.deadline_date = deadline_date;
        this.location = location;
        this.admin_name = admin_name;
        this.officer_email = officer_email;
        this.note = note;
        this.created_timestamp = created_timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvent_title() {
        return event_title;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getDeadline_date() {
        return deadline_date;
    }

    public void setDeadline_date(String deadline_date) {
        this.deadline_date = deadline_date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getOfficer_email() {
        return officer_email;
    }

    public void setOfficer_email(String officer_email) {
        this.officer_email = officer_email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getCreated_timestamp() {
        return created_timestamp;
    }

    public void setCreated_timestamp(String created_timestamp) {
        this.created_timestamp = created_timestamp;
    }

    public List<User> getUsersList() {
        return userList;
    }

    public void setUsersList(List<User> userList) {
        this.userList = userList;
    }
    public void addUsers(User user){
        if(userList ==null){
            userList =new ArrayList<>();
        }
        userList.add(user);
    }

}
