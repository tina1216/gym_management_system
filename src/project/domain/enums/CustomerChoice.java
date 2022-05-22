package project.domain.enums;

import java.util.Arrays;

// when customer loggedin
public enum CustomerChoice {

    VIEW_MY_PROFILE(1, "View my profile"),
    VIEW_MY_FEEDBACK(2, "View my feedback from trainer"),
    BACK_TO_MENU(5, "Back to Menu page");

    private int code;
    private String msg;

    private CustomerChoice(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    // -----------------------------------------------------------------

    public static CustomerChoice findByCode(int code) {
        return Arrays.stream(CustomerChoice.values()).filter(customerChoice -> customerChoice.getCode() == code)
                .findFirst().orElse(null);
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
