package com.example.tiary.article;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

import com.example.tiary.users.constant.Role;
import com.example.tiary.users.constant.UserStatus;
import com.example.tiary.users.dto.UserDto;
import com.example.tiary.users.entity.Users;

public class WithMockCustomUserSecurityContextFactory implements WithSecurityContextFactory<WithMockCustomUser> {
	@Override
	public SecurityContext createSecurityContext(WithMockCustomUser annotation) {
		SecurityContext context = SecurityContextHolder.createEmptyContext();
		// List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
		// grantedAuthorityList.add((GrantedAuthority)()-> "ROLE_USER");
		Users users = new Users(1L, "test", "test@gmail.com", Role.USER, null, UserStatus.ACTIVE);
		UserDto userDto = new UserDto(users);
		Authentication authenticationToken =
			new UsernamePasswordAuthenticationToken(userDto, null, userDto.getUsers().getAuthorities());
		context.setAuthentication(authenticationToken);
		return context;
	}
}
