package project.domain.entity;

import java.time.*;
import java.util.*;

public class Feedback {

    private String id;
    private LocalDate dateCreated;
    private String fb;
    private Trainer trainer;
    private Customer customer;
    // appointment id

    public Feedback() {

    }

    public Feedback(String id, LocalDate dateCreDate, String fb, Trainer trainer, Customer customer) {
        this.id = id;
        this.dateCreated = dateCreDate;
        this.fb = fb;
        this.trainer = trainer;
        this.customer = customer;
    }

    // -------------------------------------------------------------------------------

    // getters & setters
    // -------------------------------------------------------------
    public String getId() {
        return id;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public String getFb() {
        return fb;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setFb(String fb) {
        this.fb = fb;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
