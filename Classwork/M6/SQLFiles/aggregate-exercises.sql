use PersonalTrainer;

-- Use an aggregate to count the number of Clients.
-- 500 rows
--------------------
SELECT COUNT(*)
FROM Client;

-- Use an aggregate to count Client.BirthDate.
-- The number is different than total Clients. Why?
-- 463 rows
--------------------
SELECT COUNT(BirthDate)
FROM Client;

-- Group Clients by City and count them.
-- Order by the number of Clients desc.
-- 20 rows
--------------------
SELECT
	c.City,
	COUNT(c.ClientId) NumOfClients
FROM Client c
GROUP BY c.City
ORDER BY COUNT(c.ClientId) DESC;

-- Calculate a total per invoice using only the InvoiceLineItem table.
-- Group by InvoiceId.
-- You'll need an expression for the line item total: Price * Quantity.
-- Aggregate per group using SUM().
-- 1000 rows
--------------------
SELECT
	ili.InvoiceId,
    SUM(ili.Price * ili.Quantity) Total
FROM InvoiceLineItem ili
GROUP BY ili.InvoiceId;   

-- Calculate a total per invoice using only the InvoiceLineItem table.
-- (See above.)
-- Only include totals greater than $500.00.
-- Order from lowest total to highest.
-- 234 rows
--------------------
SELECT
	ili.InvoiceId,
    SUM(ili.Price * ili.Quantity) Total
FROM InvoiceLineItem ili
GROUP BY ili.InvoiceId
HAVING SUM(ili.Price * ili.Quantity) > 500
ORDER BY SUM(ili.Price * ili.Quantity);

-- Calculate the average line item total
-- grouped by InvoiceLineItem.Description.
-- 3 rows
--------------------
SELECT
	ili.Description,
    AVG(ili.Price * ili.Quantity) AvgTotal
FROM InvoiceLineItem ili
GROUP BY ili.Description;

-- Select ClientId, FirstName, and LastName from Client
-- for clients who have *paid* over $1000 total.
-- Paid is Invoice.InvoiceStatus = 2.
-- Order by LastName, then FirstName.
-- 146 rows
--------------------
SELECT
	c.ClientId,
    c.FirstName,
    c.LastName,
    SUM(ili.Price * ili.Quantity) Total
FROM Client c
INNER JOIN Invoice i ON c.ClientId = i.ClientId
INNER JOIN InvoiceLineItem ili ON i.InvoiceId = ili.InvoiceId
WHERE i.InvoiceStatus = 2
GROUP BY c.ClientId
HAVING SUM(ili.Price * ili.Quantity) > 1000
ORDER BY c.LastName, c.FirstName;

-- Count exercises by category.
-- Group by ExerciseCategory.Name.
-- Order by exercise count descending.
-- 13 rows
--------------------
SELECT
	ec.`Name` CategoryName,
    COUNT(e.ExerciseId) NumExercises
FROM ExerciseCategory ec
INNER JOIN Exercise e ON ec.ExerciseCategoryId = e.ExerciseCategoryId
GROUP BY ec.`Name`
ORDER BY COUNT(e.ExerciseId) DESC;

-- Select Exercise.Name along with the minimum, maximum,
-- and average ExerciseInstance.Sets.
-- Order by Exercise.Name.
-- 64 rows
--------------------
SELECT
	e.`Name` ExerciseName,
    MIN(ei.Sets) MinSets,
    MAX(ei.Sets) MaxSets,
    AVG(ei.Sets) AvgSets
FROM Exercise e 
LEFT OUTER JOIN ExerciseInstance ei ON e.ExerciseId = ei.ExerciseId
GROUP BY e.ExerciseId
ORDER BY e.`Name`;

-- Find the minimum and maximum Client.BirthDate
-- per Workout.
-- 26 rows
-- Sample: 
-- WorkoutName, EarliestBirthDate, LatestBirthDate
-- '3, 2, 1... Yoga!', '1928-04-28', '1993-02-07'
--------------------
SELECT
	w.`Name` WorkoutName,
    MIN(c.BirthDate) EarliestBirthDate,
    MAX(c.BirthDate) LatestBirthDate
FROM Workout w
INNER JOIN ClientWorkout cw ON w.WorkoutId = cw.WorkoutId
INNER JOIN Client c ON cw.ClientId = c.ClientId
GROUP BY w.WorkoutId;    

