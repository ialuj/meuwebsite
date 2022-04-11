package br.com.builders.buildersclientsmngapi.models;

import java.io.Serializable;

import javax.persistence.Embeddable;

import br.com.builders.buildersclientsmngapi.utils.BusinessException;

@Embeddable
public class PhoneNumber implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4377198341401761537L;
	
	private String phoneNumber;

	public PhoneNumber() {
		super();
	}

	public PhoneNumber(String phoneNumber) {
		super();
		setPhoneNumber(phoneNumber);
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		validatePhoneNumber(phoneNumber);
		this.phoneNumber = phoneNumber;
	}
	
	private void validatePhoneNumber(String phoneNumber) {
		String regexPatterns = "\\(?\\b([0-9]{2,3}|0((x|[0-9]){2,3}[0-9]{2}))\\)?\\s*[0-9]{4,5}[- ]*[0-9]{4}\\b";
		if (!phoneNumber.matches(regexPatterns)) {
			throw new BusinessException("Celular é inválido - " + phoneNumber);
		}
	}

}
