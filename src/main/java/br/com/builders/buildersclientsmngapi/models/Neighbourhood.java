package br.com.builders.buildersclientsmngapi.models;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Neighbourhood implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2689521448860727044L;
	
	private String neighbourhood;

	public Neighbourhood() {
		super();
	}

	public Neighbourhood(String neighbourhood) {
		super();
		this.neighbourhood = neighbourhood;
	}

	public String getNeighbourhood() {
		return neighbourhood;
	}

	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}

}
