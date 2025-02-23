package com.ptrc.dev.wedding.invitation.controllers;

import com.ptrc.dev.wedding.invitation.dtos.ConfirmationDto;
import com.ptrc.dev.wedding.invitation.entities.ConfirmationEntity;
import com.ptrc.dev.wedding.invitation.responses.ResponseConfirmation;
import com.ptrc.dev.wedding.invitation.services.ConfirmationService;
import com.ptrc.dev.wedding.invitation.services.KeyService;
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

	@Autowired
	private KeyService keyService;

	@GetMapping()
	public ResponseEntity<Page<ConfirmationEntity>> getConfirmations(Pageable pageable) {
		return ResponseEntity.ok(confirmationService.getAllConfirmations(pageable));
	}

	@PostMapping()
	public ResponseEntity<ResponseConfirmation> confirm(@RequestBody ConfirmationDto confirmationDto) {
		ResponseConfirmation response = new ResponseConfirmation();

		var key = keyService.findByKey(confirmationDto.key());
		var confirmation = confirmationService.findByDocument(confirmationDto.document());

		if (confirmation != null) {
			response.setMessage("CPF já confirmado!!");
			return ResponseEntity.badRequest().body(response);
		}

		if (key == null) {
			return ResponseEntity.notFound().build();
		}

		if (key.isUsed()) {
			response.setMessage("Chave já utilizada!");
			return ResponseEntity.badRequest().body(response);
		}

		if (!CpfUtils.isValidCPF(confirmationDto.document())) {
			response.setMessage("CPF inválido!");
			return ResponseEntity.badRequest().body(response);
		}

		var confirm = new ConfirmationEntity();
		BeanUtils.copyProperties(confirmationDto, confirm);
		confirmationService.confirm(confirm);

		key.setUsed(true);
		keyService.save(key);

		response.setMessage("Confirmação realizada com sucesso!");
		response.setContent(confirmationDto);
		return ResponseEntity.ok(response);
	}
}
