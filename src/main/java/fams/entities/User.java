package fams.entities;

import fams.entities.enums.Gender;
import fams.entities.enums.UserStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private Date dob;

    @Column
    private String phone;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_permission_id", referencedColumnName = "id")
    private UserPermission userPermission;

    @Column
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @OneToOne
    private User createBy;

    @Column
    private LocalDateTime createdDate;

    @OneToOne
    private User modifiedBy;

    @Column
    private LocalDateTime modifiedDate;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", gender=" + gender +
                ", userPermission=" + userPermission +
                '}';
    }
}
