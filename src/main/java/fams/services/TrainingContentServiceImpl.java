package fams.services;

import fams.dto.request.forcreate.CTrainingContent;
import fams.entities.LearningObjective;
import fams.entities.TrainingContent;
import fams.entities.TrainingUnit;
import fams.entities.enums.DeliveryType;
import fams.repository.LearningObjectiveRepository;
import fams.repository.TrainingContentRepository;
import fams.services.templates.ITrainingContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingContentServiceImpl implements ITrainingContentService {
    @Autowired
    private TrainingContentRepository trainingContentRepository;

    @Autowired
    private LearningObjectiveRepository learningObjectiveRepository;

    @Override
    public TrainingContent create(CTrainingContent cTrainingContent, TrainingUnit trainingUnit) {
        TrainingContent trainingContent = new TrainingContent();
        trainingContent.setContent(cTrainingContent.getContent());
        trainingContent.setDeliveryType(DeliveryType.valueOf(cTrainingContent.getDeliveryType()));
        trainingContent.setDuration(cTrainingContent.getDuration());
//        LearningObjective learningObjective = learningObjectiveRepository.findByCode(cTrainingContent.getLearningObjective());
//        trainingContent.setLearningObjective(learningObjective);
        trainingContent.setTrainingUnit(trainingUnit);
        return trainingContentRepository.save(trainingContent);
    }

    @Override
    public TrainingContent save(TrainingContent trainingContent){
        return trainingContentRepository.save(trainingContent);
    }
}
