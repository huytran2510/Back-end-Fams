package fams.dto.request.forcreate;

import fams.entities.Syllabus;
import fams.entities.TrainingProgramSyllabus;
import fams.entities.User;
import fams.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CTrainingProgram {
    private String code;
    private String name;
    private Long idUser;
    private LocalDateTime startTime;
    private int duration;
    private Status publishStatus;
    private User createdBy;
    private LocalDateTime createDate;
    private User modifiedBy;
    private LocalDateTime modifiedDate;
    private List<Syllabus> syllabusList;


}
