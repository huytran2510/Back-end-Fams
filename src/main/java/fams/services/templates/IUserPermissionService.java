package fams.services.templates;

import fams.dto.reponse.forlist.templates.LResponseUserPermission;
import fams.dto.request.forupdate.UUserPermission;
import fams.entities.UserPermission;

import java.util.List;

public interface IUserPermissionService {
    public UserPermission updateUserPermission(UUserPermission uUserPermission) throws Exception;

    public List<LResponseUserPermission> listUserPermission();
}
