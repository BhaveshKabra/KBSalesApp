package org.bhavesh.kbsales.bean.pojo;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.bhavesh.kbsales.bean.OptionEnum;
import org.bhavesh.kbsales.bean.QuantityType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaudaPOJO {
	private long saudaId;
	@DateTimeFormat(iso = ISO.DATE)
	@NotNull
	private Date saudaStartDate;
	@DateTimeFormat(iso = ISO.DATE)
	@NotNull
	private Date saudaEndDate;
	@NotNull
	private AccountPOJO sellerAccount;
	@NotNull
	private AccountPOJO buyerAccount;
	@Positive
	private Integer rate;
	@Positive
	private Integer quantity;
	private String tankerNo;
	private String refNo;
	@PositiveOrZero
	private Integer deposit;
	private String description;
	private OptionEnum options;
	private QuantityType type;	
}
