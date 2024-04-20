package fams.services.templates;

import fams.dto.request.forcreate.CTrainingContent;
import fams.dto.request.forcreate.CTrainingUnit;
import fams.entities.Syllabus;
import fams.entities.TrainingUnit;

public interface ITrainingUnitService {
    public TrainingUnit create(CTrainingUnit cTrainingUnit, Syllabus syllabus);

//    public TrainingUnit save(TrainingUnit trainingUnit,Syllabus syllabus);
}
