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
public class CSyllabus {
    private String topicCode;
    private String topicName;
    private String level;
    private int trainingAudience;
    private String technicalGroup;
    private String version;
}
