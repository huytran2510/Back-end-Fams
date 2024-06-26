package fams.controller;


import fams.dto.reponse.forlist.*;
import fams.dto.reponse.forlist.templates.LResponseClassList;
import fams.dto.reponse.forlist.templates.LResponseTrainingProgramList;
import fams.dto.reponse.forlist.templates.LResponseUserPermission;
import fams.entities.TrainingProgram;
import fams.services.templates.ICLassService;
import fams.services.templates.ITrainingProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/api/trainingProgram")
@CrossOrigin(origins = "http://localhost:3000")
public class TrainingProgramController {

    @Autowired
    private ITrainingProgramService iTrainingProgramService;

    @Autowired
    private ICLassService icLassService;
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<Page<LResponseTrainingProgramList>> list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<TrainingProgram> trainingProgramPage = iTrainingProgramService.list(page, size);
        Page<LResponseTrainingProgramList> responseList = trainingProgramPage.map(this::convertToResponse);
        return ResponseEntity.ok().body(responseList);
    }

    private LResponseTrainingProgramList convertToResponse(TrainingProgram trainingProgram) {
        String createdBy = trainingProgram.getCreatedBy() != null ? trainingProgram.getCreatedBy().getName() : null;

        return new LResponseTrainingProgramListImpl(trainingProgram.getCode(), trainingProgram.getName(), trainingProgram.getCreateDate(),trainingProgram.getDuration(), trainingProgram.getPublishStatus(), createdBy );
    }

    @RequestMapping(value = "/list-class", method = RequestMethod.POST)
    public ResponseEntity<List<LResponseClassList>> getAllUserPermission(@Valid @RequestBody String code) throws Exception {
        List<LResponseClassList> list = icLassService.list(code);
        return ResponseEntity.ok().body(list);
    }


}
