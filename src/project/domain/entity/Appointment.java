package project.domain.entity;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Appointment {

    private String id;
    private LocalDate dateAdded;
    private int duration;
    private String bookedDate;
    // trainer id
    // customer id

    public Appointment() {

    }

    public Appointment(String id, LocalDate dateAdded, int duration, String bookedDate, Trainer trainer,
            Customer customer) {
        this.id = id;
        this.dateAdded = dateAdded;
        this.duration = duration;
        this.bookedDate = bookedDate;
        this.trainer = trainer;
        this.customer = customer;
        this.thisFeedback = new ArrayList<Feedback>();
    }

    // -------------------------------------------------------------------------------

    /**
     * LocalDateTime myDateObj = LocalDateTime.now();
     * System.out.println("Before Formatting: " + myDateObj);
     * DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy
     * HH:mm:ss");
     * 
     * String formattedDate = myDateObj.format(myFormatObj);
     * System.out.println("After Formatting: " + formattedDate);
     */

    // getters & setters
    // -------------------------------------------------------------
    public String getId() {
        return id;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public int getDuration() {
        return duration;
    }

    public String getBookedDate() {
        return bookedDate;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<Feedback> getThisFeedback() {
        return thisFeedback;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setBookedDate(String bookedDate) {
        this.bookedDate = bookedDate;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setThisFeedback(ArrayList<Feedback> thisFeedback) {
        this.thisFeedback = thisFeedback;
    }

}
