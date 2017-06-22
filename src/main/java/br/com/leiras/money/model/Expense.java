package br.com.leiras.money.model;

import java.io.Serializable;
import java.util.Date;

public class Expense implements Serializable {

	private static final long serialVersionUID = 363589248827729318L;
	private Integer id;
	private Float value;
	private Date date;
	private Category category;

	public Expense() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}	

}
