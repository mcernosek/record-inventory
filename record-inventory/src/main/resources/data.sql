-- Seeds in memory database with record data 

/*
CREATE TABLE record_collection
(
	id integer NOT NULL,
	artist varchar(255) NOT NULL,
	album varchar(255) NOT NULL,
	year_released integer,
	date_added DATE,
	PRIMARY KEY(id)
);
*/
INSERT INTO record_collection (id, artist, album, year_released, date_added)
VALUES (1001, 'Radiohead', 'In Rainbows', '2007', sysdate());
INSERT INTO record_collection (id, artist, album, year_released, date_added)
VALUES (1002, 'Nirvana', 'Nevermind', '1991', sysdate());
INSERT INTO record_collection (id, artist, album, year_released, date_added)
VALUES (1003, 'Jay-Z', 'The Blueprint', '2001', sysdate());
INSERT INTO record_collection (id, artist, album, year_released, date_added)
VALUES (1004, 'Kacey Musgraves', 'Golden Hour', '2018', sysdate());
INSERT INTO record_collection (id, artist, album, year_released, date_added)
VALUES (1005, 'Miles Davis', 'Kind of Blue', '1959', sysdate());