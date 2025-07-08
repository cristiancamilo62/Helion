package com.helion.infrastructure.adapters.persistence.exceptions;

import com.helion.shared.exception.custom.InfrastructurehelionException;

public class IdDoesNotExistInDatabaseException extends InfrastructurehelionException {

    public IdDoesNotExistInDatabaseException(String technicalMessage, String userMessage) {
        super(technicalMessage, userMessage);

    }
    
}
