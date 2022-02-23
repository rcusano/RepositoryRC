package com.sopra.phone_shop.dao;

import com.sopra.phone_shop.model.SmartphoneModel;

import java.sql.SQLException;

public interface SmartphoneDAO
{
	public void insert(SmartphoneModel smartphone) throws SQLException;
	public SmartphoneModel findSmartphoneById(int smartId);
}




