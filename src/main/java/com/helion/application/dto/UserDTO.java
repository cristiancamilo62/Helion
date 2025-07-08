package com.helion.application.dto;

import com.helion.shared.helper.TextHelper;
import com.helion.shared.helper.UuidHelper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {
    
    private UUID id;  
    
    private String identification;

    private String firstName;
    
    private String middleName;
    
    private String lastName;
    
    private String middleLastName;
    
    private String email;

    private String phoneNumber;

    private String password;

    
    public UserDTO() {
        setId(UuidHelper.DEFAULT_UUID);
        setIdentification(TextHelper.EMPTY);
        setFirstName(TextHelper.EMPTY);
        setMiddleName(TextHelper.EMPTY);
        setLastName(TextHelper.EMPTY);
        setMiddleLastName(TextHelper.EMPTY);
        setEmail(TextHelper.EMPTY);
        setPhoneNumber(TextHelper.EMPTY);
        setPassword(TextHelper.EMPTY);
    }
}

