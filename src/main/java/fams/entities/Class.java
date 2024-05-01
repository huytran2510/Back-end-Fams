package fams.entities;

import fams.entities.enums.StatusClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private TrainingProgram trainingProgram;
    @Column(unique = true)
    private String className;
    @Column(unique = true)
    private String classCode;
    private int duration;
    @Enumerated(EnumType.STRING)
    private StatusClass status;
    private String location;
    private String FSU;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @OneToOne
    private User createdBy;
    private LocalDateTime createDate;
    @OneToOne
    private User modifiedBy;
    private LocalDateTime modifiedDate;

    @OneToOne
    private ClassUser classUsers;
}
