package project.server.domain.entity;

import project.server.domain.dto.CustomerDto;
import project.server.util.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {

    private final static String CUSTOMER_FILE_PATH = "src/resources/customer.txt";

    private final String joinedDate;
    private final String weight;
    private final String height;
    private final String isPaid;

    public Customer(User user, String joinedDate, String weight, String height, String isPaid) {
        super(user.getId(), user.getUsername(), user.getPassword(), user.getFullName(), user.getGender(), user.getPhoneNumber(), user.getEmail(), user.getAccountType());
        this.joinedDate = joinedDate;
        this.weight = weight;
        this.height = height;
        this.isPaid = isPaid;
    }

    public Customer(CustomerDto dto) {
        super(dto);
        this.joinedDate = dto.getJoinedDate().toString();
        this.weight = dto.getWeight();
        this.height = dto.getHeight();
        this.isPaid = String.valueOf(dto.getIsPaid());
    }

    public void save() {
        super.save();
        FileUtils.insert(CUSTOMER_FILE_PATH, toRawData());
    }

    public List<String> toRawData() {
        List<String> rawData = new ArrayList<>();
        rawData.add(this.getId());
        rawData.add(this.getJoinedDate());
        rawData.add(this.getWeight());
        rawData.add(this.getHeight());
        rawData.add(this.getIsPaid());
        return rawData;
    }

    public String getJoinedDate() {
        return joinedDate;
    }

    public String getWeight() {
        return weight;
    }

    public String getHeight() {
        return height;
    }

    public String getIsPaid() {
        return isPaid;
    }
}
