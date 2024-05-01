package fams.services.templates;

import fams.dto.reponse.forlist.templates.LResponseClassList;

import java.util.List;

public interface ICLassService {
    public List<LResponseClassList> list(String code);
}
