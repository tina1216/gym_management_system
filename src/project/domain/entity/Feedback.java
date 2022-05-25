package project.domain.entity;

import java.time.*;
import java.util.*;

import project.Context;

public class Feedback {

    Date currentDate = new Date();

    private String id;
    private String dateCreated;
    private String comment;
    private String trainerId;
    private String customerId;

    public Feedback() {

    }

    public Feedback(String id, String dateCreated, String comment, String trainerId, String customerId) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.comment = comment;
        this.trainerId = trainerId;
        this.customerId = customerId;

    }

    /**
     * Constructor to read in
     * 
     * @param line
     */
    public Feedback(String[] line) {
        this.id = line[0];
        this.dateCreated = line[1];
        this.comment = line[2];
        this.trainerId = line[3];
        this.customerId = line[4];
    }

    public Feedback(List<String> input) {
        this.id = input.get(0);
        this.dateCreated = input.get(1);
        this.comment = input.get(2);
        this.trainerId = input.get(3);
        this.customerId = input.get(4);
    }

    /**
     * Constructor to create feedback
     * 
     * @param inputs
     */
    public Feedback addFeedback(List<String> inputs) {
        Feedback feedback = new Feedback();

        feedback.id = UUID.randomUUID().toString();
        feedback.dateCreated = LocalDate.now().toString();
        feedback.comment = inputs.get(0);
        feedback.trainerId = Context.getInstance().getCurrentUserId();
        feedback.customerId = inputs.get(1);

        return feedback;
    }

    // -------------------------------------------------------------------------------

    public List<String> writeData() {
        List<String> data = new ArrayList<String>();

        data.addAll(new ArrayList<String>(
                Arrays.asList(String.valueOf(id), String.valueOf(dateCreated), comment, trainerId, customerId)));
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
        return trainerId = Context.getInstance().getCurrentUserId();
    }

    public String getCustomerId() {
        // Context.getInstance().getCustomer() して、
        // filter で id 検索かけて（findByCode）して
        // return は Customer
        return customerId;
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

}
