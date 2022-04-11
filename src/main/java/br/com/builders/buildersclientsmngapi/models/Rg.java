package br.com.builders.buildersclientsmngapi.models;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Rg implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3588559375986178706L;
	
	private String rg;

	public Rg() {
		super();
	}

	public Rg(String rg) {
		super();
		this.rg = rg;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

}