-- Count client goals.
-- Be careful not to exclude rows for clients without goals.
-- 500 rows total
-- 50 rows with no goals
--------------------
SELECT
	c.ClientId,
	COUNT(cg.GoalId)
FROM Client c
LEFT OUTER JOIN ClientGoal cg ON c.ClientId = cg.ClientId
GROUP BY c.ClientId
ORDER BY COUNT(cg.GoalId);

-- Select Exercise.Name, Unit.Name, 
-- and minimum and maximum ExerciseInstanceUnitValue.Value
-- for all exercises with a configured ExerciseInstanceUnitValue.
-- Order by Exercise.Name, then Unit.Name.
-- 82 rows
--------------------
SELECT
	e.`Name` ExerciseName,
    u.`Name` UnitName,
    MIN(eiuv.Value) MinValue,
    MAX(eiuv.Value) MaxVaule
FROM Exercise e
INNER JOIN ExerciseInstance ei ON e.ExerciseId = ei.ExerciseId
INNER JOIN ExerciseInstanceUnitValue eiuv ON ei.ExerciseInstanceId = eiuv.ExerciseInstanceId
INNER JOIN Unit u ON eiuv.UnitId = u.UnitId
GROUP BY e.ExerciseId, u.UnitId
ORDER BY e.`Name`, u.`Name`;

-- Modify the query above to include ExerciseCategory.Name.
-- Order by ExerciseCategory.Name, then Exercise.Name, then Unit.Name.
-- 82 rows
--------------------
SELECT
	ec.`Name` ExerciseCategoryName,
    e.`Name` ExerciseName,
    u.`Name` UnitName,
    MIN(eiuv.Value) MinValue,
    MAX(eiuv.Value) MaxVaule
FROM Exercise e
INNER JOIN ExerciseCategory ec ON e.ExerciseCategoryId = ec.ExerciseCategoryId
INNER JOIN ExerciseInstance ei ON e.ExerciseId = ei.ExerciseId
INNER JOIN ExerciseInstanceUnitValue eiuv ON ei.ExerciseInstanceId = eiuv.ExerciseInstanceId
INNER JOIN Unit u ON eiuv.UnitId = u.UnitId
GROUP BY e.ExerciseId, u.UnitId
ORDER BY ec.`Name`, e.`Name`, u.`Name`;

-- Select the minimum and maximum age in years for
-- each Level.
-- To calculate age in years, use the MySQL function DATEDIFF.
-- 4 rows
--------------------
SELECT
	l.`Name` LevelName,
    MIN(DATEDIFF(CURDATE(), c.BirthDate)/365) MinAge,
    MAX(DATEDIFF(CURDATE(), c.BirthDate)/365) MaxAge
FROM Level l
INNER JOIN Workout w ON l.LevelId = w.LevelId
INNER JOIN ClientWorkout cw ON w.WorkoutId = cw.WorkoutId
INNER JOIN Client c ON cw.ClientId = c.ClientId
GROUP BY l.`Name`;

-- Stretch Goal!
-- Count logins by email extension (.com, .net, .org, etc...).
-- Research SQL functions to isolate a very specific part of a string value.
-- 27 rows (27 unique email extensions)
--------------------
SELECT 
	SUBSTRING(EmailAddress, 
		POSITION('.' IN EmailAddress)) Extension,
    COUNT(EmailAddress) ExtNum
FROM Login
GROUP BY SUBSTRING(EmailAddress, 
    POSITION('.' IN EmailAddress));

-- Anser key
SELECT
	SUBSTRING_INDEX(EmailAddress, '.', -1),    
    COUNT(EmailAddress)
FROM Login
GROUP BY SUBSTRING_INDEX(EmailAddress, '.', -1)
ORDER BY COUNT(EmailAddress) DESC;

-- Stretch Goal!
-- Match client goals to workout goals.
-- Select Client FirstName and LastName and Workout.Name for
-- all workouts that match at least 2 of a client's goals.
-- Order by the client's last name, then first name.
-- 139 rows
--------------------
SELECT
	c.FirstName,
    c.LastName,
    w.`Name` WorkoutName,
    COUNT(cg.GoalId) NumGoals
FROM Client c
INNER JOIN ClientGoal cg ON c.ClientId = cg.ClientId
INNER JOIN WorkoutGoal wg ON cg.GoalId = wg.GoalId
INNER JOIN Workout w ON wg.WorkoutId = w.WorkoutId
GROUP BY c.ClientId, w.WorkoutId
HAVING COUNT(cg.GoalId) >= 2
ORDER BY c.LastName, c.FirstName;