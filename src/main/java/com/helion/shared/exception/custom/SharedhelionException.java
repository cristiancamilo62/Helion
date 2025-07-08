package com.helion.shared.exception.custom;


import com.helion.shared.exception.helionException;
import com.helion.shared.exception.enums.LocationException;

import java.io.Serial;

public class SharedhelionException extends helionException {

	@Serial
	private static final long serialVersionUID = 1L;
	private static final LocationException location = LocationException.SHARED;

	public SharedhelionException(final String userMessage) {
		super(userMessage, location);
	}

	public SharedhelionException(final String technicalMessage, final String userMessage) {
		super(technicalMessage, userMessage, location);
	}

	public SharedhelionException(final String technicalMessage, final String userMessage,
									  final Throwable rootException) {
		super(technicalMessage, userMessage, location, rootException);
	}
}
