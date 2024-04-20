package fams.dto.request.forcreate;

import fams.entities.LearningObjective;
import fams.entities.enums.DeliveryType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CTrainingContent {

    private String content;

    private String learningObjective;

    private String deliveryType;

    private int duration;
}
