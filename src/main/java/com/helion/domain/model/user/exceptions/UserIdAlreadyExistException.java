package com.helion.domain.model.user.exceptions;

import com.helion.shared.exception.custom.DomainhelionException;
import com.helion.shared.messages.MessageCatalog;
import com.helion.shared.messages.enums.MessageCode;

public class UserIdAlreadyExistException extends DomainhelionException {

	public UserIdAlreadyExistException() {
		super(MessageCatalog.getContentMessage(MessageCode.M0000014),MessageCatalog.getContentMessage(MessageCode.M0000003));
	}

}
