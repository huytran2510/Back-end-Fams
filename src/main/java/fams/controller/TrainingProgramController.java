package fams.controller;


import fams.dto.reponse.forlist.LResponseSyllabusList;
import fams.dto.reponse.forlist.LResponseSyllabusListImpl;
import fams.dto.reponse.forlist.LResponseTrainingProgramList;
import fams.dto.reponse.forlist.LResponseTrainingProgramListImpl;
import fams.entities.Syllabus;
import fams.entities.TrainingProgram;
import fams.services.templates.ITrainingProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "trainingProgram")
public class TrainingProgramController {

    @Autowired
    private ITrainingProgramService iTrainingProgramService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ResponseEntity<List<LResponseTrainingProgramList>> list() {
        List<TrainingProgram> list = iTrainingProgramService.list();
        List<LResponseTrainingProgramList> responseList = list.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(responseList);
    }
    private LResponseTrainingProgramList convertToResponse(TrainingProgram trainingProgram) {
        return new LResponseTrainingProgramListImpl(trainingProgram.getCode(), trainingProgram.getName(), trainingProgram.getCreateDate(),trainingProgram.getDuration(), trainingProgram.getPublishStatus());
    }
}
