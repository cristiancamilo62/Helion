package com.helion.domain.ports.input;


import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.helion.application.dto.UserDTO;

public interface UserServicePort {

    UserDTO createUser(UserDTO patient);

    Optional<UserDTO> getUserById(UUID id);

    List<UserDTO> getAllUsers();

    UserDTO  updateUser(UserDTO patient);

    void deleteUser(UUID id);


}
