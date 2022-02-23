package com.sopra.phone_shop.dao;

import com.sopra.phone_shop.model.CountryModel;


import java.sql.SQLException;

public interface CountryDAO
{
	public void insert(CountryModel country) throws SQLException;
	public CountryModel findCountryByCod(String countryCod);
}




