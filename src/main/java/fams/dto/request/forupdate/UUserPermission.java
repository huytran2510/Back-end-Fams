package fams.dto.request.forupdate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UUserPermission {
    public Long id;

    public String syllabus;

    public String learningMaterial;

    public String classes;

    public String trainingProgram;

    public String userManagement;
}
