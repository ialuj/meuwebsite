package br.com.builders.buildersclientsmngapi.models;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AvenueOrRoad implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 9135142338033663451L;
	
	private String avenueOrRoad;

	public AvenueOrRoad() {
		super();
	}

	public AvenueOrRoad(String avenueOrRoad) {
		super();
		this.avenueOrRoad = avenueOrRoad;
	}

	public String getAvenueOrRoad() {
		return avenueOrRoad;
	}

	public void setAvenueOrRoad(String avenueOrRoad) {
		this.avenueOrRoad = avenueOrRoad;
	}

}
