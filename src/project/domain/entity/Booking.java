package project.domain.entity;

import java.time.*;
import java.text.DateFormat;
import java.util.*;

public class Booking {

    Date currentDate = new Date();

    private String id;
    private String dateCreated;
    private int duration;
    private String bookedDate;
    private String trainerId;
    private String customerId;
    private String feedbackId;

    public Booking() {

    }

    public Booking(String id, String dateCreated, int duration, String bookedDate, String trainerId, String customerId,
            String feedbackId) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.duration = duration;
        this.bookedDate = bookedDate;
        this.trainerId = trainerId;
        this.customerId = customerId;
        this.feedbackId = feedbackId;
    }

    /**
     * Constructor to read
     * 
     * @param line
     */
    public Booking(String[] line) {
        this.id = line[0];
        this.dateCreated = line[1];
        this.duration = Integer.parseInt(line[2]);
        this.bookedDate = line[3];
        this.trainerId = line[4];
        this.customerId = line[5];
        this.feedbackId = line[6];
    }

    /**
     * Constructor to insert and update
     * 
     * @param inputs
     */
    public Booking(List<String> inputs) {
        this.id = UUID.randomUUID().toString();
        this.dateCreated = LocalDate.now().toString();
        this.duration = Integer.parseInt(inputs.get(1));
        this.bookedDate = inputs.get(2);
        this.trainerId = inputs.get(3);
        this.customerId = inputs.get(4);
        this.feedbackId = inputs.get(4);
    }

    // -------------------------------------------------------------------------------

    /**
     * Date currentDate = new Date();
     * dateToStr = DateFormat.getDateInstance().format(currentDate);
     * System.out.println("Date Format using getDateInstance(): "+ dateToStr);
     */

    public List<String> writeData() {
        List<String> data = new ArrayList<String>();

        data.addAll(new ArrayList<String>(
                Arrays.asList(String.valueOf(id), dateCreated, String.valueOf(duration), bookedDate, trainerId,
                        customerId, feedbackId)));
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
        return customerId;
    }

    public String getFeedbackId() {
        return feedbackId;
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

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
    }

}
