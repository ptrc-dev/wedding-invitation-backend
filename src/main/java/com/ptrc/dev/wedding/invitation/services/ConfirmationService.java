package com.ptrc.dev.wedding.invitation.services;

import com.ptrc.dev.wedding.invitation.entities.ConfirmationEntity;
import com.ptrc.dev.wedding.invitation.repositories.ConfirmationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
@RequiredArgsConstructor
public class ConfirmationService {

	@Autowired
	private ConfirmationRepository confirmationRepository;

	@Transactional
	public void confirm(ConfirmationEntity confirmationEntity) {
		confirmationRepository.save(confirmationEntity);
	}

	public Page<ConfirmationEntity> getAllConfirmations(Pageable pageable) {
		return confirmationRepository.findAll(pageable);
	}

	public ConfirmationEntity findByName(String name) {
		return confirmationRepository.findByName(name);
	}
}
