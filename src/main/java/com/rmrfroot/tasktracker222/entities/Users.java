package com.rmrfroot.tasktracker222.entities;


import com.vladmihalcea.hibernate.type.array.ListArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

@Entity
@Table(name = "users")
@TypeDef(
        name = "team",
        typeClass = ListArrayType.class
)
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String userName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mil_email")
    private String militaryEmail;

    @Column(name = "civ_email")
    private String civilianEmail;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "office_number")
    private String officeNumber;

    @Column(name = "rank")
    private String rank;

    @Column(name = "work_center")
    private String workCenter;

    @Column(name = "flight")
    private String flight;

    @Type(type = "team")
    @Column(name = "teams", columnDefinition = "text[]")
    private ArrayList<String> teams;

    @ManyToMany(
            fetch=FetchType.LAZY,
            cascade = {CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH
            })
    @JoinTable(
            name="users_drill_schedule",
            joinColumns =@JoinColumn(name="users_id"),
            inverseJoinColumns = @JoinColumn(name="drill_schedule_id")
    )
    private List<DrillSchedules> drillSchedulesList;

    public Users() {

    }

    public Users(String userName, String firstName, String lastName, String militaryEmail, String civilianEmail, String email,
                 String phoneNumber, String officeNumber, String rank, String workCenter,
                 String flight, ArrayList<String> teams) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.militaryEmail = militaryEmail;
        this.civilianEmail = civilianEmail;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.officeNumber = officeNumber;
        this.rank = rank;
        this.workCenter = workCenter;
        this.flight = flight;
        this.teams = teams;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static boolean isValidEmailAddrRegex(String emailValidationRegex, String emailAddrToValidate) {
        return Pattern.matches(emailValidationRegex, emailAddrToValidate);
    }
    public String getCivilianEmail() {
        return civilianEmail;
    }

    public void setCivilianEmail(String civilianEmail) {
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        if(isValidEmailAddrRegex(regexPattern, civilianEmail)) {
            this.civilianEmail = civilianEmail;
        }
        else {
            throw new IllegalArgumentException("Not a valid email");
        }
    }
    public String getMilitaryEmail() {
        return militaryEmail;
    }

    public void setMilitaryEmail(String militaryEmail) {
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        if(isValidEmailAddrRegex(regexPattern, militaryEmail)) {
            this.militaryEmail = militaryEmail;
        }
        else {
            throw new IllegalArgumentException("Not a valid email");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName.matches("[a-zA-Z]+")) {
            this.firstName = firstName;
        }
        else {
            throw new IllegalArgumentException("Not a valid name. First name should only contain letters");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.matches("[a-zA-Z]+")) {
            this.lastName = lastName;
        }
        else {
            throw new IllegalArgumentException("Not a valid name. Last name should only contain letters");
        }
    }



//    public String getRegister_date() {
//        return register_date;
//}

//    public void setRegister_date(String register_date) {
//        still working to fix this to work properly
//        String datePattern = "\\d{1,2}-\\d{1,2}-\\d{4}";
//        if (register_date.matches(datePattern)) {
//            this.register_date = register_date;
//        }
//        else {
//            throw new IllegalArgumentException("Register date must be MM/DD/YYYY. Not a valid date.");
//        }
//        this.register_date = register_date;
//   }

//    public String getUpdate_date() {
//        return update_date;
//   }

//    public void setUpdate_date(String update_date) {
//        still working to fix this to work properly
//        String datePattern = "\\d{1,2}-\\d{1,2}-\\d{4}";
//        if (update_date.matches(datePattern)) {
//            this.update_date = update_date;
//        }
//        else {
//            throw new IllegalArgumentException("Update date must be MM/DD/YYYY. Not a valid date.");
//        }
//        this.update_date = update_date;
//    }


    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getWorkCenter() {
        return workCenter;
    }

    public void setWorkCenter(String workCenter) {
        this.workCenter = workCenter;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

//    public ArrayList<String> getTeamList() {
//        return teamList;
//    }
//
//    public void setTeamList(ArrayList<String> teamList) {
//        this.teamList = teamList;
//    }

    //not used yet, ready to implement when needed
    //    random uuid
    private static void generateUUID() {
        UUID uuid = UUID.randomUUID();
    }

    public ArrayList<String> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<String> teams) {
        this.teams = teams;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<DrillSchedules> getDrillSchedulesList() {
        return drillSchedulesList;
    }

    public void setDrillSchedulesList(List<DrillSchedules> drillSchedulesList) {
        this.drillSchedulesList = drillSchedulesList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addDrillSchedule(DrillSchedules drillSchedules){
        if(drillSchedulesList ==null){
            drillSchedulesList=new ArrayList<>();
        }
        drillSchedulesList.add(drillSchedules);
    }
}
