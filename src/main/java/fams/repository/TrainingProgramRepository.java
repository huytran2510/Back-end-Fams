package fams.repository;

import fams.entities.TrainingProgram;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingProgramRepository extends JpaRepository<TrainingProgram,Long> {


    Page<TrainingProgram> findAll(Pageable pageable);

    List<TrainingProgram> findAllBy();

}
