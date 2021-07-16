package com.devsupeior.dslearn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsupeior.dslearn.entities.User;
import com.devsupeior.dslearn.repositories.UserRepository;
import com.devsupeior.dslearn.services.exceptions.ForbiddenException;
import com.devsupeior.dslearn.services.exceptions.UnauthorizedException;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public User authenticated() {
		try {
			
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			return repository.findByEmail(username);
			
		}
		catch (Exception e) {
			throw new UnauthorizedException("Usuário Inválido!");
		}
	}
	
	public void validateSelfOrAdmin(Long userId) {
		User user = authenticated();
		if (!user.getId().equals(userId) && !user.hasRole("ROLE_ADMIN")) {
			throw new ForbiddenException("Acesso negado!");
		}
	}

}
