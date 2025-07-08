package com.helion.domain.model.user.rules.business;

import com.helion.domain.model.user.UserDomain;
import com.helion.domain.ports.output.UserRepositoryPort;
import com.helion.domain.model.user.exceptions.UserIdentificationAlreadyExistException;
import com.helion.domain.model.GenericValidationRule;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserIdentificationAlreadyExistBusinessRule implements GenericValidationRule<UserDomain> {
	
	private final UserRepositoryPort patientRepositoryPort;

	@Override
	public void validate(UserDomain userDomain) {

        if (patientRepositoryPort.existsByIdentification(userDomain.getIdentification(),userDomain.getId())) {
            throw new UserIdentificationAlreadyExistException();
        }

    }
		

}
