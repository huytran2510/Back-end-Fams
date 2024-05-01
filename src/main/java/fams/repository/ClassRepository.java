package fams.repository;

import fams.dto.reponse.forlist.templates.LResponseClassList;
import fams.entities.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<Class,Long> {
    @Query("select c from Class c where c.trainingProgram.code =: code")
    List<LResponseClassList> findAllByIdProgram(@Param("code") String code);
}
