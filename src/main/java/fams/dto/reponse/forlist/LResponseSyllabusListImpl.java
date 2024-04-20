package fams.dto.reponse.forlist;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;



@Getter
@Setter
public class LResponseSyllabusListImpl implements LResponseSyllabusList {
    private final String topicCode;
    private final String topicName;
    private final LocalDateTime createdDate;
    private final Long user;
    public LResponseSyllabusListImpl(String topicCode, String topicName, LocalDateTime createdDate, Long user) {
        this.topicCode = topicCode;
        this.topicName = topicName;
        this.createdDate = createdDate;
        this.user = user;
    }

    @Override
    public String getTopicCode() {
        return topicCode;
    }

    @Override
    public String getTopicName() {
        return topicName;
    }

    @Override
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public Long getUser() {
        return user;
    }

}
