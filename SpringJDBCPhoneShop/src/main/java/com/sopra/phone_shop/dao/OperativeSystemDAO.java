package com.sopra.phone_shop.dao;

import com.sopra.phone_shop.model.OperativeSystemModel;

import java.sql.SQLException;

public interface OperativeSystemDAO
{
	public void insert(OperativeSystemModel opSystem) throws SQLException;
	public OperativeSystemModel findOperativeSystemById(int opId);
}




