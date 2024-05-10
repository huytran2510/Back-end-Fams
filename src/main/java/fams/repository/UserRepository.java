package fams.repository;

import fams.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);
    @Query("SELECT U FROM User U WHERE U.id = :id")
    User getUserById(@Param("id") Long id);

    @Query("SELECT u FROM User u JOIN u.userPermission")
    Page<User> getUserDetailsWithRole(Pageable pageable);

    Boolean existsByEmail(String username);

    User findUserById(Long id);

}
