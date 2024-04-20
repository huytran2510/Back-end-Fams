package fams.services.templates;

import fams.dto.request.forcreate.CTrainingContent;
import fams.entities.TrainingContent;
import fams.entities.TrainingUnit;

public interface ITrainingContentService {
    public TrainingContent create(CTrainingContent cTrainingContent, TrainingUnit trainingUnit);

    public TrainingContent save(TrainingContent trainingContent);

}
