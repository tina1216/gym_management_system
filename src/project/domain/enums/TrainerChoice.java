package project.domain.enums;

import java.util.Arrays;

// when trainer loggedin
public enum TrainerChoice {

    UPDATE_CUSTOMER_PROFILE(1, "Update customer's profile"),
    LIST_BOOKING(2, "List down all booking"),
    UPDATE_BOOKING(3, "Update booking"),
    DELETE_BOOKING(4, "Delete booking"),
    CREATE_FEEDBACK(5, "Create feedback for customer"),
    LOGOUT(0, "Logout");

    private int code;
    private String msg;

    private TrainerChoice(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    // -----------------------------------------------------------------

    public static TrainerChoice findByCode(int code) {
        return Arrays.stream(TrainerChoice.values()).filter(trainerChoice -> trainerChoice.getCode() == code)
                .findFirst().orElse(null);
    }

    public int getCode() {
        return code;
    }

    /**
     * getMsg
     * 
     * @return display message
     */
    public String getMsg() {
        return msg;
    }

}

/**
 * System.out.println("Individual appointment management");
 * int t1 = scanner.nextInt();
 * 
 * if (t1 == 1) {
 * // create appointment
 * break;
 * } else if (t1 == 2) {
 * // view appointments
 * break;
 * } else if (t1 == 3) {
 * // update appointment
 * break;
 * } else if (t1 == 4) {
 * // delete appointment
 * break;
 * } else if (t1 == 5) {
 * // search appointment
 * } else {
 * System.out.println("Back to Trainer Menu page");
 * }
 */
