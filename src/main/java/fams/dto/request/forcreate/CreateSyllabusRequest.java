package fams.dto.request.forcreate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateSyllabusRequest {
    private CSyllabus cSyllabus;
    private List<CTrainingUnit> cTrainingUnit;

    public List<CTrainingUnit> getCTrainingUnit() {
        return cTrainingUnit;
    }
}
