USE MovieCatalogue;

INSERT INTO Actor (FirstName, LastName, BirthDate) VALUES
    ('Bill','Murray','1950-09-21'),
    ('Dan','Aykroyd','1952-07-01'),
    ('John','Candy','1950-10-31');
    
INSERT INTO Actor (FirstName, LastName) VALUES
    ('Steve','Martin'),
    ('Sylvestor','Stallone');
    
INSERT INTO Director (FirstName, LastName, BirthDate) VALUES
	('Ivan','Reitman','1946-10-27');
    
INSERT INTO Director (FirstName, LastName) VALUES
	('Ted','Kotcheff');
    
INSERT INTO Rating (RatingName) VALUES
	('G'),
    ('PG'),
    ('PG-13'),
    ('R');
    
INSERT INTO Genre (GenreName) VALUES
	('Action'),
    ('Comedy'),
    ('Drama'),
    ('Horror');
    
INSERT INTO Movie (GenreId, DirectorId, RatingId, Title, ReleaseDate) VALUES
	(1, 2, 4, 'Rambo: First Blood', '1982-10-22');

INSERT INTO Movie (GenreId, RatingId, Title, ReleaseDate) VALUES
	(2, 4, 'Planes, Trains & Automobiles', '1987-11-25');

INSERT INTO Movie (GenreId, DirectorId, RatingId, Title) VALUES
	(2, 1, 2, 'Ghostbusters');

INSERT INTO Movie (GenreId, RatingId, Title, ReleaseDate) VALUES
	(2, 2, 'The Great Outdoors', '1988-06-17');    
    
INSERT INTO CastMember (ActorId, MovieId, Role) VALUES
	(5, 1, 'John Rambo'),
    (4, 2, 'Neil Page'),
    (3, 2, 'Del Griffith'),
    (1, 3, 'Dr. Peter Venkman'),
    (2, 3, 'Dr. Raymond Stanz'),
    (2, 4, 'Roman Craig'),
    (3, 4, 'Chet Ripley');