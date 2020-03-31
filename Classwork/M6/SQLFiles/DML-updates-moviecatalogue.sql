USE MovieCatalogue;

UPDATE movie SET
	Title = 'Ghostbusters (1984)',
    ReleaseDate = '1984-06-08'
WHERE MovieId = 3;

SELECT *
FROM movie;

UPDATE genre SET
	GenreName = 'Action/Adventure'
WHERE GenreId = 1;

SELECT *
FROM genre;

DELETE FROM castmember
WHERE MovieId = 1;

SELECT *
FROM castmember;

DELETE FROM movie
WHERE MovieId = 1;

SELECT *
FROM movie;

-- Alter the Actor table to add a column DateOfDeath. Set John Candy's record to be 3/4/1994.
ALTER TABLE actor
    ADD COLUMN DateOfDeath DATE NULL;
    
UPDATE actor SET
	DateOfDeath = '1994-03-04'
WHERE ActorId = 3;
    
SELECT * FROM actor;