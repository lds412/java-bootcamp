USE HotelReservation;

-- 1. Write a query that returns a 
-- list of reservations that end in July 2023,
-- including the name of the guest, 
-- the room number(s), and the reservation dates.
--------------------
SELECT 
	g.FirstName,
    g.LastName,
    rr.RoomNum,
    r.StartDate,
    r.EndDate
FROM Reservation r
INNER JOIN Guest g ON r.GuestId = g.GuestId
INNER JOIN ReservationRoom rr ON r.ReservationId = rr.ReservationId
WHERE EndDate LIKE '2023-07-__';
--------------------
-- 4 rows

-- 2. Write a query that returns a 
-- list of all reservations for rooms with a jacuzzi,
-- displaying the guest's name, the room number, 
-- and the dates of the reservation. 
--------------------
SELECT 
	g.FirstName,
    g.LastName,
    rm.RoomNum,
    r.StartDate,
    r.EndDate,
    ac.HasJacuzzi
FROM Guest g
INNER JOIN Reservation r ON g.GuestId = r.GuestId
INNER JOIN ReservationRoom rr ON r.ReservationId = rr.ReservationId
INNER JOIN Room rm ON rr.RoomNum = rm.RoomNum
INNER JOIN RoomType rt ON rm.RoomTypeId = rt.RoomTypeId
INNER JOIN AmenityCombo ac ON rt.AmenityComboId = ac.AmenityComboId
WHERE ac.HasJacuzzi = 1;
--------------------
-- 11 rows

-- 3. Write a query that returns 
-- all the rooms reserved for a specific guest, 
-- including the guest's name, the room(s) reserved, 
-- the starting date of the reservation, 
-- and how many people were included in the reservation. 
-- (Choose a guest's name from the existing data.)
--------------------
SELECT 
	g.FirstName,
    g.LastName,
    rr.RoomNum,
    r.StartDate,
    rr.AdultNum + rr.ChildNum NumPeople
FROM Guest g
INNER JOIN Reservation r ON g.GuestId = r.GuestId
INNER JOIN ReservationRoom rr ON r.ReservationId = rr.ReservationId
WHERE g.GuestId = 2;
--------------------
-- 4 rows (for Mack Simmer)

-- 4. Write a query that returns a 
-- list of rooms, reservation ID, 
-- and per-room cost for each reservation. 
-- The results should include all rooms, 
-- whether or not there is a reservation associated with the room.
--------------------
SELECT 
	rm.RoomNum,
    rr.ReservationId,
    -- (Extra columns)
    -- DATEDIFF(r.EndDate, r.StartDate) NumDays,
    -- rs.BasePrice,
    -- IFNULL(j.ExtraAmenityCharge, 0) ExtraAmenityCharge,
    -- IF(rr.AdultNum-rs.StandardOccupancy > 0, rr.AdultNum-rs.StandardOccupancy, 0) ExtraAdults,
    (IF(rr.AdultNum-rs.StandardOccupancy > 0, rr.AdultNum-rs.StandardOccupancy, 0)
 		* IFNULL(rs.ExtraPerAdult, 0) + IFNULL(j.ExtraAmenityCharge, 0) + rs.BasePrice)
        * DATEDIFF(r.EndDate, r.StartDate) RoomCost
FROM Room rm
LEFT OUTER JOIN ReservationRoom rr ON rm.RoomNum = rr.RoomNum
LEFT OUTER JOIN Reservation r ON rr.ReservationId = r.ReservationId
LEFT OUTER JOIN RoomType rt ON rm.RoomTypeId = rt.RoomTypeId
LEFT OUTER JOIN RoomSize rs ON rt.RoomSizeId = rs.RoomSizeId
LEFT OUTER JOIN AmenityCombo ac ON rt.AmenityComboId = ac.AmenityComboId
LEFT OUTER JOIN Jacuzzi j ON ac.HasJacuzzi = j.HasJacuzzi
ORDER BY ISNULL(rr.ReservationId), rr.ReservationId;
--------------------
-- 26 rows

-- 5. Write a query that returns  
-- all the rooms accommodating at least three guests 
-- and that are reserved on any date in April 2023.
--------------------
SELECT 
	rr.RoomNum,
    rr.AdultNum + rr.ChildNum NumGuests,
    r.StartDate,
    r.EndDate
FROM ReservationRoom rr
INNER JOIN Reservation r ON rr.ReservationId = r.ReservationId
WHERE NumGuests >=3 AND (StartDate LIKE '2023-04-__' OR EndDate LIKE '2023-04-__');
--------------------
-- None

-- 6. Write a query that returns a 
-- list of all guest names and the number of reservations per guest, 
-- sorted starting with the guest with the most reservations 
-- and then by the guest's last name.
--------------------
SELECT
	g.FirstName,
    g.LastName,
    COUNT(r.ReservationId) NumReservations
FROM Guest g
INNER JOIN Reservation r ON g.GuestId = r.GuestId
GROUP BY g.GuestId
ORDER BY COUNT(r.ReservationId) DESC, g.LastName;
--------------------
-- 11 rows
-- 2 guests with 3 reservations, 7 with 2 reservations, and 2 with 1 reservation

-- 7. Write a query that displays 
-- the name, address, and phone number of a guest based on their phone number. 
-- (Choose a phone number from the existing data.)
--------------------
SELECT *
FROM Guest
WHERE PhoneNum = '2147300298';
--------------------
-- 1 row (Karie Yang)