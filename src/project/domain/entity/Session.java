package project.domain.entity;

import java.time.*;
import java.util.*;
import java.text.DateFormat;

public class Session {

    Date currentDate = new Date();
    private String id;
    private String dateCreated;
    private int duration;
    private String bookedDate;
    private String trainerId;
    private String customerId;
    private String feedbackId;
    private boolean isOver;

    public Session() {

    }

    public Session(String id, String dateCreated, int duration, String bookedDate, String trainerId, String customerId,
            String feedbackId, boolean isOver) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.duration = duration;
        this.bookedDate = bookedDate;
        this.trainerId = trainerId;
        this.customerId = customerId;
        this.feedbackId = feedbackId;
        this.isOver = isOver;
    }

    /**
     * Constructor for reading in
     * 
     * @param line
     */
    public Session(String[] line) {
        this.id = line[0];
        this.dateCreated = line[1];
        this.duration = Integer.parseInt(line[2]);
        this.bookedDate = line[3];
        this.trainerId = line[4];
        this.customerId = line[5];
        this.feedbackId = line[6];
        this.isOver = Boolean.parseBoolean(line[7]);
    }

    /**
     * Constructor to insert and update
     * 
     * @param inputs
     */
    public Session addSession(List<String> inputs) {
        Session session = new Session();

        session.id = UUID.randomUUID().toString();
        session.dateCreated = DateFormat.getDateInstance().format(LocalDate.now()).toString();
        session.duration = Integer.parseInt(inputs.get(1));
        session.bookedDate = inputs.get(2);
        session.trainerId = inputs.get(3);
        session.customerId = inputs.get(4);
        session.feedbackId = inputs.get(5);
        session.isOver = Boolean.parseBoolean(inputs.get(6));

        return session;
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
                        customerId, feedbackId, String.valueOf(isOver))));
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

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
    }

    public void setOver(boolean isOver) {
        this.isOver = isOver;
    }

}
