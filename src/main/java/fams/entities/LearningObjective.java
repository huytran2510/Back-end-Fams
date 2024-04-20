package fams.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LearningObjective {
    @Id
    private String code;
    private String name;
    private String type;
    private String description;
    @OneToMany
    private Set<SyllabusObjective> syllabusObjectives;
}
