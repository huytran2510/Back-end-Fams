package fams.services.templates;

import fams.dto.request.forcreate.CSyllabus;
import fams.dto.request.forcreate.CTrainingContent;
import fams.dto.request.forcreate.CTrainingUnit;
import fams.entities.Syllabus;

import java.util.List;

public interface ISyllabusService {
    public Syllabus create(CSyllabus cSyllabus, List<CTrainingUnit> cTrainingUnit);

    public List<Syllabus> searchByKeyword(String keyword);
}
