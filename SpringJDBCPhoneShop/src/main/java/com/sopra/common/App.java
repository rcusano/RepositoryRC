package com.sopra.common;

import com.sopra.phone_shop.dao.BrandDAO;
import com.sopra.phone_shop.dao.CountryDAO;
import com.sopra.phone_shop.dao.OperativeSystemDAO;
import com.sopra.phone_shop.dao.SmartphoneDAO;
import com.sopra.phone_shop.model.BrandModel;
import com.sopra.phone_shop.model.CountryModel;
import com.sopra.phone_shop.model.OperativeSystemModel;
import com.sopra.phone_shop.model.SmartphoneModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class App 
{
    public static void main( String[] args ) throws SQLException {
    	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
    	 
        SmartphoneDAO smartphoneDAO = (SmartphoneDAO) context.getBean("smartphoneDAO");
        OperativeSystemDAO opSystemDAO =( OperativeSystemDAO)  context.getBean("opSystemDAO");
        BrandDAO brandDAO = ( BrandDAO) context.getBean("brandDAO");
        CountryDAO countryDAO = (CountryDAO) context.getBean("countryDAO");

        SmartphoneModel smartphone = new SmartphoneModel (10,"Galaxy S23","6GB","dual-core","8.1",1200,"1870x890","130",1,1);
        smartphoneDAO.insert(smartphone);
        SmartphoneModel smartphone2 = new SmartphoneModel (11,"Galaxy S28","8GB","quad-core","10.2",2000,"1920x1200","118",1,1);
        smartphoneDAO.insert(smartphone2);


        OperativeSystemModel operativeSystem = new OperativeSystemModel (8,"Android","Google",1 );
        opSystemDAO.insert(operativeSystem);

        BrandModel brand = new BrandModel(1,"REALME","CH");
        brandDAO.insert(brand);

        CountryModel country = new CountryModel("ES","Spain");
        countryDAO.insert(country);

        SmartphoneModel smartphone1 = smartphoneDAO.findSmartphoneById(8);
        System.out.println(smartphone1);
        SmartphoneModel smartphone3 = smartphoneDAO.findSmartphoneById(10);
        System.out.println(smartphone3);

        OperativeSystemModel operativeSystem1 = opSystemDAO.findOperativeSystemById(8);
        System.out.println(operativeSystem1);

        BrandModel brandModel1 = brandDAO.findBrandById(1);
        System.out.println(brandModel1);

        CountryModel countryModel1= countryDAO.findCountryByCod( "CH");
        System.out.println(countryModel1);
    }
}
