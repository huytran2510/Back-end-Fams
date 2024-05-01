package fams.services;

import fams.dto.request.forcreate.CUser;
import fams.dto.request.forupdate.URoleUser;
import fams.dto.request.forupdate.UUser;
import fams.entities.User;
import fams.entities.UserPermission;
import fams.entities.enums.ERole;
import fams.entities.enums.Gender;
import fams.entities.enums.UserStatus;
import fams.repository.UserPermissionRepository;
import fams.repository.UserRepository;
import fams.services.templates.IEmailService;
import fams.services.templates.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Random;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPermissionRepository userPermissionRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private IEmailService emailService;

    @Override
    public Page<User> getAllUser(int page, int size) {
        return userRepository.getUserDetailsWithRole(PageRequest.of(page, size));
    }

    @Override
    public User checkLogin(String email, String password) {
        System.out.println(email);
        User user = userRepository.findByEmail(email);

        if (user == null) {
            return null;
        }
        System.out.println(password);
        System.out.println(user.getPassword());
        System.out.println(bCryptPasswordEncoder.matches(password, user.getPassword()));
        if (!bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return null;
        }
        return user;
    }

    @Override
    @Transactional
    public User addNewUser(CUser cUser) {
        System.out.println(cUser.getRole());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        System.out.println(email);
        User userCreated = userRepository.findByEmail(email);
        UserPermission role = userPermissionRepository.findByRole(ERole.valueOf(cUser.getRole()));
        User user = new User();
        user.setCreateBy(userCreated);
        user.setEmail(cUser.getEmail());
        user.setName(cUser.getName());
        user.setCreatedDate(LocalDateTime.now());
        System.out.println(cUser.getDob());
        user.setDob(cUser.getDob());

        user.setGender(Gender.valueOf(cUser.getGender()));
        user.setPhone(cUser.getPhone());
        user.setStatus(UserStatus.valueOf(cUser.getStatus()));

        String randomPassword = generateRandomPassword(10);
        user.setPassword(bCryptPasswordEncoder.encode(randomPassword));
        emailService.sendPasswordResetEmail(cUser.getEmail(), randomPassword);

        userPermissionRepository.save(role);
        user.setUserPermission(role);
        User result = userRepository.save(user);
        return result;
    }

    public String generateRandomPassword(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }
        return password.toString();
    }

    public User updateUser(UUser uUser) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        // Fetch the user who is making modifications
        User userModified = userRepository.findByEmail(email);

        // Fetch the role based on the provided role string
        UserPermission role = userPermissionRepository.findByRole(ERole.valueOf(uUser.getRole()));

        // Create a new User instance or fetch the user if updating existing details
        User user = userRepository.findByEmail(uUser.getEmail());
        // Update user information with the provided data from CUser
        user.setModifiedBy(userModified);
        user.setEmail(uUser.getEmail());
        user.setName(uUser.getName());
        user.setDob(uUser.getDob()); // Make sure dob is parsed correctly

        user.setGender(Gender.valueOf(uUser.getGender())); // Make sure gender is parsed correctly
        user.setPhone(uUser.getPhone());
        user.setStatus(UserStatus.valueOf(uUser.getStatus()));
        user.setModifiedDate(LocalDateTime.now());
        // Save the updated role if needed
        userPermissionRepository.save(role);
        user.setUserPermission(role);

        // Save or update the user information in the database
        User result = userRepository.save(user);
        return result;
    }


    public User updateRoleUser(URoleUser uRoleUser) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        // Fetch the user who is making modifications
        User userModified = userRepository.findByEmail(email);
        // Fetch the role based on the provided role string
        UserPermission role = userPermissionRepository.findByRole(ERole.valueOf(uRoleUser.getRole()));
        // Create a new User instance or fetch the user if updating existing details
        User user = userRepository.findByEmail(uRoleUser.getEmail());
        // Save the updated role if needed
        userPermissionRepository.save(role);
        user.setUserPermission(role);
        user.setModifiedBy(userModified);
        // Save or update the user information in the database
        User result = userRepository.save(user);
        return result;
    }

}
