/*1.*/ select * from smartphone;
/*2.*/ select nome,ram,size,cpuu from smartphone;
/*3.*/ select * from smartphone where displayResolution = '1080x1920';
/*4.*/ select nome from smartphone where ram = '3GB' and displayResolution = '1080x1920';
/*5.*/ select * from smartphone where nome='Galaxy';
/*6.*/select * from smartphone where nome='Galaxy'and cpuu='dual-core';
/*7.*/select * from smartphone where size >= 150;
/*8.*/select * from smartphone where size < 150;
/*9.*/ select * from smartphone order by displayPpi;
/*10.*/select * from smartphone order by displayPpi desc;
/*11.*/select smartphone.nome,brand.nome from smartphone,brand where smartphone.brand_id = brand.id;
/*12.*/
select nome,opsys_id from smartphone order by nome;
/*13.*/ 
 select nome,descrizione from opsys,smartphone where opsys.id= opsys_id and opsys.descrizione = 'Android' order by nome desc;
 /*14.*/
select smartphone.nome,brand_id,country from smartphone,country,brand where brand_id=brand.id and brand.country=country.cod   order by country;
/*15.*/
select count(nome) from smartphone where ram = '3GB';
/*16.*/
SELECT opsys.descrizione, COUNT(smartphone.nome) FROM smartphone, opsys WHERE opsys.id = smartphone.opsys_id GROUP BY opsys_id;
/*17.*/
SELECT country.nome, COUNT(smartphone.nome) FROM smartphone,country,brand WHERE smartphone.brand_id = brand.id and brand.country=country.cod GROUP BY cod;
/*18. */
SELECT brand.nome,country.nome from brand,country where  country.cod=brand.country;

