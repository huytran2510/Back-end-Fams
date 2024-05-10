package fams.controller;

import fams.dto.reponse.forlist.templates.LResponseUserPermission;
import fams.dto.request.forupdate.UUserPermission;
import fams.entities.UserPermission;
import fams.services.templates.IUserPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/api/userPermission")
@CrossOrigin(origins = "http://localhost:3000")
public class UserPermissionController {
    @Autowired
    private IUserPermissionService iUserPermission;

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Object> update(@RequestBody UUserPermission user) throws Exception {
        UserPermission userPermission = iUserPermission.updateUserPermission(user);
        return ResponseEntity.ok().body(userPermission);
    }

    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public ResponseEntity<List<LResponseUserPermission>> getAllUserPermission() throws Exception {
        List<LResponseUserPermission> list = iUserPermission.listUserPermission();
        return ResponseEntity.ok().body(list);
    }
}
