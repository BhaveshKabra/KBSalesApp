package org.bhavesh.kbsales.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
	private Long saudaId;
	private Date saudaDate;
	private Date saudaStartDate;
	private Date saudaEndDate;
	@OneToOne(targetEntity = Account.class)
	private Account sellerAccount;
	@OneToOne(targetEntity = Account.class)
	private Account buyerAccount;
	private Integer rate;
	private Integer quantity;
	private String tankerNo;
	private String refNo;
	private Integer deposit;
	private String description;
	private OptionEnum options;
	private QuantityType type;
}
