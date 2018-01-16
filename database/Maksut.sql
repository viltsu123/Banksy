-- Maksutapahtuma taulun luontia ja kokeilua.

create table maksutapahtumat(id int PRIMARY KEY not null, kortti_id varchar(8), maksunsaaja varchar(50), pvm varchar(10), hinta int, viesti varchar(255));

-- testi dataa:

insert into maksutapahtumat values(1, '12345678', 'Pirjon Pakari', '22.04.1997', 55, 'Hillomunkkeja 2 ja iso kinuskikakku');
insert into maksutapahtumat values(2, '12345678', 'Dick Johnson', '24.11.2005', 69, 'Cpt. Fawcett private stock partaöljy x 2 30ml pulloa');
insert into maksutapahtumat values(3, '12345678', 'Kaken Kikattajat', '30.08.2009', 12, 'Improvisaatio kurssi');
insert into maksutapahtumat values(4, '12345678', 'Stockman', '04.05.2011', 155, '1 kg nahkiaisia');

insert into maksutapahtumat values(5, '57358955', 'Sinooperi', '04.05.2011', 155, 'lahjapaperia 1 rulla');
insert into maksutapahtumat values(6, '57358955', 'Stockman', '08.05.2015', 6666, 'Miesten turkki, Tommy Hilfiger');
insert into maksutapahtumat values(7, '57358955', 'Teboil', '09.10.2016', 15, 'Kahvi ja pulla');