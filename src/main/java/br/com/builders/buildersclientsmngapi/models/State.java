package br.com.builders.buildersclientsmngapi.models;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class State implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2940793079076011937L;
	
	private String state;

	public State() {
		super();
	}

	public State(String state) {
		super();
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
