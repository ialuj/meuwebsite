package br.com.builders.buildersclientsmngapi.models;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AvenueRoad implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 9135142338033663451L;
	
	private String avenueRoad;

	public AvenueRoad() {
		super();
	}

	public AvenueRoad(String avenueRoad) {
		super();
		this.avenueRoad = avenueRoad;
	}

	public String getAvenueRoad() {
		return avenueRoad;
	}

	public void setAvenueRoad(String avenueRoad) {
		this.avenueRoad = avenueRoad;
	}

}
