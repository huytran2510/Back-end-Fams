package fams.dto.reponse.forlist;

import fams.entities.User;

import java.time.LocalDateTime;

public interface LResponseSyllabusList {
    public String getTopicCode();

    public String getTopicName();

    public LocalDateTime getCreatedDate();

    public Long getUser();
}
