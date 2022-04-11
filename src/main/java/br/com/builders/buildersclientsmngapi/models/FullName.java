package br.com.builders.buildersclientsmngapi.models;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class FullName implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8352175557058886329L;
	
	private String fullName;

	public FullName() {
		super();
	}

	public FullName(String fullName) {
		super();
		this.fullName = fullName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
