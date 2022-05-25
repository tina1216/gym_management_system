package project.domain.entity;

import java.time.*;
import java.util.*;

import project.Context;

public class Booking {

    Date currentDate = new Date();

    private String id;
    private String dateCreated;
    private int duration;
    private String bookedDate;
    private String trainerId;
    private String customerId;
    private boolean isOver = false;

    public Booking() {

    }

    public Booking(String id, String dateCreated, int duration, String bookedDate, String trainerId, String customerId,
            String feedbackId, boolean isOver) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.duration = duration;
        this.bookedDate = bookedDate;
        this.trainerId = trainerId;
        this.customerId = customerId;
        this.isOver = isOver;
    }

    /**
     * Constructor for reading in
     * 
     * @param line
     */
    public Booking(String[] line) {
        this.id = line[0];
        this.dateCreated = LocalDate.parse(line[1]).toString();
        this.duration = Integer.parseInt(line[2]);
        this.bookedDate = LocalDate.parse(line[3]).toString();
        this.trainerId = line[4];
        this.customerId = line[5];
        this.isOver = Boolean.parseBoolean(line[6]);
    }

    /**
     * Constructor to creat booking
     * 
     * @param inputs
     */
    public Booking addBooking(List<String> inputs) {
        Booking Booking = new Booking();

        Booking.id = UUID.randomUUID().toString();
        Booking.dateCreated = LocalDate.now().toString();
        Booking.duration = Integer.parseInt(inputs.get(1));
        Booking.bookedDate = inputs.get(2).toString();
        Booking.trainerId = inputs.get(3);
        Booking.customerId = Context.getInstance().getCurrentUserId();
        Booking.isOver = Boolean.parseBoolean(inputs.get(4));

        return Booking;
    }

    // -------------------------------------------------------------------------------

    public List<String> writeData() {
        List<String> data = new ArrayList<String>();

        data.addAll(new ArrayList<String>(
                Arrays.asList(String.valueOf(id), dateCreated, String.valueOf(duration), String.valueOf(bookedDate),
                        trainerId,
                        customerId, String.valueOf(isOver))));
        return data;
    }

    // -------------------------------------------------------------
    public String getId() {
        return id;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public int getDuration() {
        return duration;
    }

    public String getBookedDate() {
        return bookedDate;
    }

    public String getTrainerId() {
        return trainerId;
    }

    public String getCustomerId() {
        // Context.getInstance().getCustomer() して、
        // filter で id 検索かけて（findByCode）して
        // return は Customer
        return customerId = Context.getInstance().getCurrentUserId();
    }

    public boolean getIsOver() {
        return isOver;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setBookedDate(String bookedDate) {
        this.bookedDate = bookedDate;
    }

    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
    }

    public void setCustomer(String customerId) {
        this.customerId = customerId;
    }

    public void setOver(boolean isOver) {
        this.isOver = isOver;
    }

}
