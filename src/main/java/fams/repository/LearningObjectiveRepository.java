package fams.repository;

import fams.entities.LearningObjective;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LearningObjectiveRepository extends JpaRepository<LearningObjective,Long> {
    LearningObjective findByCode(String code);
}
