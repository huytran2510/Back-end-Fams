package fams.controller;

import fams.dto.reponse.authen.LoginModel;
import fams.dto.reponse.forlist.templates.LResponseUserList;
import fams.dto.reponse.forlist.LResponseUserListImpl;
import fams.dto.reponse.update.UserResponse;
import fams.dto.request.authen.TokenModel;
import fams.dto.request.forcreate.CUser;
import fams.dto.request.forupdate.URoleUser;
import fams.dto.request.forupdate.UUser;
import fams.entities.User;
import fams.services.TokenAuthenticationService;
import fams.services.templates.ITrainingUnitService;
import fams.services.templates.IUserPermissionService;
import fams.services.templates.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ITrainingUnitService trainingUnitService;

    @Autowired
    private IUserPermissionService userPermissionService;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Object> loginUser(@Valid @RequestBody LoginModel loginModel, HttpServletResponse response) {
        String username = loginModel.getUsername();
        String password = loginModel.getPassword();
        System.out.println("username" + username);
        System.out.println("password" + password);
        System.out.println(username + password);
        User user = userService.checkLogin(username, password);
        if (user != null) {
            System.out.printf("JWTLoginFilter.attemptAuthentication: username/password= %s,%s\n", username, password);
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE:" + user.getUserPermission().getRole().toString()));
//            grantedAuthorities.add(new SimpleGrantedAuthority("SYLLABUS:" + user.getUserPermission().getSyllabus().toString()));
//            grantedAuthorities.add(new SimpleGrantedAuthority("TRAINING_PROGRAM:" + user.getUserPermission().getTrainingProgram().toString()));
//            grantedAuthorities.add(new SimpleGrantedAuthority("CLASS:" + user.getUserPermission().getClasses().toString()));
//            grantedAuthorities.add(new SimpleGrantedAuthority("LEARNING_MATERIAL:" + user.getUserPermission().getLearningMaterial().toString()));
//            grantedAuthorities.add(new SimpleGrantedAuthority("USER_MANAGEMENT:" + user.getUserPermission().getUserManagement().toString()));
            TokenAuthenticationService.addAuthentication(response, username, grantedAuthorities);
            String authorizationString = response.getHeader("Authorization");
            System.out.println("Authorization String=" + authorizationString);
            TokenModel tokenModel = new TokenModel(authorizationString);
            return ResponseEntity.ok().body(tokenModel.getApiKey());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
        }
    }


    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    public ResponseEntity<Page<LResponseUserList>> getAllUser(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<User> usersPage = userService.getAllUser(page, size);
        Page<LResponseUserList> responsePage = usersPage.map(this::convertToResponseDto);
        return ResponseEntity.ok().body(responsePage);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Object> register(@Valid @RequestBody CUser cUser) {
        User result = userService.addNewUser(cUser);
        UserResponse responseDTO = modelMapper.map(result, UserResponse.class);
        return ResponseEntity.ok().body(responseDTO);
    }

    private LResponseUserListImpl convertToResponseDto(User user) {
        return new LResponseUserListImpl(user.getId(), user.getName(), user.getEmail() ,user.getDob() ,  user.getGender(), user.getUserPermission().getRole());
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
