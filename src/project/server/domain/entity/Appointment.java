//package project.server.domain.entity;
//
//import java.time.LocalDate;
//
//public class Appointment {
//
//    private String id;
//    private LocalDate dateAdded;
//    private int duration;
//    private String bookedDate;
//    private String trainerId;
//    private String customerId;
//
//    public Appointment() {
//
//    }
//
//    public Appointment(String id, LocalDate dateAdded, int duration, String bookedDate, String trainerId,
//                       String customerId) {
//        this.id = id;
//        this.dateAdded = dateAdded;
//        this.duration = duration;
//        this.bookedDate = bookedDate;
//        this.trainerId = trainerId;
//        this.customerId = customerId;
////        this.thisFeedback = new ArrayList<Feedback>();
//    }
//
//    // -------------------------------------------------------------------------------
//
//    /**
//     * LocalDateTime myDateObj = LocalDateTime.now();
//     * System.out.println("Before Formatting: " + myDateObj);
//     * DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy
//     * HH:mm:ss");
//     * <p>
//     * String formattedDate = myDateObj.format(myFormatObj);
//     * System.out.println("After Formatting: " + formattedDate);
//     */
//
//    // getters & setters
//    // -------------------------------------------------------------
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public LocalDate getDateAdded() {
//        return dateAdded;
//    }
//
//    public void setDateAdded(LocalDate dateAdded) {
//        this.dateAdded = dateAdded;
//    }
//
//    public int getDuration() {
//        return duration;
//    }
//
//    public void setDuration(int duration) {
//        this.duration = duration;
//    }
//
////    public ArrayList<Feedback> getThisFeedback() {
////        return thisFeedback;
////    }
//
//    public String getBookedDate() {
//        return bookedDate;
//    }
//
//    public void setBookedDate(String bookedDate) {
//        this.bookedDate = bookedDate;
//    }
//
//    public Trainer getTrainer() {
//        return Trainer.findById(trainerId);
//    }
//
//    public Customer getCustomer() {
//        return Customer.findById(customerId);
//    }
//
//    public void setTrainerId(Trainer trainer) {
//        this.trainerId = trainer.getId();
//    }
//
//    public void setCustomerId(Customer customer) {
//        this.customerId = customer.getId();
//    }
//
////    public void setThisFeedback(ArrayList<Feedback> thisFeedback) {
////        this.thisFeedback = thisFeedback;
////    }
//
//}
