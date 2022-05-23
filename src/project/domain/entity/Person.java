package project.domain.entity;

import project.domain.enums.AccountType;
import project.Context;

import java.util.*;

public class Person {

    protected String id;
    protected String username;
    protected String password;
    protected String fullName;
    protected String gender;
    protected String phoneNumber;
    protected String email;
    protected String role;

    public Person() {

    }

    public Person(String id, String username, String password, String fullName, String gender, String phoneNumber,
            String email, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = role;
    }

    /**
     * Constructor to read
     * 
     * @param line
     */
    public Person(String[] line) {
        this.id = line[0];
        this.username = line[1];
        this.password = line[2];
        this.fullName = line[3];
        this.gender = line[4];
        this.phoneNumber = line[5];
        this.email = line[6];
        this.role = line[7];
    }

    /**
     * Constructor to insert and update
     * 
     * @param inputs
     */
    public Person generatePerson(List<String> inputs) {
        Person person = new Person();

        person.id = UUID.randomUUID().toString();
        person.username = inputs.get(1);
        person.password = inputs.get(2);
        person.fullName = inputs.get(3);
        person.gender = inputs.get(4);
        person.phoneNumber = inputs.get(5);
        person.email = inputs.get(6);
        person.role = Context.getInstance().getAccountType().toString();

        return person;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
