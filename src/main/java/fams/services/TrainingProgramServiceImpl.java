package fams.services;

import fams.dto.request.forcreate.CTrainingProgram;
import fams.entities.Syllabus;
import fams.entities.TrainingProgram;
import fams.entities.TrainingProgramSyllabus;
import fams.entities.User;
import fams.repository.TrainingProgramRepository;
import fams.repository.UserRepository;
import fams.services.templates.ITrainingProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrainingProgramServiceImpl implements ITrainingProgramService {
    @Autowired
    private TrainingProgramRepository trainingProgramRepository;

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private TrainingProgramSyllabusRepository trainingProgramSyllabusRepository;
    public Page<TrainingProgram> list(int page, int size) {
        return trainingProgramRepository.findAll(PageRequest.of(page, size));
    }


    /**
     * Creates a new TrainingProgram based on the provided CTrainingProgram object.
     *
     * @param cTrainingProgram
     * @return The created TrainingProgram object.
     */
    public TrainingProgram create(CTrainingProgram cTrainingProgram){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        System.out.println(email);
        User user = userRepository.getUserById(cTrainingProgram.getIdUser());
        User userCreated = userRepository.findByEmail(email);
        TrainingProgram trainingProgram = new TrainingProgram();
        trainingProgram.setCode(cTrainingProgram.getCode());
        trainingProgram.setName(cTrainingProgram.getName());
        trainingProgram.setDuration(cTrainingProgram.getDuration());
        trainingProgram.setStartTime(cTrainingProgram.getStartTime());
        trainingProgram.setUser(user);
        trainingProgram.setCreateDate(LocalDateTime.now());
        trainingProgram.setCreatedBy(userCreated);
        trainingProgram.setPublishStatus(cTrainingProgram.getPublishStatus());
        trainingProgram.setModifiedDate(LocalDateTime.now());
        trainingProgram.setModifiedBy(userCreated);

        TrainingProgramSyllabus trainingProgramSyllabus = new TrainingProgramSyllabus();
        List<Syllabus> syllabusList = cTrainingProgram.getSyllabusList();
        for(Syllabus syllabus : syllabusList) {
            trainingProgramSyllabus.setTrainingProgram(trainingProgram);
            trainingProgramSyllabus.setSyllabus(syllabus);
        }

        return trainingProgram;
    }
}
