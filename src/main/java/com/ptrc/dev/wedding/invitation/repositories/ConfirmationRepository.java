package com.ptrc.dev.wedding.invitation.repositories;

import com.ptrc.dev.wedding.invitation.entities.ConfirmationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmationRepository extends JpaRepository<ConfirmationEntity, Long> {
	public Page<ConfirmationEntity> findAll(Pageable pageable);
}
