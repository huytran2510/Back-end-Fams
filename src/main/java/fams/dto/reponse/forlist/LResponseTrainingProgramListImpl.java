package fams.dto.reponse.forlist;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fams.dto.reponse.forlist.templates.LResponseTrainingProgramList;
import fams.entities.enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@JsonSerialize
@JsonDeserialize
@Getter
@Setter
public class LResponseTrainingProgramListImpl implements LResponseTrainingProgramList {
    private final String code;
    private final String name;
    private final LocalDateTime createDate;
    private final int duration;
    private final Status publishStatus;
    private final String nameUser;

    public LResponseTrainingProgramListImpl(String code, String name, LocalDateTime createDate, int duration, Status publishStatus, String nameUser) {
        this.code = code;
        this.name = name;
        this.createDate = createDate;
        this.duration = duration;
        this.publishStatus = publishStatus;
        this.nameUser = nameUser;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public LocalDateTime createDate() {
        return createDate;
    }

    @Override
    public int duration() {
        return duration;
    }

    @Override
    public Status publishStatus() {
        return publishStatus;
    }

    @Override
    public String nameUser() {
        return nameUser;
    }
}
