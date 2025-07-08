package com.helion.shared.validators.exceptions;

import com.helion.shared.exception.custom.SharedhelionException;

public class InvalidLengthDataRuleValidatorException extends SharedhelionException {

    public InvalidLengthDataRuleValidatorException(String userMessage) {
        super(userMessage);
    }
}
