package com.devsupeior.dslearn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsupeior.dslearn.dto.NotificationDto;
import com.devsupeior.dslearn.entities.Notification;
import com.devsupeior.dslearn.entities.User;
import com.devsupeior.dslearn.repositories.NotificationRepository;

@Service
public class NotificationService {
	
	@Autowired
	private NotificationRepository repository;
	
	@Autowired
	private AuthService authService;
	
	public Page<NotificationDto> notificationsForCurrentUser(Pageable pageable) {
		User user = authService.authenticated();
		Page<Notification> page = repository.find(user, false, pageable);
		return NotificationDto.converter(page);
	}

}
