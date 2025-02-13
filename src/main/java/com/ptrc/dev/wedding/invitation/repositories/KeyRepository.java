package com.ptrc.dev.wedding.invitation.repositories;

import com.ptrc.dev.wedding.invitation.entities.KeyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyRepository extends JpaRepository<KeyEntity, Long> {
	public KeyEntity findByKey(String key);
}
