package project.server.domain.dto;

import project.server.domain.entity.Trainer;
import project.server.domain.enums.AccountType;

import java.util.List;
import java.util.Map;

public class TrainerDto extends UserDto {

    private String level;

    private TrainerDto() {
        super();
    }

    public TrainerDto(Trainer trainer) {
        super(trainer);
        this.level = trainer.getLevel();
    }

    public static TrainerDto createTrainer(List<String> inputs) {
        TrainerDto dto = UserDto.createUser(inputs, AccountType.TRAINER, TrainerDto::new);
        dto.setLevel(inputs.get(6));
        new Trainer(dto).save();
        return dto;
    }

    @Override
    public Map<String, String> toMap() {
        return super.toMap();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
