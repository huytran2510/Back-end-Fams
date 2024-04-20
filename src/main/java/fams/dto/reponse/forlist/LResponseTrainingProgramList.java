package fams.dto.reponse.forlist;

import fams.entities.enums.Status;

import java.time.LocalDateTime;

public interface LResponseTrainingProgramList {
    public String code();
    public String name();
    public LocalDateTime createDate();
    public int duration();
    public Status publishStatus();
}
