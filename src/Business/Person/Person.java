/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author janet chong
 */
public class Person {

    String id;
    String firstName;
    String lastName;
    String email;
    String phone;
    String nuid;
    String department;
    String title;
    String lastUpdated;

    public Person(String id) {

        this.id = id;
        this.firstName = id;
        this.lastName = "";
        this.email = "";
        this.phone = "";
        this.nuid = "";
        this.department = "";
        this.title = "";
        touch();
    }

    public String getPersonId() {
        return id;
    }

    public void setPersonId(String id) {
        this.id = id;
        touch();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        touch();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        touch();
    }

    public String getFullName() {
        if (lastName == null || lastName.trim().isEmpty()) {
            return firstName;
        }
        return firstName + " " + lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        touch();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        touch();
    }

    public String getNuid() {
        return nuid;
    }

    public void setNuid(String nuid) {
        this.nuid = nuid;
        touch();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
        touch();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        touch();
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void touch() {
        lastUpdated = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public boolean isMatch(String id) {
        if (getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return getPersonId();
    }
}

