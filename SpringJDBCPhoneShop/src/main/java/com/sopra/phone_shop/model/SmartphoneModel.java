package com.sopra.phone_shop.model;

public class SmartphoneModel
{
	int smartId;
	String nome;
	String ram;
	String cpuu;
	String displaySize;
	int displayPpi;
	String displayResolution;
	String size;
	int opsysId;
	int brandId;

	
	
	public SmartphoneModel(int smartId, String nome, String ram, String cpuu, String displaySize, int displayPpi, String displayResolution, String size,int opsysId, int brandId) {
		this.smartId = smartId;
		this.nome = nome;
		this.ram = ram;
		this.cpuu = cpuu;
		this.displaySize = displaySize;
		this.displayPpi = displayPpi;
		this.displayResolution = displayResolution;
		this.size = size;
		this.opsysId= opsysId;
		this.brandId=brandId;


	}
	
	public int getSmartId() {
		return smartId;
	}
	public void setSmartId(int smartId) {
		this.smartId = smartId;
	}
	public String getName() {
		return nome;
	}
	public void setName(String nome) {
		this.nome = nome;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getCpuu() {
		return cpuu;
	}

	public void setCpuu(String cpuu) {
		this.cpuu = cpuu;
	}

	public String getDisplaySize() {
		return displaySize;
	}

	public void setDisplaySize(String displaySize) {
		this.displaySize = displaySize;
	}

	public int getDisplayPpi() {
		return displayPpi;
	}

	public void setDisplayPpi(int displayPpi) {
		this.displayPpi = displayPpi;
	}

	public String getDisplayResolution() {
		return displayResolution;
	}

	public void setDisplayResolution(String displayResolution) {
		this.displayResolution = displayResolution;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getOpsysId() {
		return opsysId;
	}

	public void setOpsysId(int opsysId) {
		this.opsysId = opsysId;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	@Override
	public String toString() {
		return "Smartphone [nome=" + nome + ", smartId=" + smartId + ", ram=" + ram
				+ "]";
	}
	
	
}
