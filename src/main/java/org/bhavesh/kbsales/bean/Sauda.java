package org.bhavesh.kbsales.bean;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class Sauda extends Auditable<String> {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Getter
	@Setter
	private Long saudaId;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate saudaStartDate;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate saudaEndDate;
	@ManyToOne(targetEntity = Account.class)
	private Account sellerAccount;
	@ManyToOne(targetEntity = Account.class)
	private Account buyerAccount;
	@Getter
	@Setter
	private Integer rate;
	@Getter
	@Setter
	private Integer quantity;
	@Getter
	@Setter
	private String tankerNo;
	@Getter
	@Setter
	private String refNo;
	@Getter
	@Setter
	private Integer deposit;
	@Getter
	@Setter
	private String description;
	@Getter
	@Setter
	@Enumerated(value = EnumType.STRING)
	private OptionEnum options;
	@Enumerated(value = EnumType.STRING)
	@Getter
	@Setter
	private QuantityType type;
	@Enumerated(value = EnumType.STRING)
	@Getter
	@Setter
	private SaudaStatus status;
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
	public Account getSellerAccount() { 
		return new Account(sellerAccount);
	}
	public void setSellerAccount(Account sellerAccount) {
		this.sellerAccount = new Account(sellerAccount);
	}
	public Account getBuyerAccount() {
		return new Account(buyerAccount);
	}
	public void setBuyerAccount(Account buyerAccount) {
		this.buyerAccount = new Account(buyerAccount);
	}
	@Override
	public int hashCode() {
		return Objects.hash(buyerAccount, deposit, description, options, quantity, rate, refNo, saudaEndDate, saudaId,
				saudaStartDate, sellerAccount, status, tankerNo, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sauda other = (Sauda) obj;
		return Objects.equals(buyerAccount, other.buyerAccount) && Objects.equals(deposit, other.deposit)
				&& Objects.equals(description, other.description) && options == other.options
				&& Objects.equals(quantity, other.quantity) && Objects.equals(rate, other.rate)
				&& Objects.equals(refNo, other.refNo) && Objects.equals(saudaEndDate, other.saudaEndDate)
				&& Objects.equals(saudaId, other.saudaId) && Objects.equals(saudaStartDate, other.saudaStartDate)
				&& Objects.equals(sellerAccount, other.sellerAccount) && status == other.status
				&& Objects.equals(tankerNo, other.tankerNo) && type == other.type;
	}
	public Sauda(Long saudaId, LocalDate saudaStartDate, LocalDate saudaEndDate, Account sellerAccount,
			Account buyerAccount, Integer rate, Integer quantity, String tankerNo, String refNo, Integer deposit,
			String description, OptionEnum options, QuantityType type, SaudaStatus status) {
		super();
		this.saudaId = saudaId;
		this.saudaStartDate = saudaStartDate.minusDays(0);
		this.saudaEndDate = saudaEndDate.minusDays(0);
		this.sellerAccount = new Account(sellerAccount);
		this.buyerAccount = new Account(buyerAccount);
		this.rate = rate;
		this.quantity = quantity;
		this.tankerNo = tankerNo;
		this.refNo = refNo;
		this.deposit = deposit;
		this.description = description;
		this.options = options;
		this.type = type;
		this.status = status;
	}
}
