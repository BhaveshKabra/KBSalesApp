package org.bhavesh.kbsales.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EqualsAndHashCode
public class Sauda {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long saudaId;
	@DateTimeFormat(iso = ISO.DATE)
	private Date saudaStartDate;
	@DateTimeFormat(iso = ISO.DATE)
	private Date saudaEndDate;
	@ManyToOne(targetEntity = Account.class)
	private Account sellerAccount;
	@ManyToOne(targetEntity = Account.class)
	private Account buyerAccount;
	private Integer rate;
	private Integer quantity;
	private String tankerNo;
	private String refNo;
	private Integer deposit;
	private String description;
	@Enumerated(value = EnumType.STRING)
	private OptionEnum options;
	@Enumerated(value = EnumType.STRING)
	private QuantityType type;
	@CreationTimestamp
	private LocalDate createdDate;
	@LastModifiedDate
	private LocalDateTime modifiedDate;
}
