package com.sopra.phone_shop.model;

public class OperativeSystemModel
{
	int opId;
	String descrizione;
	String company;
	int opensource;


	public OperativeSystemModel(int opId, String descrizione, String company, int opensource) {
		this.opId = opId;
		this.descrizione = descrizione;
		this.company = company;
		this.opensource = opensource;

	}
	
	public int getOpId() {
		return opId;
	}
	public void setOpId(int opId) {
		this.opId = opId;
	}

	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getOpensource() {
		return opensource;
	}

	public void setOpensource(int opensource) {
		this.opensource = opensource;
	}


	@Override
	public String toString() {
		return "Operative System [nome=" + descrizione + ", opId=" + opId + ", company=" + company
				+ "]";
	}
	
	
}
