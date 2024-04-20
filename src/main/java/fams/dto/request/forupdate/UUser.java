package fams.dto.request.forupdate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UUser {
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

    private Long modifiedBy;

    private LocalDateTime modifiedDate;


}
