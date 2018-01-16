-- Taulun luonti kortinhaltijoille:

create table kortinhaltijat(id int PRIMARY KEY not null, 
etunimi varchar(20), sukunimi varchar(20), kortti_id varchar(8), 
saldo int);

-- Testidataa:

insert into kortinhaltijat values (1, 'Matti', 'Tahvanainen', '12345678', 100);