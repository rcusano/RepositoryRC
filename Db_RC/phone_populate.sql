insert into country(cod,nome)VALUES
 ('KR','South Korea'),
 ('JP','Japan'),
 ('CA','Canada'),
 ('CH','China'),
 ('IT','Italy'),
 ('US','United States'),
 ('SW','Sweden'),
 ('FR','France');

insert into brand(id,nome,country)
VALUES ('1','SAMSUNG','KR'),
	('2','ACER','KR'),
    ('3','AMOI','CH'),
    ('4','HTC','KR'),
    ('5','APPLE','US'),
    ('6','HP','US'),
    ('7','LG','KR'),
    ('8','SONY','JP'),
    ('9','MOTOROLA','US'),
    ('10','NOKIA','SW'),
    ('11','BLACKBERRY','CA'),
    ('12','XIAOMI','CH'),
    ('13','WIKO','FR')
;

insert into opsys(descrizione,company,opensource)
VALUES ('Android','google',1),
		('ios','apple',0),
        ('IOS','apple',0),
        ('Android','google',1),
        ('Windows Phone 9','microsoft',0),
        ('BlackBerry','blackberry',0)
;


insert into smartphone(nome,ram,cpuu,displaySize,displayPpi,displayResolution,size,opsys_id,brand_id)
VALUES ('S22','8GB','dual-core','6.1','1200','1800x700','105','1','1'),
		('S24','4GB','one-core','6.1','1900','1080x1920','157','1','1'),
		('Iphone13','8GB','dual-core','6.1','1400','1800x700','106','3','5'),
		('Iphone12','3GB','quad-core','6.1','1100','1080x1920','170','2','5'),
        ('Galaxy','3GB','3','6.1','1700','1080x1920','150','4','1'),
        ('Galaxy','3GB','dual-core','6.1','1300','1080x1920','122','1','1'),
        ('HTC One M8','2GB','dual-core','6.1','1300','1080x1920','122','5','4'),
        ('Iphone 5S','1GB','dual-core','6.1','1300','630x1136','122','2','5'),
        ('Galaxy S5','2GB','dual-core','6.1','1300','1080x1920','122','4','1')
;



