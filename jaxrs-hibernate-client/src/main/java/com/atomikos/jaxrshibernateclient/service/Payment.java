package com.atomikos.jaxrshibernateclient.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Payment {

	@Id
	public String cardno;
	public Integer amount;
	
	@Column(unique = true)
	public String colonneUnique;
	
	
	public Payment() {
	}

	
	public Payment(String cardno, Integer amount, String colonneUnique) {
		super();
		this.cardno = cardno;
		this.amount = amount;
		this.colonneUnique= colonneUnique;
	}


	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}


	public String getColonneUnique() {
		return colonneUnique;
	}


	public void setColonneUnique(String colonneUnique) {
		this.colonneUnique = colonneUnique;
	}


	

}
