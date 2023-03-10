create table series
(
	id int auto_increment
		primary key,
	codigo varchar(8) not null,
	titulo varchar(200) null,
	fecha date not null,
	temporada varchar(45) not null,
	genero varchar(45) not null,
	actores varchar(200) null,
	sinopsis text null,
	constraint id_UNIQUE
		unique (id),
	constraint series_codigo_uindex
		unique (codigo)
);

INSERT INTO series (id, codigo, titulo, fecha, temporada, genero, actores, sinopsis) VALUES (9, '52102', 'Loki', '2021-01-01', '2', 'ciencia ficción', 'Owen Wilson', 'The mercurial villain Loki resumes his role as the God of Mischief in a new series that takes place after the events of “Avengers: Endgame.”');
INSERT INTO series (id, codigo, titulo, fecha, temporada, genero, actores, sinopsis) VALUES (10, '50354', 'Daredevil', '2015-01-02', '3', 'acción', 'Charly Cox', 'A blind lawyer by day, vigilante by night. Matt Murdock fights the crime of New York as Daredevil.');
INSERT INTO series (id, codigo, titulo, fecha, temporada, genero, actores, sinopsis) VALUES (11, '254512', 'The Last of Us', '2023-12-01', '3', 'misterio', 'Anna Torv', 'After a global pandemic destroys civilization, a hardened survivor takes charge of a 14-year-old girl who may be humanity''s last hope.');
INSERT INTO series (id, codigo, titulo, fecha, temporada, genero, actores, sinopsis) VALUES (12, '05412', 'You', '2021-02-01', '3', 'misterio', 'Penn Badgley', 'A dangerously charming, intensely obsessive young man goes to extreme measures to insert himself into the lives of those he is transfixed by.');
INSERT INTO series (id, codigo, titulo, fecha, temporada, genero, actores, sinopsis) VALUES (13, '01246', 'Sex Life', '2021-12-02', '2', 'romántica', 'Sarah Shahi, Mike Vogel', 'A suburban mother of two takes a fantasy-charged trip down memory lane that sets her very married present on a collision course with her wild-child past.');
INSERT INTO series (id, codigo, titulo, fecha, temporada, genero, actores, sinopsis) VALUES (14, '021254', 'South Park', '1991-01-07', '10', 'comedia', 'Trey Parker, Matt Stone', 'Follows the misadventures of four irreverent grade-schoolers in the quiet, dysfunctional town of South Park, Colorado.');
INSERT INTO series (id, codigo, titulo, fecha, temporada, genero, actores, sinopsis) VALUES (15, '02154', 'Grey''s Anatomy', '2005-03-25', '10', 'drama', 'Chandra Wilson', 'A drama centered on the personal and professional lives of five surgical interns and their supervisors.');
INSERT INTO series (id, codigo, titulo, fecha, temporada, genero, actores, sinopsis) VALUES (16, '12545', 'Your Honor', '2010-02-06', '3', 'drama', 'Hope Davis', 'A judge confronts his convictions when his son is involved in a hit-and-run that embroils an organized-crime family.');
INSERT INTO series (id, codigo, titulo, fecha, temporada, genero, actores, sinopsis) VALUES (17, '125412', 'Prueba12', '2010-02-01', '1', 'drama', 'sfdsgd', 'fhfghgfhdtgjh');
