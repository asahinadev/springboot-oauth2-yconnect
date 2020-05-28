package com.example.spring.yconnect.entity;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;

@MappedSuperclass
public abstract class BaseEmpty {

	abstract void setCreated(LocalDateTime now);

	abstract void setUpdated(LocalDateTime now);

	@PrePersist
	public void onPrePersist() {
		LocalDateTime now = LocalDateTime.now();
		setCreated(now);
		setUpdated(now);
	}

	@PreUpdate
	public void onPreUpdate() {
		LocalDateTime now = LocalDateTime.now();
		setUpdated(now);
	}

	@Override
	public final boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	@SneakyThrows
	public final String toString() {
		return new ObjectMapper().writeValueAsString(this);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

}
