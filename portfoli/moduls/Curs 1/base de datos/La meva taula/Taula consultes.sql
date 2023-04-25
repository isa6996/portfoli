/*adaptaciones de libros: libros, series, cadenas tv, compañia, años de emisión, etc*/
drop database treball;
create database treball;
use treball;


/*quantitat de drets obtinguts per cada cadena: */
select nomCadena, count(*) 
from drets d, cadena c 
where d.codiCadena=c.codiCadena 
group by c.codiCadena;


/*adaptacions que té cada llibre*/
select l.titol, count(*) 
from libro l, adaptaciones a 
where l.isbn=a.isbn 
group by l.titol;


/*Quantes series han començat a emetre abans del 2001 i la cadena que la va emetre*/
select count(*), c.nomCadena
from  drets d, cadena c 
where c.codiCadena=d.codiCadena and year(d.dataEmisio)<2001 group by c.nomCadena;


/* drets que tenen HBO i Netflix*/
select count(*), nomCadena 
from cadena c, drets d 
where c.codiCadena=d.codiCadena and (nomCadena='Netflix' or nomCadena='HBO') 
group by c.codiCadena;



/*màxim de series adaptats en una cadena*/
select count(*), c.nomCadena from cadena c, drets d 
where c.codiCadena=d.codiCadena 
group by c.codiCadena having count(*)=(select count(*) from drets group by codiCadena order by count(*) desc limit 1);



/* la companyia que han fet adaptacions de llibres publicats 1995 al 2000 i els seus titols*/
select distinct c.companyia, l.titol 
from cadena c, drets d, serie s, adaptaciones a, libro l 
where c.codiCadena=d.codiCadena and d.codiSerie=s.codiSerie and s.codiSerie=a.codiSerie and a.isbn=l.isbn
and year(l.any)<=2000 and year(l.any)>=1995;



/*Quines adaptacions té cada llibre (noms)*/
select l.titol as 'llibre', s.titol as 'sèrie' 
from libro l, serie s, adaptaciones a 
where l.isbn=a.isbn and s.codiSerie=a.codiSerie;



/*nom de les series NO adaptades per HBO*/
select distinct s.titol from serie s, drets d, cadena c 
where s.codiSerie=d.codiSerie and c.codiCadena=d.codiCadena 
and titol not in (select s.titol from serie s, drets d where s.codiSerie=d.codiSerie and d.codiCadena =4);



/*La serie i la cadena que ha emet durant més anys*/
select abs(year(d.dataEmisio)-year(d.dataFinal)) as 'anys', s.titol, c.nomCadena 
from serie s, drets d, cadena c 
where d.codiCadena=c.codiCadena and s.codiSerie=d.codiSerie and abs(year(d.dataFinal)-year(d.dataEmisio)) 
order by anys desc limit 1;



/*series i llibres que pertanyen a 'el señor de los anillos'*/
select titol, ('llibre') 'format' from libro where isbn=5
union select titol, 'sèrie' from serie where (codiSerie=6 or codiSerie=8);



/*autors de llibres Japonesos i directors de series de llibres d'EEUU*/
select autor, ('escriptor') 'funció' from libro where pais='Japó'
union select s.director, 'director' from serie s, adaptaciones a, libro l 
where a.isbn=l.isbn and a.codiSerie=s.codiSerie and pais='EEUU';



create table libro (
titol varchar(50),
autor varchar(50),
any date,
pais varchar(50),
editorial varchar(50),
isbn tinyint primary key);



create table serie(
codiSerie tinyint primary key,
titol varchar(50),
director varchar(50),
any date);



create table adaptaciones(
isbn tinyint,
codiSerie tinyint,
primary key (isbn, codiSerie),
foreign key (isbn) references libro(isbn) on update cascade,
foreign key (codiSerie) references serie(codiSerie) on update cascade);


create table cadena(
codiCadena tinyint primary key,
nomCadena varchar(50),
companyia varchar(50));




create table drets(
codiCadena tinyint,
codiSerie tinyint,
dataEmisio date,
dataFinal date,
primary key (codiCadena, codiSerie),
foreign key (codiCadena)references cadena(codiCadena)on update cascade,
foreign key (codiSerie)references serie(codiSerie)on update cascade);


insert into libro value ('sakura','CLAMP','1999-04-03', 'Japó','Norma',1);
insert into libro value ('Ranma','Shogaku','1993-04-01','Japó','Ivrea', 2);
insert into libro value ('Cancion de hielo y fuego', 'George R. R. Martin','1996-06-07','EEUU','editorial Gigameshu',3);
insert into libro value ('Harry Potter',' J. K. Rowling', '1997-06-30','Regne Unit','Salamandra',4);
insert into libro value('Señor de los anillos','J. R. R. Tolkien','1954-09-07','Regne Unit','Ediciones Minotauro',5);


update libro set titol='Rumiko Takahashi' where titol='Shogaku';
update libro set any='1987-8-19' where any='1993-04-01';



insert into serie value (1,'sakura Card Captor','Morio Asaka','1996-05-01');
insert into serie value (2, 'Ranma1-2','Tomomi Mochizuki','1989-04-15');
insert into serie value (3,'Juego de Tronos','David Benioff','2011-04-17');
insert into serie value(4,'Casa de Dragones','Ryan Condal','2022-08-21');
insert into serie value (6,'El señor de los anillos', 'Peter Jackson','2001-08-05');
insert into serie value (8,' El Señor de los Anillos: los Anillos de Poder','J.D.Payne - Patrick McKay','2001-12-01');
insert into serie value (7,'Harry Potter y la piedra Filosofal','Chris Columbus','2001-12-01');



insert into adaptaciones value (1,1);
insert into adaptaciones value (2,2);
insert into adaptaciones value (3,3);
insert into adaptaciones value (3,4);
insert into adaptaciones value (4,6);
insert into adaptaciones value (5,7);
insert into adaptaciones value (5,8);


insert into cadena values (1, 'K3','TV3');
insert into cadena values (2, 'Antena 3', 'Antena 3');
insert into cadena values (3, 'Netflix', 'Netlfix');
insert into cadena values (4, 'HBO', 'Warner Bros. Discovery');
insert into cadena values (5,'Amazon Prime', 'Amazon');


insert into drets values (1,1,'2000-09-18','2000-12-25');
insert into drets values (3,1,'2020-07-01', curdate());
insert into drets values (1,2,'2005-09-15','2008-12-25');
insert into drets values (2,2,'1993-04-15','1995-01-03');
insert into drets values (4,3,'2011-04-17','2019-07-08');
insert into drets values (2,3,'2012-07-17','2013-07-05');
insert into drets values (4,4,'2022-08-21','2022-11-14');
insert into drets values (4,6,'2022-08-21',CURDATE());
insert into drets values (3,7,'2020-05-27','2020-12-01');
insert into drets values (4,7,'2022-08-21',CURDATE());
insert into drets values (5,8,'2022-09-01',CURDATE());
