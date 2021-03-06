package com.youthdiversion.calendar;

/**
 * Created by Christopher on 2/6/2016.
 */
public class Member {

    private String fName, lName, password, email, phone;
    private int member_id;

    public Member(int id, String fName, String lName, String password, String email, String phone) {

        this.member_id = id;
        this.fName = fName;
        this.lName = lName;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return member_id;
    }

    public void setId(int id) {
        this.member_id = id;
    }
}
