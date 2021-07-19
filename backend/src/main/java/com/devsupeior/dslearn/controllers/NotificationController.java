package com.devsupeior.dslearn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsupeior.dslearn.dto.NotificationDto;
import com.devsupeior.dslearn.services.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
	
	@Autowired
	private NotificationService service;
	
	@GetMapping
	public ResponseEntity<Page<NotificationDto>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "12") Integer size) {
				
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<NotificationDto> list = service.notificationsForCurrentUser(pageRequest);
		
		return ResponseEntity.ok().body(list);

	}

}
