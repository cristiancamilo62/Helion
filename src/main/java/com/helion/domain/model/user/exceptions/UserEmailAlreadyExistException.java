package com.helion.domain.model.user.exceptions;

import com.helion.shared.exception.custom.DomainhelionException;
import com.helion.shared.messages.MessageCatalog;
import com.helion.shared.messages.enums.MessageCode;

public class UserEmailAlreadyExistException extends DomainhelionException {

	public UserEmailAlreadyExistException() {
		super(MessageCatalog.getContentMessage(MessageCode.M0000013));
	}
}
