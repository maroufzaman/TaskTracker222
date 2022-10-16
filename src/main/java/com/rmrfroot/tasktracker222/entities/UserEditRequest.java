package com.rmrfroot.tasktracker222.entities;

public class UserEditRequest {

    public String first_name;
    public String last_name;
    public String email;
    public String mil_email;
    public String civ_email;
    public String personal_phone;
    public String office_phone;
    public String rank;
    public String workcenter;
    public String flight;
    public String teams;

    public UserEditRequest(){

    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMil_email() {
        return mil_email;
    }

    public void setMil_email(String mil_email) {
        this.mil_email = mil_email;
    }

    public String getCiv_email() {
        return civ_email;
    }

    public void setCiv_email(String civ_email) {
        this.civ_email = civ_email;
    }

    public String getPersonal_phone() {
        return personal_phone;
    }

    public void setPersonal_phone(String personal_phone) {
        this.personal_phone = personal_phone;
    }

    public String getOffice_phone() {
        return office_phone;
    }

    public void setOffice_phone(String office_phone) {
        this.office_phone = office_phone;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getWorkcenter() {
        return workcenter;
    }

    public void setWorkcenter(String workcenter) {
        this.workcenter = workcenter;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public String getTeams() {
        return teams;
    }

    public void setTeams(String teams) {
        this.teams = teams;
    }
}
