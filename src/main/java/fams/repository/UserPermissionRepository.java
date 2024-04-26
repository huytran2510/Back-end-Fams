package fams.repository;

import fams.dto.reponse.forlist.LResponseUserPermission;
import fams.entities.UserPermission;
import fams.entities.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserPermissionRepository extends JpaRepository<UserPermission,Long> {
    @Query("SELECT us FROM UserPermission us WHERE us.role = :role")
    UserPermission findByRole(@Param("role") ERole role);

    @Modifying
    @Query("update UserPermission us set us.syllabus = :syllabus, us.classes = :classes, us.trainingProgram = :trainingProgram, us.learningMaterial = :learningMaterial where us.id = :id")
    UserPermission updateUserPermissionsById(@Param("syllabus") String syllabus,
                                             @Param("classes") String classes,
                                             @Param("trainingProgram") String trainingProgram,
                                             @Param("learningMaterial") String learningMaterial,
                                             @Param("id") Long id);


    @Query("select up from UserPermission up")
    public List<LResponseUserPermission> findAllBy();


    Optional<UserPermission> findAllByRole(ERole role);
}
