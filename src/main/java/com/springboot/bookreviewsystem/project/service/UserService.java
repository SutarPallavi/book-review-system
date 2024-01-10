package com.springboot.bookreviewsystem.project.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.bookreviewsystem.project.dto.UserDto;
import com.springboot.bookreviewsystem.project.dto.UserProfileDto;
import com.springboot.bookreviewsystem.project.entity.Role;
import com.springboot.bookreviewsystem.project.entity.User;
import com.springboot.bookreviewsystem.project.repo.RoleRepository;
import com.springboot.bookreviewsystem.project.repo.UserRepository;
import com.springboot.bookreviewsystem.project.utils.AppUtilts;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
	@Autowired
    private PasswordEncoder passwordEncoder;
	@Autowired
	private UserProfileService userProfileService;
	
	@Autowired
	private AppUtilts appUtils;
	
	public User saveUser(UserDto userDto) {
		User user  = appUtils.dtoToDocument(userDto);
		Role role = roleRepository.findByName("ROLE_ADMIN");
		
		if(role == null) {
			role = checkRoleExist();
		}		
		 user.setRoles(Arrays.asList(role));
		 
		 UserProfileDto userProfileDto = UserProfileDto.builder()
					.firstName(userDto.getFirstName())
					.lastName(userDto.getLastName())
					.emailId(userDto.getEmail())
					.build();
		 userProfileService.saveNewUserProfile(userProfileDto);
		return userRepository.save(user);
	}
	
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for(User user : users) {
        	userDtos.add(AppUtilts.documentToDto(user));
        }
        return userDtos;
    }
    
	private Role checkRoleExist() {
		 Role role = new Role();
	     role.setName("ROLE_ADMIN");
	     return roleRepository.save(role);
	}
	
}
