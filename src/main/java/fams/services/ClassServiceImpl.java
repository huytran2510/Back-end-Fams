package fams.services;

import fams.dto.reponse.forlist.templates.LResponseClassList;
import fams.repository.ClassRepository;
import fams.services.templates.ICLassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ICLassService {
    @Autowired
    private ClassRepository classRepository;

    public List<LResponseClassList> list(String code){
        return classRepository.findAllByIdProgram(code);
    }

}
