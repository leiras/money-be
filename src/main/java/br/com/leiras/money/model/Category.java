package br.com.leiras.money.model;

import java.io.Serializable;

public class Category implements Serializable {

	private static final long serialVersionUID = 607916578715111839L;
	private Integer id;
	private String name;

	public Category() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
