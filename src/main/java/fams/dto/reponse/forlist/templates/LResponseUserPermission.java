package fams.dto.reponse.forlist.templates;

import fams.entities.enums.EPermission;

public interface LResponseUserPermission {
    public Long getId();
    public String getUserManagement();
    public String getRole();

    public String getSyllabus();

    public String getLearningMaterial();

    public String getClasses();

    public String getTrainingProgram();

}
