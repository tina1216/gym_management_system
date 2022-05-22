package project.server.domain.entity;

import project.server.domain.dto.UserDto;
import project.server.util.FileUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    private final static String USER_FILE_PATH = "src/resources/user.txt";

    protected String id;
    protected String username;
    protected String password;
    protected String fullName;
    protected String gender;
    protected String phoneNumber;
    protected String email;
    protected String accountType;

    public User() {

    }

    protected User(String id, String username, String password, String fullName, String gender, String phoneNumber,
                   String email, String accountType) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.accountType = accountType;
    }

    public User(UserDto dto) {
        this.id = dto.getId();
        this.username = dto.getUsername();
        this.password = dto.getPassword();
        this.fullName = dto.getFullName();
        this.gender = dto.getGender();
        this.phoneNumber = dto.getPhoneNumber();
        this.email = dto.getEmail();
        this.accountType = dto.getAccountType().getCode();
    }

    private static User fromRawData(List<String> rows) {
        User user = new User();
        user.id = rows.get(0);
        user.username = rows.get(1);
        user.password = rows.get(2);
        user.fullName = rows.get(3);
        user.gender = rows.get(4);
        user.phoneNumber = rows.get(5);
        user.email = rows.get(6);
        user.accountType = rows.get(7);
        return user;
    }

    public static List<User> getAllUser() {
        return FileUtils.scanFile(USER_FILE_PATH).stream().map(User::fromRawData).collect(Collectors.toList());
    }

    private List<String> toRawData() {
        List<String> rowData = new ArrayList<>();
        rowData.add(this.getId());
        rowData.add(this.getUsername());
        rowData.add(this.getPassword());
        rowData.add(this.getFullName());
        rowData.add(this.getGender());
        rowData.add(this.getPhoneNumber());
        rowData.add(this.getEmail());
        rowData.add(this.getAccountType());
        return rowData;
    }

    protected void save() {
        FileUtils.insert(USER_FILE_PATH, this.toRawData());
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAccountType() {
        return accountType;
    }
}
