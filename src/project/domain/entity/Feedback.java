package project.domain.entity;

import java.time.*;
import java.util.*;
import java.text.DateFormat;

public class Feedback {

    Date currentDate = new Date();
    private String id;
    private String dateCreated;
    private String comment;
    private String trainerId;
    private String customerId;
    private String sessionId;

    public Feedback() {

    }

    public Feedback(String id, String dateCreated, String comment, String trainerId, String customerId,
            String sessionId) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.comment = comment;
        this.trainerId = trainerId;
        this.customerId = customerId;
        this.sessionId = sessionId;
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
        this.sessionId = line[5];
    }

    /**
     * Constructor to insert and update
     * 
     * @param inputs
     */
    public Feedback addFeedback(List<String> inputs) {
        Feedback feedback = new Feedback();

        feedback.id = UUID.randomUUID().toString();
        feedback.dateCreated = DateFormat.getDateInstance().format(LocalDate.now()).toString();
        feedback.comment = inputs.get(0);
        feedback.trainerId = inputs.get(1);
        feedback.customerId = inputs.get(2);
        feedback.sessionId = inputs.get(3);

        return feedback;
    }

    // -------------------------------------------------------------------------------

    public List<String> writeData() {
        List<String> data = new ArrayList<String>();

        data.addAll(new ArrayList<String>(
                Arrays.asList(String.valueOf(id), dateCreated, comment, trainerId, customerId, sessionId)));
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

    public String getSessiongId() {
        return sessionId;
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

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

}
