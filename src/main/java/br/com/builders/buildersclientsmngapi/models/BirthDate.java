package br.com.builders.buildersclientsmngapi.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embeddable;

@Embeddable
public class BirthDate implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 155723643089550829L;
	
	private LocalDate birthDate;

	public BirthDate() {
		super();
	}

	public BirthDate(LocalDate birthDate) {
		super();
		this.birthDate = birthDate;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

}
