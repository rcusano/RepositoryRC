package com.sopra.phone_shop.model;

public class BrandModel
{
	int brandId;
	String nome;
	String country;




	public BrandModel(int brandId, String nome, String country ) {
		this.brandId = brandId;
		this.nome = nome;
		this.country=country;


	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Brand [nome=" + nome + ", brandId=" + brandId + ", country=" + country + "]";
	}


}
