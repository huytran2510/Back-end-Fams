package fams.services;

import fams.dto.request.forcreate.CTrainingContent;
import fams.dto.request.forcreate.CTrainingUnit;
import fams.entities.Syllabus;
import fams.entities.TrainingContent;
import fams.entities.TrainingUnit;
import fams.repository.TrainingUnitRepository;
import fams.services.templates.ITrainingContentService;
import fams.services.templates.ITrainingUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TrainingUnitServiceImpl implements ITrainingUnitService {
    @Autowired
    private TrainingUnitRepository trainingUnitRepository;

//    @Autowired
//    private ITrainingContentService trainingContentService;

    @Override
    public TrainingUnit create(CTrainingUnit cTrainingUnit, Syllabus syllabus) {
        TrainingUnit trainingUnit = new TrainingUnit();
        trainingUnit.setUnitName(cTrainingUnit.getUnitName());
        trainingUnit.setUnitCode(cTrainingUnit.getUnitCode());
        trainingUnit.setDayNumber(cTrainingUnit.getDayNumber());
        trainingUnit.setSyllabus(syllabus);
        // Save the TrainingUnit
        return trainingUnitRepository.save(trainingUnit);
    }

}
