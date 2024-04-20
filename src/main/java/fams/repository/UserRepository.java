package fams.repository;

import fams.dto.reponse.forlist.LResponseUserList;
import fams.entities.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);
    @Query("SELECT U FROM User U WHERE U.id = :id")
    User getUserById(@Param("id") Long id);

    @Query("SELECT u.id, u.name, u.email, u.dob, u.gender, u.userPermission.role FROM User u")
    Page<LResponseUserList> getUserDetailsWithRole(Pageable pageable);
}
