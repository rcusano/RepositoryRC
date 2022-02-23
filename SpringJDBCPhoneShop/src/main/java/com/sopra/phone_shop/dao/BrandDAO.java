package com.sopra.phone_shop.dao;

import com.sopra.phone_shop.model.BrandModel;

import java.sql.SQLException;

public interface BrandDAO
{
	public void insert(BrandModel brand) throws SQLException;
	public BrandModel findBrandById(int brandId);
}




