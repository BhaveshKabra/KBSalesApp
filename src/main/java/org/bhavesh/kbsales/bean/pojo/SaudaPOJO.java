package org.bhavesh.kbsales.bean.pojo;

import java.util.Date;
import org.bhavesh.kbsales.bean.OptionEnum;
import org.bhavesh.kbsales.bean.QuantityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaudaPOJO {
	private Long saudaId;
	private Date saudaDate;
	private Date saudaStartDate;
	private Date saudaEndDate;
	private AccountPOJO sellerAccount;
	private AccountPOJO buyerAccount;
	private Integer rate;
	private Integer quantity;
	private String tankerNo;
	private String refNo;
	private Integer deposit;
	private String description;
	private OptionEnum options;
	private QuantityType type;
}
