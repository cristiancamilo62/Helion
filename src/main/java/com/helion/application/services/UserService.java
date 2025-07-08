package com.helion.application.services;

import com.helion.application.dto.UserDTO;
import com.helion.application.mapper.UserMapperDTO;
import com.helion.domain.model.user.UserDomain;
import com.helion.domain.model.user.rules.executor.UserValidationsRuleExecutor;
import com.helion.domain.ports.input.UserServicePort;
import com.helion.domain.ports.output.UserRepositoryPort;
import com.helion.shared.validators.structure.GenericValidationDataStructure;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements UserServicePort {

    private final UserRepositoryPort userRepositoryPort;

    private final UserValidationsRuleExecutor validationsRuleExecutor;

    private final UserMapperDTO userMapperDTO;

    private final PasswordEncoder passwordEncoder;

    private final GenericValidationDataStructure genericValidationDataStructure;


    @Override
    public UserDTO createUser(UserDTO userDTO) {

        UserDomain userDomain = userMapperDTO.toDomain(userDTO);

        userDomain.setId(UUID.randomUUID());

        validationsRuleExecutor.validate(userDomain);

        userDomain.setPassword(passwordEncoder.encode(userDomain.getPassword()));

        userRepositoryPort.save(userDomain);

        return userMapperDTO.toDTO(userDomain);
    }

    @Override
    public Optional<UserDTO> getUserById(UUID id) {

        genericValidationDataStructure.validateDataNotNullOrEmpty(id,"Id User");

        return userRepositoryPort.findById(id).map(userMapperDTO::toDTO);
    }

    @Override
    public List<UserDTO> getAllUsers() {

        return userMapperDTO.toDTOList(userRepositoryPort.findAll());
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {

        UserDomain userDomain = userMapperDTO.toDomain(userDTO);

        genericValidationDataStructure.validateDataNotNullOrEmpty(userDomain.getId(),"Id User");

        validationsRuleExecutor.validate(userDomain);

        return userMapperDTO.toDTO(userRepositoryPort.update(userDomain));

    }

    @Override
    public void deleteUser(UUID id) {

        genericValidationDataStructure.validateDataNotNullOrEmpty(id,"Id User");

        userRepositoryPort.deleteById(id);

    }

}
