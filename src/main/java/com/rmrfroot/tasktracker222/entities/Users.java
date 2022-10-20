package com.rmrfroot.tasktracker222.entities;


import javax.persistence.*;
//import java.time.LocalDate;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "register_date")
    private String register_date;

    @Column(name = "update_date")
    private String update_date;

    @Column(name = "admin")
    private boolean admin;

    @Column(name = "rank")
    private String rank;

    @Column(name = "workCenter")
    private String workCenter;

    @Column(name = "flight")
    private String flight;

    //@ElementCollection
    //@Column(name = "teams")
    //private ArrayList<String> teamList;
    @Column(name = "team")
    private static String team;

    public Users() {

    }

    public Users(String email, String first_name, String last_name,
                String register_date, String update_date,
                boolean admin, String rank, String workCenter,
                String flight, String team) {
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.register_date = register_date;
        this.update_date = update_date;
        this.admin = admin;
        this.rank = rank;
        this.workCenter = workCenter;
        this.flight = flight;
        //this.teamList = teamList;
        this.team = team;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.indexOf('@')<0 || email.indexOf('.')<0) {
            this.email = email;
        }
        else {
            throw new IllegalArgumentException("Not a valid email");
        }

    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        if(first_name.matches("[a-zA-Z]+")) {
            this.first_name = first_name;
        }
        else {
            throw new IllegalArgumentException("Not a valid name. First name should only contain letters");
        }
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        if(last_name.matches("[a-zA-Z]+")) {
            this.last_name = last_name;
        }
        else {
            throw new IllegalArgumentException("Not a valid name. Last name should only contain letters");
        }
    }

    public String getRegister_date() {
        return register_date;
    }

    public void setRegister_date(String register_date) {
//        still working to fix this to work properly
//        String datePattern = "\\d{1,2}-\\d{1,2}-\\d{4}";
//        if (register_date.matches(datePattern)) {
//            this.register_date = register_date;
//        }
//        else {
//            throw new IllegalArgumentException("Register date must be MM/DD/YYYY. Not a valid date.");
//        }
        this.register_date = register_date;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
//        still working to fix this to work properly
//        String datePattern = "\\d{1,2}-\\d{1,2}-\\d{4}";
//        if (update_date.matches(datePattern)) {
//            this.update_date = update_date;
//        }
//        else {
//            throw new IllegalArgumentException("Update date must be MM/DD/YYYY. Not a valid date.");
//        }
        this.update_date = update_date;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) throws FileNotFoundException {
        File fileText = new File("rank.txt");
        Scanner s = new Scanner(fileText);
        int r = 0;

        while(s.hasNextLine()){
            if(rank.equals(s.nextLine().trim())){
                r += 1;
            }
        }
        if (r == 1) {
            this.rank = rank;
        }
        else {
            throw new IllegalArgumentException("Not a valid Rank.");
        }
    }

    public String getWorkCenter() {
        return workCenter;
    }

    public void setWorkCenter(String workCenter) throws FileNotFoundException {
        File fileText = new File("workcenter.txt");
        Scanner s = new Scanner(fileText);
        int w = 0;

        while(s.hasNextLine()){
            if(workCenter.equals(s.nextLine().trim())){
                w += 1;
            }
        }
        if (w == 1) {
            this.workCenter = workCenter;
        }
        else {
            throw new IllegalArgumentException("Not a valid workcenter.");
        }
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) throws FileNotFoundException {
        File fileText = new File("flight.txt");
        Scanner s = new Scanner(fileText);
        int f = 0;

        while(s.hasNextLine()){
            if(flight.equals(s.nextLine().trim())){
                f += 1;
            }
        }
        if (f == 1) {
            this.flight = flight;
        }
        else {
            throw new IllegalArgumentException("Not a valid flight.");
        }
    }

//    public ArrayList<String> getTeamList() {
//        return teamList;
//    }
//
//    public void setTeamList(ArrayList<String> teamList) {
//        this.teamList = teamList;
//    }

    public String getTeam() {
        return team;
    }
    public void setTeam(String team) throws FileNotFoundException {
        File fileText = new File("team.txt");
        Scanner s = new Scanner(fileText);
        int t = 0;

        while(s.hasNextLine()){
            if(team.equals(s.nextLine().trim())){
                t += 1;
            }
        }
        if (t <= 1) {
            this.team = team;
        }
        else {
            throw new IllegalArgumentException("Not a valid team.");
        }
    }

    public static void addTeam() {
        Scanner s = new Scanner(System.in);
        String teams = s.nextLine();
        ArrayList<String> list = new ArrayList<>(Arrays.asList(teams.split("\\s*,\\s*")));
        Set<String> aSet = new HashSet<>(list);
        list.add(String.valueOf(aSet));
    }

    //not used yet, ready to implement when needed
    //    random uuid
    private static void generateUUID() {
        UUID uuid = UUID.randomUUID();
    }

    //figured out a way to read user groups from text file, but not sure
    //how to implement to the project.
    //    public static void main (String[] args) {
//        String[] words = readGroup("group.txt");
//        for (int i = 0; i < words.length; i = i + 1){
//            System.out.println(words[i]);
//        }
//        System. out.println(Arrays.toString(words));
//    }
    public static String[] readGroup(String file) {
        int ctr = 0;
        try {
            Scanner s1 = new Scanner(new File(file));
            while (s1.hasNextLine()) {
                ctr = ctr + 1;
                s1.nextLine();
            }
            String[] words = new String[ctr];
            Scanner s2 = new Scanner(new File(file));
            for (int i = 0; i < ctr; i = i + 1) {
                words[i] = s2.nextLine();
            }
            return words;
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return null;
    }
}