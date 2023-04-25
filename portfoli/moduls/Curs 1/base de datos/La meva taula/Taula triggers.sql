create database treball;
use treball;
drop database treball;

select *from numero_adaptacions;
update libro set isbn=31 where isbn=3;
select* from adaptaciones;

-- els triggers serveixen per tenir un comptador d'adaptacions dels llibres
-- i es vagi actualitzant cada cop que s'actualitzi la base de dades principal
show triggers;
-- aquest trigger serveix per anyadir adaptacions per primera vegada i cada cop que es vagin afegint noves
delimiter //
create trigger crear_contador before insert on adaptaciones for each row
	begin
		if ((select count(*) from adaptaciones where isbn=new.isbn)=0) then
			insert into numero_adaptacions values (new.isbn, 1);
		else 
			update numero_adaptacions set isbn=new.isbn, adaptacions=adaptacions+1 where isbn=new.isbn;
		end if;
	end //
delimiter ;


select *from numero_adaptacions;
update adaptaciones set codiSerie=2 where codiSerie=1;
select* from adaptaciones;
-- serveix per modificar el comptador d'adaptacions cada cop que es vol canviar el contingut
delimiter //
create trigger actaulitzar_dades after update on adaptaciones for each row
	begin
		if((select count(isbn) from adaptaciones where isbn=old.isbn)>0 and (select count(isbn) from adaptaciones where isbn=new.isbn)>1) then
        update numero_adaptacions set adaptacions=(select count(isbn) from adaptaciones where isbn=old.isbn) where isbn=old.isbn;
        update numero_adaptacions set adaptacions=(select count(isbn) from adaptaciones where isbn=new.isbn) where isbn=new.isbn;
        end if;
        
		if((select count(isbn) from adaptaciones where isbn=old.isbn)=0) then		 
        delete from numero_adaptacions where isbn=old.isbn;
        update numero_adaptacions set adaptacions=(select count(isbn) from adaptaciones where isbn=old.isbn) where isbn=old.isbn;
        end if;
        
        if((select count(isbn) from adaptaciones where isbn=new.isbn)=1) then
        insert into numero_adaptacions values (new.isbn, (select count(isbn) from adaptaciones where isbn=new.isbn)) ;
        update numero_adaptacions set adaptacions=(select count(isbn) from adaptaciones where isbn=new.isbn) where isbn=new.isbn;
        end if;
        
	end //
delimiter ;

-- aquest serveix per fer que es vagin borrant i es descomptin cada cop que es treu una adaptació de la taula ADAPTACIONES
delimiter //
create trigger borrar_contador after delete on adaptaciones for each row
	begin
		if ((select count(*) from adaptaciones where isbn=old.isbn)=0) then
			delete from numero_adaptacions where isbn=old.isbn;
		else 
			update numero_adaptacions set isbn=old.isbn, adaptacions=adaptacions-1 where isbn=old.isbn;
		end if;
	end //
delimiter ;

select*from numero_adaptacions;

create table numero_adaptacions (
isbn int,
adaptacions int);


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
