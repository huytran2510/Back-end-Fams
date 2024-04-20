package fams.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClassUser implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


    @Id
    @OneToOne
    @JoinColumn(name = "class_id")
    private Class classId;

    private String userType;
}
