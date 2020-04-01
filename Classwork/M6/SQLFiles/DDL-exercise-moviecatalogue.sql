CREATE DATABASE MovieCatalogue;

USE MovieCatalogue;

CREATE TABLE Genre (
	GenreId INT PRIMARY KEY AUTO_INCREMENT,
    GenreName VARCHAR(30) NOT NULL
);

CREATE TABLE Director (
	DirectorId INT PRIMARY KEY AUTO_INCREMENT, 
    FirstName VARCHAR(30) NOT NULL,
    LastName VARCHAR(30) NOT NULL,
    BirthDate DATE NULL
);

CREATE TABLE Actor (
	ActorId INT PRIMARY KEY AUTO_INCREMENT, 
    FirstName VARCHAR(30) NOT NULL,
    LastName VARCHAR(30) NOT NULL,
    BirthDate DATE NULL
);

CREATE TABLE Rating (
	RatingId INT PRIMARY KEY AUTO_INCREMENT,
    RatingName CHAR(5) NOT NULL
);

CREATE TABLE Movie (
    MovieId INT PRIMARY KEY AUTO_INCREMENT,
    GenreId INT NOT NUll,
    FOREIGN KEY fk_Movie_Genre (GenreId)
        REFERENCES Genre(GenreId),
    DirectorId INT NULL,
	FOREIGN KEY fk_Movie_Director (DirectorId)
        REFERENCES Director(DirectorId),
	RatingId INT NULL,
    FOREIGN KEY fk_Movie_Rating (RatingId)
        REFERENCES Rating(RatingId),    
    Title VARCHAR(128) NOT NULL,
    ReleaseDate DATE NULL
);	

CREATE TABLE CastMember (
	CastMemberId INT PRIMARY KEY AUTO_INCREMENT,
    ActorId INT NOT NULL,
    FOREIGN KEY fk_CastMembers_Actor (ActorId)
		REFERENCES Actor(ActorId),
	MovieId INT NOT NULL,
	FOREIGN KEY fk_CastMembers_Movie (MovieId)
		REFERENCES Movie(MovieId),
	Role VARCHAR(50) NOT NULL
);