package br.com.leiras.money.model;

import java.io.Serializable;
import java.util.Date;

public class Despesa implements Serializable {

	private static final long serialVersionUID = 363589248827729318L;
	private Integer id;
	private Float valor;
	private Date data;

	public Despesa() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
}
