package com.helion.domain.model.user;

import com.helion.domain.model.security.Role;
import com.helion.shared.helper.ObjectHelper;
import com.helion.shared.helper.TextHelper;
import com.helion.shared.helper.UuidHelper;
import lombok.Data;
import lombok.Getter;
import java.util.UUID;

@Getter
@Data
public class UserDomain {

	private UUID id;

	private String identification;

	private String firstName;

	private String middleName;

	private String lastName;

	private String middleLastName;

	private String email;

	private String phoneNumber;

	private String password;

	private boolean accountStatement;

	private final Role role;


	public UserDomain() {
		setId(UuidHelper.DEFAULT_UUID);
        setIdentification(TextHelper.EMPTY);
        setFirstName(TextHelper.EMPTY);
        setMiddleName(TextHelper.EMPTY);
        setLastName(TextHelper.EMPTY);
        setMiddleLastName(TextHelper.EMPTY);
        setEmail(TextHelper.EMPTY);
        setPhoneNumber(TextHelper.EMPTY);
        setPassword(TextHelper.EMPTY);
        setAccountStatement(false);
        this.role = Role.USER;
	}

	public UserDomain(UUID id, String identification, String firstName, String middleName, String lastName,
					  String middleLastName, String email, String phoneNumber,String password,
					  boolean accountStatement) {
		setId(id);
		setIdentification(identification);
		setFirstName(firstName);
		setMiddleName(middleName);
		setLastName(lastName);
		setMiddleLastName(middleLastName);
		setEmail(email);
		setPhoneNumber(phoneNumber);
		setPassword(password);
		setAccountStatement(accountStatement);
		this.role = Role.USER;
	}

	public final void setId(UUID id) {
		this.id = id;
	}

	public final void setIdentification(String identification) {
		this.identification = ObjectHelper.getDefault(TextHelper.applyTrim(identification), TextHelper.EMPTY);
	}

	public final void setFirstName(String firstName) {
		this.firstName = ObjectHelper.getDefault(TextHelper.applyTrim(firstName), TextHelper.EMPTY);
	}

	public final void setMiddleName(String middleName) {
		this.middleName = ObjectHelper.getDefault(TextHelper.applyTrim(middleName), TextHelper.EMPTY);
	}

	public final void setLastName(String lastName) {
		this.lastName = ObjectHelper.getDefault(TextHelper.applyTrim(lastName), TextHelper.EMPTY);
	}

	public final void setMiddleLastName(String middleLastName) {
		this.middleLastName = ObjectHelper.getDefault(TextHelper.applyTrim(middleLastName), TextHelper.EMPTY);
	}

	public final void setEmail(String email) {
		this.email = ObjectHelper.getDefault(TextHelper.applyTrim(email), TextHelper.EMPTY);
	}

	public final void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = ObjectHelper.getDefault(TextHelper.applyTrim(phoneNumber), TextHelper.EMPTY);
	}

	public final void setPassword(String password) {
		this.password = ObjectHelper.getDefault(TextHelper.applyTrim(password), TextHelper.EMPTY);
	}

	public final void setAccountStatement(boolean accountStatement) {
		this.accountStatement = ObjectHelper.getDefault(accountStatement, false);
	}
}
