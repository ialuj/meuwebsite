package br.com.builders.buildersclientsmngapi.models;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class HouseNumber implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4883299854015406821L;
	
	private String houseNumber;

	public HouseNumber() {
		super();
	}

	public HouseNumber(String houseNumber) {
		super();
		this.houseNumber = houseNumber;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

}
