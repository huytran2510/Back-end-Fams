package fams.controller;

import fams.dto.reponse.forlist.templates.LResponseSyllabusList;
import fams.dto.reponse.forlist.LResponseSyllabusListImpl;
import fams.dto.request.forcreate.CreateSyllabusRequest;
import fams.entities.Syllabus;
import fams.services.templates.ISyllabusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/syllabus")
public class SyllabusController {
    @Autowired
    private ISyllabusService syllabusService;
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Object> createSyllabus(@Valid @RequestBody CreateSyllabusRequest request) {
        Syllabus syllabus = syllabusService.create(request.getCSyllabus(), request.getCTrainingUnit());
        Map<String, Object> response = new HashMap<>();
        response.put("topicCode", syllabus.getTopicCode());
        response.put("topicName", syllabus.getTopicName());
        response.put("technicalGroup", syllabus.getTechnicalGroup());
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ResponseEntity<List<LResponseSyllabusList>> search(@Valid @RequestBody String keyword) {
        List<Syllabus> list = syllabusService.searchByKeyword(keyword);
        List<LResponseSyllabusList> responseList = list.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(responseList);
    }
    private LResponseSyllabusList convertToResponse(Syllabus syllabus) {
        return new LResponseSyllabusListImpl(syllabus.getTopicCode(), syllabus.getTopicName(), syllabus.getCreateDate(), syllabus.getCreatedBy().getId());
    }

}
