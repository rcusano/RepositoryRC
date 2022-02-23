package com.sopra.phone_shop.model;

public class CountryModel
{
	String countryCod;
	String nome;




	public CountryModel(String countryCod, String nome) {
		this.countryCod = countryCod;
		this.nome = nome;

	}

	public String getCountryCod() {
		return countryCod;
	}

	public void setCountryCod(String countryCod) {
		this.countryCod = countryCod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Country [nome=" + nome + ", countryCod=" + countryCod + "]";
	}
	
	
}
