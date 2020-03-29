USE HotelReservation;

INSERT INTO Guest (FirstName, LastName, Address, City, State, ZipCode, PhoneNum) VALUES
	('Lydia', 'Strebe', '1313 Como Ave SE', 'Minneapolis', 'MN', '55414', '6083544011'), -- 1
    ('Mack', 'Simmer', '379 Old Shore Street', 'Council Bluffs', 'IA', '51501', '2915530508'), -- 2
    ('Bettyann', 'Seery', '750 Wintergreen Dr.', 'Wasilla', 'AK', '99654', '4782779632'), -- 3
    ('Duane', 'Cullison', '9662 Foxrun Lane', 'Harlingen', 'TX', '78552', '3084940198'), -- 4
    ('Karie', 'Yang', '9378 W. Augusta Ave.', 'West Deptford', 'NJ', '08096', '2147300298'), -- 5
    ('Aurore', 'Lipton', '762 Wild Rose Street', 'Saginaw', 'MI', '48601', '3775070974'), -- 6
    ('Zachery', 'Luechtefeld', '7 Poplar Dr.', 'Arvada', 'CO', '80003', '8144852615'), -- 7
    ('Jeremiah', 'Pendergrass', '70 Oakwood St.', 'Zion', 'IL', '60099', '2794910960'), -- 8
    ('Walter', 'Holaway', '7556 Arrowhead St.', 'Cumberland', 'RI', '02864', '4463966785'), -- 9
    ('Wilfred', 'Vise', '77 West Surrey Street', 'Oswego', 'NY', '13126', '8347271001'), -- 10
    ('Maritza', 'Tilton', '939 Linda Rd.', 'Burke', 'VA', '22015', '4463516860'), -- 11
    ('Joleen', 'Tison', '87 Queen St.', 'Drexel Hill', 'PA', '19026', '2318932755'); -- 12
    
INSERT INTO Reservation (GuestId, StartDate, EndDate) VALUES
	(2, '2023-02-02', '2023-02-04'), -- 1
    (3, '2023-02-05', '2023-02-10'), -- 2
    (4,	'2023-02-22', '2023-02-24'), -- 3
    (5, '2023-03-06', '2023-03-07'), -- 4
    (1, '2023-03-17', '2023-03-20'), -- 5
    (6,	'2023-03-18', '2023-03-23'), -- 6
    (7,	'2023-03-29', '2023-03-31'), -- 7
    (8,	'2023-03-31', '2023-04-05'), -- 8
    (9,	'2023-04-09', '2023-04-13'), -- 9
    (10, '2023-04-23', '2023-04-24'), -- 10
    (11, '2023-05-30', '2023-06-02'), -- 11
    (12, '2023-06-10', '2023-06-14'), -- 12
   -- (12, '2023-06-10', '2023-06-14'), -- 12
    (6,	'2023-06-17', '2023-06-18'), -- 13
    (1, '2023-06-28', '2023-07-02'), -- 14
    (9, '2023-07-13', '2023-07-14'), -- 15
    (10, '2023-07-18', '2023-07-21'), -- 16
    (3, '2023-07-28', '2023-07-29'), -- 17
    (3, '2023-08-30', '2023-09-01'), -- 18
    (2, '2023-09-16', '2023-09-17'), -- 19
    (5, '2023-09-13', '2023-09-15'), -- 20
    (4, '2023-11-22', '2023-11-25'), -- 21
    (2, '2023-11-22', '2023-11-25'), -- 22
    -- (2, '2023-11-22', '2023-11-25'), -- 22
    (11, '2023-12-24', '2023-12-28'); -- 23
    
INSERT INTO RoomSize (RoomSizeName, StandardOccupancy, MaxOccupancy, BasePrice, ExtraPerAdult) VALUES
	('Single', 2, 2, 149.99, null),
    ('Double', 2, 4, 174.99, 10),
    ('Suite', 3, 8, 399.99, 20);

INSERT INTO Jacuzzi (HasJacuzzi, ExtraAmenityCharge) VALUES
	(0, null),
    (1, 25);
    
INSERT INTO AmenityCombo (HasRefrigerator, HasMicrowave, HasOven, HasJacuzzi) VALUES
	(0, 0, 0, 0), -- 1
    (1, 0, 0, 0), -- 2* (R)
    (0, 1, 0, 0), -- 3
    (0, 0, 1, 0), -- 4
    (0, 0, 0, 1), -- 5
    (1, 1, 0, 0), -- 6* (R,M)
    (1, 0, 1, 0), -- 7
    (1, 0, 0, 1), -- 8
    (0, 1, 1, 0), -- 9
    (0, 1, 0, 1), -- 10* (M,J)
    (0, 0, 1, 1), -- 11
    (1, 1, 1, 0), -- 12* (R,M,O)
    (1, 1, 0, 1), -- 13* (R,M,J)
    (1, 0, 1, 1), -- 14
    (0, 1, 1, 1), -- 15
    (1, 1, 1, 1); -- 16
    
INSERT INTO RoomType (RoomSizeId, AmenityComboId, ADA) VALUES
	(1, 6, 1), -- 1. Single, (R,M), Yes 
    (1, 13, 0), -- 2. Single, (R,M,J), No
    (2, 2, 1), -- 3. Double, (R), Yes
    (2, 10, 0), -- 4. Double, (M,J), No
    (3, 12, 1); -- 5. Suite, (R,M,O), Yes
    
INSERT INTO Room (RoomNum, RoomTypeId) VALUES
	('201', 4),
    ('202', 3),
    ('203', 4),
    ('204', 3),
    ('205', 2),
    ('206', 1),
    ('207', 2),
    ('208', 1),
    ('301', 4),
    ('302', 3),
    ('303', 4),
    ('304', 3),
    ('305', 2),
    ('306', 1),
    ('307', 2),
    ('308', 1),
    ('401', 5),
    ('402', 5);
    
INSERT INTO ReservationRoom (ReservationId, RoomNum, AdultNum, ChildNum) VALUES
	(1, '308', 1, 0), -- 1
    (2, '203', 2, 1), -- 2
    (3, '305', 2, 0), -- 3
    (4, '201', 2, 2), -- 4
    (5, '307', 1, 1), -- 5
    (6, '302', 3, 0), -- 6
    (7, '202', 2, 2), -- 7
    (8, '304', 2, 0), -- 8
    (9, '301', 1, 0), -- 9
    (10, '207', 1, 1), -- 10
    (11, '401', 2, 4), -- 11
    (12, '206', 2, 0), -- 12
    (12, '208', 1, 0), -- 13
    (13, '304', 3, 0), -- 14
    (14, '205', 2, 0), -- 15
    (15, '204', 3, 1), -- 16
    (16, '401', 4, 2), -- 17
    (17, '303', 2, 1), -- 18
    (18, '305', 1, 0), -- 19
    (19, '208', 2, 0), -- 20
    (20, '203', 2, 2), -- 21
    (21, '401', 2, 2), -- 22
    (22, '206', 2, 0), -- 23
    (22, '301', 2, 2), -- 24
	(23, '302', 2, 0); -- 25
    

DELETE FROM ReservationRoom
WHERE ReservationId = 8;

DELETE FROM Reservation
WHERE GuestId = 8;    

DELETE FROM Guest
WHERE GuestId = 8;