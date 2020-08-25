package org.bhavesh.kbsales.bean;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Sauda {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long saudaId;
	private Date saudaDate;
	private Date saudaStartDate;
	private Date saudaEndDate;
	@OneToOne(targetEntity = Account.class,cascade = CascadeType.PERSIST)
	private Account sellerAccount;
	@OneToOne(targetEntity = Account.class,cascade = CascadeType.PERSIST)
	private Account buyerAccount;
	private Integer rate;
	private Integer quantity;
	private String tankerNo;
	private String refNo;
	private Integer deposit;
	private String description;
	private OptionEnum options;
	private QuantityType type;
	@CreationTimestamp
	private LocalDateTime createdDate;
	@LastModifiedDate
	private LocalDateTime modifiedDate;
}
