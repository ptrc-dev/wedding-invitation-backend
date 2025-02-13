package com.ptrc.dev.wedding.invitation.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity(name = "confirmations")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ConfirmationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "document", nullable = false)
	private String document;

	@Column(name = "key", nullable = false)
	private String key;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, updatable = false)
	private Date createdAt;

	@PrePersist
	public void generateCreatedAt() {
		this.createdAt = new Date();
	}
}
