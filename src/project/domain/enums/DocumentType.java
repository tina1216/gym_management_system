package project.domain.enums;

import java.util.Arrays;

public enum DocumentType {

    BOOKING("B"),
    FEEDBACK("F");

    private String docType;

    private DocumentType(String docType) {
        this.docType = docType;
    }

    public static AccountType fromRole(String docType) {
        return Arrays.stream(AccountType.values()).filter(accoutType -> accoutType.getRole().equals(docType))
                .findFirst().orElse(null);
    }

    public String getDocType() {
        return docType;
    }

}