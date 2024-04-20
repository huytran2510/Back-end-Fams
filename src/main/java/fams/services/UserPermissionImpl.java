package fams.services;

import fams.dto.reponse.forlist.LResponseUserPermission;
import fams.dto.request.forupdate.UUserPermission;
import fams.entities.UserPermission;
import fams.entities.enums.EPermission;
import fams.repository.UserPermissionRepository;
import fams.services.templates.IUserPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserPermissionImpl implements IUserPermissionService {

    @Autowired
    private UserPermissionRepository userPermissionRepository;

    @Override
    public UserPermission updateUserPermission(UUserPermission uUserPermission) throws Exception {
        Optional<UserPermission> optionalUserPermission = userPermissionRepository.findById(uUserPermission.getId());

        if (optionalUserPermission.isPresent()) {
            UserPermission userPermission = optionalUserPermission.get();
            // Update fields with values from uUserPermission
            userPermission.setClasses(EPermission.valueOf(uUserPermission.getClasses()));
            userPermission.setSyllabus(EPermission.valueOf(uUserPermission.getSyllabus()));
            userPermission.setTrainingProgram(EPermission.valueOf(uUserPermission.getTrainingProgram()));
            userPermission.setLearningMaterial(EPermission.valueOf(uUserPermission.getLearningMaterial()));
            // Save the updated UserPermission entity
            return userPermissionRepository.save(userPermission);
        } else {
            // Handle case where the UserPermission with the given ID is not found
            throw new Exception("UserPermission not found for ID: " + uUserPermission.getId());
        }
    }

    //write list
    public List<LResponseUserPermission> listUserPermission(){
        List<LResponseUserPermission> userPermissions = userPermissionRepository.findAllBy();
        return userPermissions;
    }
}
