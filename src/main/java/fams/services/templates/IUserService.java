package fams.services.templates;

import fams.dto.request.forcreate.CUser;
import fams.dto.request.forupdate.URoleUser;
import fams.dto.request.forupdate.UUser;
import fams.entities.User;
import org.springframework.data.domain.Page;

public interface IUserService {
    Page<User> getAllUser(int page, int size);

    User addNewUser(CUser cUser);

    User updateUser(UUser cUser);

    User updateRoleUser(URoleUser uRoleUser);
    User checkLogin(String email, String password);
}
