package com.ptrc.dev.wedding.invitation.services;

import com.ptrc.dev.wedding.invitation.entities.ConfirmationEntity;
import com.ptrc.dev.wedding.invitation.repositories.ConfirmationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class ConfirmationService {

	@Autowired
	private ConfirmationRepository confirmationRepository;

	@Transactional
	public ConfirmationEntity confirm(ConfirmationEntity confirmationEntity) {
		return confirmationRepository.save(confirmationEntity);
	} // alterar aqui para verificar usando o service das keys se a key já foi usada, existe ou não foi usada

	public Page<ConfirmationEntity> getAllConfirmations(Pageable pageable) {
		return confirmationRepository.findAll(pageable);
	}
}
