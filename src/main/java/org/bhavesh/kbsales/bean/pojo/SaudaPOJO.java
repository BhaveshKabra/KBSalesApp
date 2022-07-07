package org.bhavesh.kbsales.bean.pojo;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.bhavesh.kbsales.bean.OptionEnum;
import org.bhavesh.kbsales.bean.QuantityType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.NoArgsConstructor;

@NoArgsConstructor
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
	public long getSaudaId() {
		return saudaId;
	}
	public void setSaudaId(long saudaId) {
		this.saudaId = saudaId;
	}
	public LocalDate getSaudaStartDate() {
		return saudaStartDate.minusDays(0);
	}
	public void setSaudaStartDate(LocalDate saudaStartDate) {
		this.saudaStartDate = saudaStartDate.minusDays(0);
	}
	public LocalDate getSaudaEndDate() {
		return saudaEndDate.minusDays(0);
	}
	public void setSaudaEndDate(LocalDate saudaEndDate) {
		this.saudaEndDate = saudaEndDate.minusDays(0);
	}
	public AccountPOJO getSellerAccount() {
		return new AccountPOJO(sellerAccount);
	}
	public void setSellerAccount(AccountPOJO sellerAccount) {
		this.sellerAccount = new AccountPOJO(sellerAccount);
	}
	public AccountPOJO getBuyerAccount() {
		return new AccountPOJO(buyerAccount);
	}
	public void setBuyerAccount(AccountPOJO buyerAccount) {
		this.buyerAccount = new AccountPOJO(buyerAccount);
	}
	public Integer getRate() {
		return rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getTankerNo() {
		return tankerNo;
	}
	public void setTankerNo(String tankerNo) {
		this.tankerNo = tankerNo;
	}
	public String getRefNo() {
		return refNo;
	}
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	public Integer getDeposit() {
		return deposit;
	}
	public void setDeposit(Integer deposit) {
		this.deposit = deposit;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public OptionEnum getOptions() {
		return options;
	}
	public void setOptions(OptionEnum options) {
		this.options = options;
	}
	public QuantityType getType() {
		return type;
	}
	public void setType(QuantityType type) {
		this.type = type;
	}
	
}
