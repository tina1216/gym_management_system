package project.server.domain.enums;

import java.util.Arrays;

public enum AccountType {

    MANAGER("M"),
    TRAINER("T"),
    CUSTOMER("C");

    private final String code;

    AccountType(String code) {
        this.code = code;
    }

    public static AccountType fromCode(String code) {
        return Arrays.stream(AccountType.values()).filter(accoutType -> accoutType.getCode().equals(code))
                .findFirst().orElse(null);
    }

    public String getCode() {
        return code;
    }
}
