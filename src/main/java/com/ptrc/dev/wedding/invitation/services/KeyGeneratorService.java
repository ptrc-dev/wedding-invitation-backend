package com.ptrc.dev.wedding.invitation.services;

import com.ptrc.dev.wedding.invitation.entities.KeyEntity;
import com.ptrc.dev.wedding.invitation.repositories.KeyRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class KeyGeneratorService {

	@Autowired
	private KeyRepository keyRepository;

	@PostConstruct
	public void init() {
		generateKeys();
	}

	public void generateKeys() {
		if (keyRepository.count() >= 100) {
			throw new RuntimeException("Cannot generate more than 100 keys");
		}

		List<KeyEntity> keys = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			KeyEntity keyEntity = new KeyEntity();
			keyEntity.setKey(UUID.randomUUID().toString());
			keyEntity.setUsed(false);
			keys.add(keyEntity);
		}

		keyRepository.saveAll(keys);
	}

	public boolean hasMoreThan100Keys() {
		return keyRepository.count() > 100;
	}
}