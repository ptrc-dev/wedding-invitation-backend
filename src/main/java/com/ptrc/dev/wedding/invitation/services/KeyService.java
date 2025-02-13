package com.ptrc.dev.wedding.invitation.services;

import com.ptrc.dev.wedding.invitation.entities.KeyEntity;
import com.ptrc.dev.wedding.invitation.repositories.KeyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeyService {

	@Autowired
	private KeyRepository keyRepository;

	public KeyEntity findByKey(String key) {
		return keyRepository.findByKey(key);
	}

	@Transactional
	public KeyEntity save(KeyEntity keyEntity) {
		return keyRepository.save(keyEntity);
	}
}
