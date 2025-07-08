package com.helion.domain.model.user.rules.validation;

import com.helion.domain.model.GenericValidationRule;
import com.helion.shared.validators.structure.GenericValidationDataStructure;
import org.springframework.stereotype.Service;

@Service
public class PhoneNumberUserRuleValidator implements GenericValidationRule<String> {

	public static final String FIELD_NAME_PHONE_NUMBER = "phone number ";
	private final GenericValidationDataStructure genericValidationDataStructure;

    public PhoneNumberUserRuleValidator(GenericValidationDataStructure genericValidationDataStructure) {
        this.genericValidationDataStructure = genericValidationDataStructure;
    }

    @Override
	public void validate(String phoneNumber) {

		genericValidationDataStructure.validateLengthDataOptional(phoneNumber,10,FIELD_NAME_PHONE_NUMBER);
		genericValidationDataStructure.validateFormatDataOptional(phoneNumber,FIELD_NAME_PHONE_NUMBER);
	}
}
