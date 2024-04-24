package fams.services;

import fams.entities.TrainingProgram;
import fams.repository.TrainingContentRepository;
import fams.repository.TrainingProgramRepository;
import fams.services.templates.ITrainingProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingProgramServiceImpl implements ITrainingProgramService {
    @Autowired
    private TrainingProgramRepository trainingProgramRepository;

    public List<TrainingProgram> list(){
        return trainingProgramRepository.findAll();
    }


}
