package project.server.domain.entity;

import project.server.domain.dto.ManagerDto;

public class Manager extends User {

    public Manager(User user) {
        super(user.getId(), user.getUsername(), user.getPassword(), user.getFullName(), user.getGender(), user.getPhoneNumber(), user.getEmail(), user.getAccountType());
    }

    public Manager(ManagerDto dto) {
        super(dto);
    }

    public void save() {
        super.save();
    }
}
