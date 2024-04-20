package fams.entities;

import fams.entities.enums.EPermission;
import fams.entities.enums.ERole;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class UserPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ERole role;

    @Enumerated(EnumType.STRING)
    private EPermission syllabus;

    @Enumerated(EnumType.STRING)
    private EPermission trainingProgram;
    @Enumerated(EnumType.STRING)
    private EPermission classes;
    @Enumerated(EnumType.STRING)
    private EPermission learningMaterial;
    @Enumerated(EnumType.STRING)
    private EPermission userManagement;
    @OneToMany(mappedBy = "userPermission")
    private Set<User> users;

    public UserPermission(ERole eRole) {
        this.role = eRole;
    }

}
