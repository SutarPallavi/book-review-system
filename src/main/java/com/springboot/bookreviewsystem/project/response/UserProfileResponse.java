package com.springboot.bookreviewsystem.project.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileResponse {
	private long userId;
	private String firstName;
	private LocalDateTime date;
}
