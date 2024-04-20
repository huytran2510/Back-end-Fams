package fams.services;


import fams.dto.request.forcreate.CSyllabus;
import fams.dto.request.forcreate.CTrainingContent;
import fams.dto.request.forcreate.CTrainingUnit;
import fams.entities.Syllabus;
import fams.entities.TrainingContent;
import fams.entities.TrainingUnit;
import fams.repository.SyllabusRepository;
import fams.services.templates.ISyllabusService;
import fams.services.templates.ITrainingContentService;
import fams.services.templates.ITrainingUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SyllabusServiceImpl implements ISyllabusService {
    @Autowired
    private SyllabusRepository syllabusRepository;

    @Autowired
    private ITrainingContentService iTrainingContentService;

    @Autowired
    private ITrainingUnitService iTrainingUnitService;

    @Override
    public Syllabus create(CSyllabus cSyllabus, List<CTrainingUnit> cTrainingUnits) {
        Syllabus syllabus = new Syllabus();
        syllabus.setCreateDate(LocalDateTime.now());
        syllabus.setTopicCode(cSyllabus.getTopicCode());
        syllabus.setTechnicalGroup(cSyllabus.getTechnicalGroup());
        syllabus.setTopicName(cSyllabus.getTopicName());
        syllabus.setTrainingAudience(cSyllabus.getTrainingAudience());
        syllabus.setLevel(cSyllabus.getLevel());
        syllabus.setVersion("1.0.0");
        syllabus = syllabusRepository.save(syllabus);

        Set<TrainingUnit> trainingUnits = new HashSet<>();
        for (CTrainingUnit cTrainingUnit : cTrainingUnits) {
            TrainingUnit trainingUnit = iTrainingUnitService.create(cTrainingUnit, syllabus);
            trainingUnits.add(trainingUnit);

            Set<TrainingContent> trainingContents = new HashSet<>();
            for (CTrainingContent cTrainingContent : cTrainingUnit.getTrainingContentList()) {
                TrainingContent trainingContent = iTrainingContentService.create(cTrainingContent,trainingUnit);
                trainingContents.add(trainingContent);
            }
        }

        syllabus.setTrainingUnits(trainingUnits);

        return syllabus;
    }
    public List<Syllabus> searchByKeyword(String keyword) {
        return syllabusRepository.findByKeyword(keyword);
    }

}
