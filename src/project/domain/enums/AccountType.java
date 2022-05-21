package project.domain.enums;

import java.util.Arrays;

public enum AccountType {

    MANAGER("M"),
    TRAINER("T"),
    CUSTOMER("C");

    private String role;

    private AccountType(String role) {
        this.role = role;
    }

    public static AccountType fromRole(String role) {
        return Arrays.stream(AccountType.values()).filter(accoutType -> accoutType.getRole().equals(role))
                .findFirst().orElse(null);
    }

    public String getRole() {
        return role;
    }

}
