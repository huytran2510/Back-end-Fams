package fams.entities;

import fams.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrainingProgram {
    @Id
    private String code;
    private String name;
    @ManyToOne
    private User user;
    private LocalDateTime startTime;
    private int duration;
    @OneToMany
    @JoinColumn(name = "topic_code")
    private Set<TrainingProgramSyllabus> trainingProgramSyllabusSet;

    @Enumerated(EnumType.STRING)
    private Status publishStatus;

    @OneToOne
    private User createdBy;
    private LocalDateTime createDate;
    @OneToOne
    private User modifiedBy;
    private LocalDateTime modifiedDate;
}
