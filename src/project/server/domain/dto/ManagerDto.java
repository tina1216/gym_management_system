package project.server.domain.dto;

import project.server.domain.entity.Manager;
import project.server.domain.enums.AccountType;

import java.util.List;
import java.util.Map;

public class ManagerDto extends UserDto {

    private ManagerDto() {
        super();
    }

    public ManagerDto(Manager manager) {
        super(manager);
    }

    public static ManagerDto createManager(List<String> inputs) {
        ManagerDto dto = UserDto.createUser(inputs, AccountType.MANAGER, ManagerDto::new);
        new Manager(dto).save();
        return dto;
    }

    public Map<String, String> toMap() {
        return super.toMap();
    }
}
