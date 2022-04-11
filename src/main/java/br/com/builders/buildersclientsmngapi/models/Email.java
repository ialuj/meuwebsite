package br.com.builders.buildersclientsmngapi.models;

import java.io.Serializable;
import java.util.regex.Pattern;

import javax.persistence.Embeddable;

import br.com.builders.buildersclientsmngapi.utils.BusinessException;

@Embeddable
public class Email implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4455147657519859331L;
	
	private String email;

	public Email() {
		super();
	}

	public Email(String email) {
		super();
		setEmail(email);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		validateEmail(email);
		this.email = email;
	}
	
	private void validateEmail(String email) {
		String regexPattern = "^(.+)@(\\S+)$";
		if (!Pattern.compile(regexPattern).matcher(email).matches()) {
			throw new BusinessException("E-mail é inválido - " + email);
		}
	}

}
