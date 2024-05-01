package fams.dto.reponse.forlist;


import fams.dto.reponse.forlist.templates.LResponseUserList;
import fams.entities.enums.ERole;
import fams.entities.enums.Gender;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class LResponseUserListImpl implements LResponseUserList {
    private Long id;
    private String name;
    private String email;
    private Date dob;
    private Gender gender;
    private ERole role;

    public LResponseUserListImpl(Long id, String name, String email, Date dob, Gender gender, ERole role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
        this.role = role;
    }
}
