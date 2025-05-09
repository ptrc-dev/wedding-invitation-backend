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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "email", nullable = false)
	private String email;

  @Column(name = "phone", nullable = false)
  private String phone;

	@Column(name = "key_pass", nullable = false)
	private String key;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, updatable = false)
	private Date createdAt;

	@PrePersist
	public void generateCreatedAt() {
		this.createdAt = new Date();
	}
}
