package org.bhavesh.kbsales.bean.validator;


import java.util.Date;

import org.bhavesh.kbsales.bean.pojo.SaudaPOJO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SaudaValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return SaudaPOJO.class.isInstance(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SaudaPOJO saudaPOJO=(SaudaPOJO)target;
		Date startDate=saudaPOJO.getSaudaStartDate();
		Date endDate=saudaPOJO.getSaudaEndDate();
		if(!startDate.after(endDate))
		{
			errors.rejectValue("saudaStartDate","","Start Date cannot be less than end Date");
		}
		if(!endDate.after(startDate))
		{
			errors.rejectValue("saudaEndDate","","End Date cannot be less than start Date");
		}
		if(saudaPOJO.getBuyerAccount().equals(saudaPOJO.getSellerAccount()))
		{
			errors.rejectValue("buyerAccount","","BuyerAccount cannot be same as Seller Account");
			errors.rejectValue("sellerAccount","","Seller Account cannot be same as Buyer Account");
		}
	}
}
