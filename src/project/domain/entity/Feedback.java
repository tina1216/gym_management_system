package project.domain.entity;

import java.io.*;
import java.time.*;
import java.util.*;

public class Feedback {

    private String id;
    private String dateCreated;
    private String comment;
    private String trainerId;
    private String customerId;
    private String bookingId;

    public Feedback() {

    }

    public Feedback(String id, String dateCreated, String comment, String trainerId, String customerId,
            String bookingId) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.comment = comment;
        this.trainerId = trainerId;
        this.customerId = customerId;
        this.bookingId = bookingId;
    }

    /**
     * Constructor to read
     * 
     * @param line
     */
    public Feedback(String[] line) {
        this.id = line[0];
        this.dateCreated = line[1];
        this.comment = line[2];
        this.trainerId = line[3];
        this.customerId = line[4];
        this.bookingId = line[5];
    }

    /**
     * Constructor to insert and update
     * 
     * @param inputs
     */
    public Feedback(List<String> inputs) {
        this.id = UUID.randomUUID().toString();
        this.dateCreated = LocalDate.now().toString();
        this.comment = inputs.get(0);
        this.trainerId = inputs.get(1);
        this.customerId = inputs.get(2);
        this.bookingId = inputs.get(3);
    }

    // -------------------------------------------------------------------------------

    public List<String> writeData() {
        List<String> data = new ArrayList<String>();

        data.addAll(new ArrayList<String>(
                Arrays.asList(String.valueOf(id), dateCreated, comment, trainerId, customerId, bookingId)));
        return data;
    }

    // -------------------------------------------------------------
    public String getId() {
        return id;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getComment() {
        return comment;
    }

    public String getTrainerId() {
        return trainerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

}
