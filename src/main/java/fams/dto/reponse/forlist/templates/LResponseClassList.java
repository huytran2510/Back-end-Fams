package fams.dto.reponse.forlist.templates;

import fams.entities.User;
import fams.entities.enums.StatusClass;

import java.time.LocalDateTime;

public interface LResponseClassList {
    public String getClassName();
    public String getClassCode();
    public LocalDateTime getCreateDate();
    public User getCreatedBy();
    public StatusClass getStatus();
    public String getLocation();
    public String getFSU();
}
