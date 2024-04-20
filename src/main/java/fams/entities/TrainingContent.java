package fams.entities;

import fams.entities.enums.DeliveryType;
import fams.entities.enums.TrainingFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrainingContent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "unit_code")
    private TrainingUnit trainingUnit;

    private String content;

    @OneToOne
    private LearningObjective learningObjective;

    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryType;

    private int duration;

    @Enumerated(EnumType.STRING)
    private TrainingFormat trainingFormat;

    private String note;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "syllabus")
    private Set<TrainingMaterials> trainingMaterials;
}
