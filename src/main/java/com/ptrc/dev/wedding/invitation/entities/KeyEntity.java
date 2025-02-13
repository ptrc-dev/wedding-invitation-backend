package com.ptrc.dev.wedding.invitation.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity(name = "keys")
@AllArgsConstructor
@NoArgsConstructor
public class KeyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "key_pass", nullable = false)
	private String key;

	@Column(name = "used", nullable = false, columnDefinition = "boolean default false")
	private boolean used;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, updatable = false)
	private Date createdAt;

	@PrePersist
	public void generateCreatedAt() {
		this.createdAt = new Date();
	}

	public boolean isUsed() {
		return used;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
