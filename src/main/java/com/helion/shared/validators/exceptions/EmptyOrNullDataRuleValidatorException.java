package com.helion.shared.validators.exceptions;

import com.helion.shared.exception.custom.SharedhelionException;

public class EmptyOrNullDataRuleValidatorException extends SharedhelionException {

    public EmptyOrNullDataRuleValidatorException(String message) {
        super(message);
    }
}
