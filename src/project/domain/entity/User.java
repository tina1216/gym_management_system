package project.domain.entity;

import java.io.*;
import java.time.*;
import java.util.*;

public class User extends Person {

    public User() {

    }

    public User(String id, String username, String password, String fullName, String gender, String phoneNumber,
            String email, String role) {
        super(id, username, password, fullName, gender, phoneNumber, email, role);
    }

    // -----------------------------------------------------------------------

    // -----------------------------------------------------------------------

    // private boolean addNewUser(User newUser) {
    // if(anyUsers.contains(newUser)) {
    // System.out.println(newUser.getUsername() + " already exists.");
    // return false;
    // }
    // anyUsers.add(newUser);

    // System.out.println(newUser.getUsername() + " has created.");
    // return true;
    // }

    // public User createUser(String id, String username, String password, String
    // fullName, String gender,
    // String phoneNumber, String email, String role) {

    // return new User(id, username, password, fullName, gender, phoneNumber, email,
    // role);
    // }

    // private void addUser(String role) {
    // Scanner scanner = new Scanner(System.in);

    // System.out.println("Please enter information: ");
    // System.out.print("Enter username: ");
    // String newUsername = scanner.nextLine();
    // System.out.print("Enter password: ");
    // String newPassword = scanner.nextLine();
    // System.out.print("Enter full name: ");
    // String newFullName = scanner.nextLine();
    // System.out.print("Enter gender: ");
    // String newGender = scanner.nextLine();
    // System.out.print("Enter phone number: ");
    // String newPhoneNum = scanner.nextLine();
    // System.out.print("Enter email address: ");
    // String newEmail = scanner.nextLine();

    // String newId = UUID.randomUUID().toString();

    // User newUser = this.createUser(newId, newUsername, newPassword, newFullName,
    // newGender, newPhoneNum, newEmail, role);

    // if (addNewUser(newUser)) {
    // //update customer.txt
    // System.out.println("update .txt");
    // }
    // scanner.close();
    // }

    // // print user's information
    // public void printAll() {
    // for(int i = 0; i < anyUsers.size(); i++) {
    // System.out.println("ID: " + anyUsers.get(i).getId());
    // System.out.println("Username: " + anyUsers.get(i).getUsername());
    // System.out.println("Password: " + anyUsers.get(i).getPassword());
    // System.out.println("Name: " + anyUsers.get(i).getFullName());
    // System.out.println("Geder: " + anyUsers.get(i).getGender());
    // System.out.println("Phone Number: " + anyUsers.get(i).getPhoneNumber());
    // System.out.println("Email: " + anyUsers.get(i).getEmail());
    // System.out.println("---------------------------");
    // }
    // }

}
