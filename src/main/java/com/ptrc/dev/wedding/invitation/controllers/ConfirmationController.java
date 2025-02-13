package com.ptrc.dev.wedding.invitation.controllers;

import com.ptrc.dev.wedding.invitation.dtos.ConfirmationDto;
import com.ptrc.dev.wedding.invitation.entities.ConfirmationEntity;
import com.ptrc.dev.wedding.invitation.services.ConfirmationService;
import com.ptrc.dev.wedding.invitation.utils.CpfUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/confirmation")
public class ConfirmationController {

	@Autowired
	private ConfirmationService confirmationService;

	@GetMapping()
	public ResponseEntity<Page<ConfirmationEntity>> getConfirmations(Pageable pageable) {
		return ResponseEntity.ok(confirmationService.getAllConfirmations(pageable));
	}

	@PostMapping()
	public ResponseEntity<ConfirmationEntity> confirm(@RequestBody ConfirmationDto confirmationDto) {
		if (!CpfUtils.isValidCPF(confirmationDto.document())) {
			return ResponseEntity.badRequest().build();
		}

		var confirm = new ConfirmationEntity();
		BeanUtils.copyProperties(confirmationDto, confirm);
		return ResponseEntity.ok(confirmationService.confirm(confirm));
	}
}
