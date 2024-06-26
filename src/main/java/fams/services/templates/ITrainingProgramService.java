package fams.services.templates;

import fams.dto.request.forcreate.CTrainingProgram;
import fams.entities.TrainingProgram;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;


public interface ITrainingProgramService {

    public Page<TrainingProgram> list(int page, int size);

    public TrainingProgram create(CTrainingProgram cTrainingProgram);
}
