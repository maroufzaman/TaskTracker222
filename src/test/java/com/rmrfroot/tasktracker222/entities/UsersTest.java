package com.rmrfroot.tasktracker222.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsersTest {

    int id = 12345;
    String email = "bfrey@root.edu";
    String fname = "Brian";
    String lname = "Frey";
    String reg_date = "11/11/22";
    String up_date = "2/2/23";

    Users user = new Users(email,fname,lname,reg_date,up_date);

    @Test
    void getId() {
        user.setId(id);
        assertEquals(id,user.getId());
    }

    @Test
    void setId() {
        user.setId(22222);
        assertEquals(22222,user.getId());
    }

    @Test
    void getEmail() {
        assertEquals(email,user.getEmail());
    }

    @Test
    void setEmail() {
        user.setEmail("new@root.edu");
        assertEquals("new@root.edu",user.getEmail());
    }

    @Test
    void getFirstName() {
        assertEquals(fname,user.getFirstName());
    }

    @Test
    void setFirstName() {
        user.setFirstName("Bill");
        assertEquals("Bill",user.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals(lname,user.getLastName());
    }

    @Test
    void setLastName() {
        user.setLastName("Lee");
        assertEquals("Lee",user.getLastName());
    }

    @Test
    void getRegister_date() {
        assertEquals(reg_date,user.getRegister_date());
    }

    @Test
    void setRegister_date() {
        user.setRegister_date("12/12/22");
        assertEquals("12/12/22",user.getRegister_date());
    }

    @Test
    void getUpdate_date() {
        assertEquals(up_date,user.getUpdate_date());
    }

    @Test
    void setUpdate_date() {
        user.setUpdate_date("5/5/25");
        assertEquals("5/5/25",user.getUpdate_date());

    }
}