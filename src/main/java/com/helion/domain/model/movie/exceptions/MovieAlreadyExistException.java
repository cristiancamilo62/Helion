package com.helion.domain.model.movie.exceptions;

import com.helion.shared.exception.custom.DomainhelionException;
import com.helion.shared.messages.MessageCatalog;
import com.helion.shared.messages.enums.MessageCode;

public class MovieAlreadyExistException extends DomainhelionException {

    public MovieAlreadyExistException() {
        super(MessageCatalog.getContentMessage(MessageCode.M0000025));

    }
}
