package com.springboot.bookreviewsystem.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bookreviewsystem.project.dto.UserProfileDto;
import com.springboot.bookreviewsystem.project.entity.UserProfile;
import com.springboot.bookreviewsystem.project.repo.UserProfileRepository;
import com.springboot.bookreviewsystem.project.utils.AppUtilts;

@Service
public class UserProfileService {

	@Autowired
	private UserProfileRepository userProfileRepository;
	
	@Autowired
	private AppUtilts appUtilts;
	
	public UserProfile saveNewUserProfile(UserProfileDto userProfileDto) {
		UserProfile userProfile = userProfileRepository.save(appUtilts.dtoToDocument(userProfileDto));
		return userProfile;
	}
	
	public UserProfileDto getUserProfile(Long id) {
		Optional<UserProfile> userProfile= userProfileRepository.findById(id);
		if(userProfile.isPresent()) {
			return AppUtilts.documentToDto(userProfile.get());
		}
		else 
			return null; 
	}
	
	public List<UserProfile> getAllUserProfiles() {
		return userProfileRepository.findAll();
	}
}
