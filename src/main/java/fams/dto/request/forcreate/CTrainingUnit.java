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
public class CTrainingUnit {
    private String unitCode;

    private String unitName;

    private int dayNumber;
    private List<CTrainingContent> trainingContentList;
}
