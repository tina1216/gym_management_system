package project.server.domain.dto;

import project.server.domain.entity.User;
import project.server.domain.enums.AccountType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class UserDto {
    protected String id;
    protected String username;
    protected String password;
    protected String fullName;
    protected String gender;
    protected String phoneNumber;
    protected String email;
    protected AccountType accountType;

    protected UserDto() {
    }

    protected UserDto(User user) {
        id = user.getId();
        username = user.getUsername();
        password = user.getPassword();
        fullName = user.getFullName();
        gender = user.getGender();
        phoneNumber = user.getPhoneNumber();
        email = user.getEmail();
        accountType = AccountType.fromCode(user.getAccountType());
    }

    public static List<UserDto> getAllUser() {
        return User.getAllUser().stream().map(UserDto::new).collect(Collectors.toList());
    }

    protected static <T extends UserDto> T createUser(List<String> inputs, AccountType accountType, Supplier<? extends T> t) {
        T dto = t.get();
        dto.id = UUID.randomUUID().toString();
        dto.username = inputs.get(0);
        dto.password = inputs.get(1);
        dto.fullName = inputs.get(2);
        dto.gender = inputs.get(3);
        dto.phoneNumber = inputs.get(4);
        dto.email = inputs.get(5);
        dto.accountType = accountType;
        return dto;
    }

    public UserDto getUserById(String id) {
        return getAllUser().stream().filter(dto -> dto.getId().equals(id)).findFirst().orElse(null);
    }

    protected Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("id", this.getId());
        map.put("username", this.getUsername());
        map.put("fullName", this.getFullName());
        map.put("gender", this.getGender());
        map.put("phoneNumber", this.getPhoneNumber());
        map.put("email", this.getEmail());
        map.put("accountType", this.getAccountType().getCode());
        return map;
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

    public AccountType getAccountType() {
        return accountType;
    }
}
