package fams.dto.request.forcreate;

import fams.entities.User;
import fams.entities.UserPermission;
import fams.entities.enums.ERole;
import fams.entities.enums.Gender;
import fams.entities.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CUser {

    @NotEmpty(message = "This field is required")
    private String name;

    @Email(message = "Invalid Email")
    @NotEmpty(message = "This field is required")
    private String email;

    @NotEmpty(message = "This field is required")
    private String phone;

    private Date dob;

    private String gender;

    private String role;

    private String status;

    private Long createdBy;

    private LocalDateTime createDate;
}
