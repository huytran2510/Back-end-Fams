package fams.controller;

import fams.dto.reponse.forlist.LResponseUserList;
import fams.dto.reponse.update.UserResponse;
import fams.dto.request.forcreate.CTrainingContent;
import fams.dto.request.forcreate.CTrainingUnit;
import fams.dto.request.forcreate.CUser;
import fams.dto.request.forcreate.CreateSyllabusRequest;
import fams.dto.request.forupdate.URoleUser;
import fams.dto.request.forupdate.UUser;
import fams.entities.User;
import fams.services.templates.ITrainingUnitService;
import fams.services.templates.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ITrainingUnitService trainingUnitService;


    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    public ResponseEntity<Page<LResponseUserList>> getAllUser(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<LResponseUserList> usersPage = userService.getAllUser(page, size);
        System.out.println(usersPage);
        return ResponseEntity.ok().body(usersPage);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Object> register(@Valid @RequestBody CUser cUser) {
        User result = userService.addNewUser(cUser);
        UserResponse responseDTO = modelMapper.map(result, UserResponse.class);
        return ResponseEntity.ok().body(responseDTO);
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public ResponseEntity<Object> update(@Valid @RequestBody UUser uUser) {
        User result = userService.updateUser(uUser);
        UserResponse responseDTO = modelMapper.map(result, UserResponse.class);
        return ResponseEntity.ok().body(responseDTO);
    }

    @RequestMapping(value = "/updateRoleUser", method = RequestMethod.POST)
    public ResponseEntity<Object> updateRoleUser(@Valid @RequestBody URoleUser uRoleUser) {
        User result = userService.updateRoleUser(uRoleUser);
        UserResponse responseDTO = modelMapper.map(result, UserResponse.class);
        return ResponseEntity.ok().body(responseDTO);
    }


}
