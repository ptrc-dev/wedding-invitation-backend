package com.ptrc.dev.wedding.invitation.repositories;

import com.ptrc.dev.wedding.invitation.entities.ConfirmationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmationRepository extends JpaRepository<ConfirmationEntity, Long> {
}
