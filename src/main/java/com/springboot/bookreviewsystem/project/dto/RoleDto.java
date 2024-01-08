package com.springboot.bookreviewsystem.project.dto;

import java.util.List;

import com.springboot.bookreviewsystem.project.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class RoleDto {

	private String name;
	private List<User> users;
}
