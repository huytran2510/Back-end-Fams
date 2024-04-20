package fams.entities;

import fams.entities.enums.SyllabusPublishStatus;
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
public class Syllabus {
    @Id
    private String topicCode;
    @Column(unique = true)
    private String topicName;
    private String technicalGroup;
    private String version;
    private String level;

    // số học viên
    private int trainingAudience;
    private String topicOutline;
    private String trainingMaterials;
    private String trainingPrinciples;
    private String priority;
    @Enumerated(EnumType.STRING)
    private SyllabusPublishStatus publishStatus;
    @OneToOne
    private User createdBy;
    private LocalDateTime createDate;
    @OneToOne
    private User modifiedBy;
    private LocalDateTime modifiedDate;
    @OneToMany(mappedBy = "syllabus")
    private Set<TrainingProgramSyllabus> trainingProgramSyllabusSet;
    @OneToMany(mappedBy = "syllabus")
    private Set<SyllabusObjective> syllabusObjectives;
    @OneToMany(mappedBy = "syllabus")
    private Set<TrainingUnit> trainingUnits;
}
