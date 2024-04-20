package fams.repository;

import fams.entities.Syllabus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface SyllabusRepository extends JpaRepository<Syllabus,Long> {

//    @Modifying
//    @Query("select S From Syllabus s join " +
//            "TrainingProgramSyllabus tps on s.topicCode = tps.syllabus.topicCode join" +
//            " TrainingProgram tp on tps.trainingProgram.code = tp.code")

    @Query("SELECT s FROM Syllabus s WHERE DATE(s.createDate) = DATE(:createDate) ")
    List<Syllabus> findSyllabusByCreateDate(@Param("createDate") Date createDate);

    @Query("SELECT s FROM Syllabus s WHERE s.topicCode = :keyword OR s.topicName =:keyword OR (DATE(s.createDate) = DATE(:keyword))")
    List<Syllabus> findByKeyword(@Param("keyword") String keyword );
}
