package org.bhavesh.kbsales.bean;

import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {

	@CreatedBy
	protected U createdBy;
	@LastModifiedBy
	protected U lastModifiedBy;
	@CreatedDate
	@Temporal(TemporalType.DATE)
	protected Date createdDate;
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	protected Date modifiedDate;
// Getters and Setters
}
