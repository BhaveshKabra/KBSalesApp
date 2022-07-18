package org.bhavesh.kbsales.bean.pojo;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.bhavesh.kbsales.bean.OptionEnum;
import org.bhavesh.kbsales.bean.QuantityType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class SaudaPOJO {
	private long saudaId;
	@DateTimeFormat(iso = ISO.DATE)
	@NotNull
	private LocalDate saudaStartDate;
	@DateTimeFormat(iso = ISO.DATE)
	@NotNull
	private LocalDate saudaEndDate;
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
