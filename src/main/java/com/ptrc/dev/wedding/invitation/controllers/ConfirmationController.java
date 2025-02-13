package com.ptrc.dev.wedding.invitation.controllers;

import com.ptrc.dev.wedding.invitation.dtos.ConfirmationDto;
import com.ptrc.dev.wedding.invitation.entities.ConfirmationEntity;
import com.ptrc.dev.wedding.invitation.services.ConfirmationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/confirmation")
public class ConfirmationController {

	@Autowired
	private ConfirmationService confirmationService;

	@GetMapping()
	public ResponseEntity<List<ConfirmationEntity>> getConfirmations() {
		return ResponseEntity.ok(confirmationService.getAllConfirmations());
	}

	@PostMapping()
	public ResponseEntity<ConfirmationEntity> confirm(@RequestBody ConfirmationDto confirmationDto) {
		var confirm = new ConfirmationEntity();
		BeanUtils.copyProperties(confirmationDto, confirm);
		return ResponseEntity.ok(confirmationService.confirm(confirm));
	}
}
