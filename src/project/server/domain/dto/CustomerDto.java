package project.server.domain.dto;

import project.server.domain.entity.Customer;
import project.server.domain.enums.AccountType;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class CustomerDto extends UserDto {

    private LocalDate joinedDate;
    private String weight;
    private String height;
    private boolean isPaid;

    private CustomerDto() {
        super();
    }

    public CustomerDto(Customer customer) {
        super(customer);
        this.joinedDate = LocalDate.parse(customer.getJoinedDate());
        this.weight = customer.getWeight();
        this.height = customer.getHeight();
        this.isPaid = Boolean.parseBoolean(customer.getIsPaid());
    }

    public static CustomerDto createCustomer(List<String> inputs) {
        CustomerDto dto = UserDto.createUser(inputs, AccountType.TRAINER, CustomerDto::new);
        dto.setJoinedDate(LocalDate.now());
        dto.setWeight(inputs.get(6));
        dto.setHeight(inputs.get(7));
        dto.setIsPaid(Boolean.parseBoolean(inputs.get(8)));
        new Customer(dto).save();
        return dto;
    }

    public Map<String, String> toMap() {
        return super.toMap();
    }

    public LocalDate getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(LocalDate joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

}
