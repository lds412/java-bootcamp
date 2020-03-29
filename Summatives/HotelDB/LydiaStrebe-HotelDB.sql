DROP DATABASE IF EXISTS HotelReservation;

CREATE DATABASE HotelReservation;

USE HotelReservation;

CREATE TABLE Guest (
	GuestId INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Address VARCHAR(256) NULL,
    City VARCHAR(100) NULL,
    State CHAR(2) NULL,
    ZipCode VARCHAR(10) NULL,
    PhoneNum CHAR(10) NOT NULL
);

CREATE TABLE Reservation (
	ReservationId INT PRIMARY KEY AUTO_INCREMENT,
    GuestId INT NOT NULL,
    StartDate DATE NOT NULL,
    EndDate DATE NOT NULL,
    FOREIGN KEY fk_Reservation_Guest (GuestId)
		REFERENCES Guest (GuestId)
);

CREATE TABLE RoomSize (
	RoomSizeId INT PRIMARY KEY AUTO_INCREMENT,
    RoomSizeName VARCHAR(50) NOT NULL,
    StandardOccupancy INT NOT NULL,
    MaxOccupancy INT NOT NULL,
    BasePrice DECIMAL(7,3) NOT NULL,
    ExtraPerAdult DECIMAL(6,3) NULL
);

CREATE TABLE Jacuzzi (
	HasJacuzzi BOOL PRIMARY KEY,
    ExtraAmenityCharge DECIMAL(6,3) NULL
);

CREATE TABLE AmenityCombo (
	AmenityComboId INT PRIMARY KEY AUTO_INCREMENT,
    HasRefrigerator BOOL,
    HasMicrowave BOOL,
    HasOven BOOL,
    HasJacuzzi BOOL
);

CREATE TABLE RoomType (
	RoomTypeId INT PRIMARY KEY AUTO_INCREMENT,
	RoomSizeId INT NOT NULL,
    AmenityComboId INT NOT NULL,
    ADA BOOL NOT NULL,
    FOREIGN KEY fk_RoomType_RoomSize (RoomSizeId)
		REFERENCES RoomSize (RoomSizeId),
	FOREIGN KEY fk_RoomType_AmenityCombo (AmenityComboId)
		REFERENCES AmenityCombo (AmenityComboId)
);

CREATE TABLE Room (
	RoomNum CHAR(3) PRIMARY KEY,
    RoomTypeId INT NOT NULL,
    FOREIGN KEY fk_Room_RoomType (RoomTypeId)
		REFERENCES RoomType (RoomTypeId)
);

CREATE TABLE ReservationRoom (
	ReservationId INT NOT NULL,
    RoomNum CHAR(3),
    AdultNum INT NOT NULL,
    ChildNum INT NOT NULL,
    PRIMARY KEY pk_ReservationRoom (ReservationId, RoomNum),
    FOREIGN KEY fk_ReservationRoom_Reservation (ReservationId)
		REFERENCES Reservation (ReservationId),
	FOREIGN KEY fk_ReservationRoom_Room (RoomNum)
		REFERENCES Room (RoomNum)
);