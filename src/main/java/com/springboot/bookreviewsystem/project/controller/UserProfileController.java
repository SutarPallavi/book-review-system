package com.springboot.bookreviewsystem.project.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.bookreviewsystem.project.dto.UserProfileDto;
import com.springboot.bookreviewsystem.project.entity.UserProfile;
import com.springboot.bookreviewsystem.project.response.UserProfileResponse;
import com.springboot.bookreviewsystem.project.service.UserProfileService;

@Controller
public class UserProfileController {

	@Autowired
	private UserProfileService userProfileService;
	
	@PostMapping("/book-review-system/userprofiles/newuser")
	public ResponseEntity<UserProfileResponse> saveNewUserProfile(@RequestBody UserProfileDto userProfileDto){
		UserProfile userProfile= userProfileService.saveNewUserProfile(userProfileDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(new UserProfileResponse(userProfile.getUserID(), userProfile.getFirstName(), LocalDateTime.now()));
	}
	
	@GetMapping("/book-revie-system/userprofile/getuser/{userId}")
	public UserProfileDto getUserProfile(@PathVariable Long userId){
		UserProfileDto userProfileDto = userProfileService.getUserProfile(userId);
		return userProfileDto;
	}
	
	@GetMapping("/userprofiles/getalluserprofiles")
	public ResponseEntity<?> getAllUserProfiles(){
		try {
			List<UserProfile> allProfiles = userProfileService.getAllUserProfiles();
			return ResponseEntity.ok(allProfiles);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("Error retrieving user profiles: " + e.getMessage());
		}
	}
}
