/*adaptaciones de libros: libros, series, cadenas tv, compañia*/
create database treball;
use treball;
drop database treball;

insert into libro value ('sakura','CLAMP',03/04/1999, 'Japó','Norma',1);
insert into libro value ('Ranma','Shogaku',01/04/1993,'Japó','Ivrea', 2);
insert into libro value ('Cancion de hielo y fuego', 'George R. R. Martin',07/06/1996,'EEUU','editorial Gigameshu',3);
insert into libro value('Señor de los anillos','J. R. R. Tolkien',7/9/1954,'Regne Unit','Ediciones Minotauro',5);

alter table libro modify titol varchar(25);
update libro set titol='Rumiko Takahashi' where titol='Shogaku';
update libro set any=19/8/1987 where any=01/04/1993;

create table libro (
titol varchar(10),
autor varchar(25),
any date,
pais varchar(25),
editorial varchar(25),
isbn tinyint primary key);


insert into serie value (1,'sakura Card Captor','Morio Asaka');
insert into serie value (2, 'Ranma1/2','Tomomi Mochizuki');
insert into serie value (3,'Juego de Tronos','David Benioff');
insert into serie value(4,'Casa de Dragones','Ryan Condal');
insert into serie value (6,'El señor de los anillos', 'Peter Jackson');
insert into serie value (8,' El Señor de los Anillos: los Anillos de Poder','J.D.Payne / Patrick McKay');

alter table serie add any varchar(50);
alter table serie modify titol varchar(50);
update serie set any='01/05/1996' where codiSerie=1;
update serie set any='15/04/1989' where codiSerie=2;
update serie set any='17/4/2011' where codiSerie=3;
update serie set any='21/08/2022' where codiSerie=4;
update serie set any='01/12/2001' where codiSerie=7;
update serie set any='01/12/2001' where codiSerie=8;

create table serie(
codiSerie tinyint primary key,
titol varchar(25),
director varchar(25),
any date);


drop table adaptaciones;
insert into adaptaciones value (1,1);
insert into adaptaciones value (2,2);
insert into adaptaciones value (3,3);
insert into adaptaciones value (3,4);
insert into adaptaciones value (5,7);
insert into adaptaciones value (5,8);

create table adaptaciones(
isbn tinyint,
codiSerie tinyint,
primary key (isbn, codiSerie),
foreign key (isbn) references libro(isbn) on update cascade,
foreign key (codiSerie) references serie(codiSerie) on update cascade);


insert into cadena values (1, 'K3','TV3');
insert into cadena values (2, 'Antena 3', 'Antena 3');
insert into cadena values (3, 'Netflix', 'Netlfix');
insert into cadena values (4, 'HBO', 'Warner Bros. Discovery');
insert into cadena values (5,'Amazon Prime', 'Amazon');

create table cadena(
codiCadena tinyint primary key,
nomCadena varchar(25),
companyia varchar(25));

select* from drets;
drop table drets;

insert into drets values (1,1,'01/05/1996','01/06/2000');
insert into drets value (3,1,'01/07/2020','actual');
insert into drets values (1,2,'15/04/1993','25/12/2008');
insert into drets values (2,2,'15/04/1993','04/08/1998');
insert into drets values (4,3,'17/4/2011','08/7/2019');
insert into drets values (2,3,'17/07/2012','05/07/2013');
insert into drets values (4,4,'21/08/2022','actual');
insert into drets values (4,6,'21/08/2022','actual');
insert into drets values (3,7,'27/05/2020','01.12.2020');
insert into drets values (4,7,'21/05/2022','actual');
insert into drets values (5,8,'01/09/2022','actual');

update drets set dataFinal='03/01/1995' where dataFinal='04/08/1998';
update drets set dataEmisio='18/09/2000' where dataEmisio='01/05/1996';
update drets set dataFinal='25/12/2000' where dataFinal='01/06/2000';

create table drets(
codiCadena tinyint,
codiSerie tinyint,
dataEmisio varchar(50),
dataFinal varchar(50),
primary key (codiCadena, codiSerie),
foreign key (codiCadena)references cadena(codiCadena)on update cascade,
foreign key (codiSerie)references serie(codiSerie)on update cascade);


