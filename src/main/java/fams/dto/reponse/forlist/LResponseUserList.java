package fams.dto.reponse.forlist;

import fams.entities.enums.ERole;
import fams.entities.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


public interface LResponseUserList {
    public Long getId();

    public String getName();

    public String getEmail();

    public LocalDate getDob();

    public String getGender();

}
