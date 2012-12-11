package org.wmichina.crm.helper;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MobileValidator implements ConstraintValidator<Mobile, String> {

	public void initialize(Mobile mobile) {

	}

	public boolean isValid(String value, ConstraintValidatorContext constraintContext) {
		if(value==null || value.equals("")){
			return false;
		}
		return value.matches("^((13[0-9])|(15[^4,\\D])|(18[0,5-9])|999)\\d{8}$");
	}
}
