package fams.dto.reponse.forlist.templates;

import fams.entities.enums.ERole;
import fams.entities.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.util.Date;


public interface LResponseUserList {
    public Long getId();

    public String getName();

    public String getEmail();

    public Date getDob();

    public Gender getGender();
    public ERole getRole();
}
