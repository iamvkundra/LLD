Database Schema:

Vehicle:
----------------------------------------------------
CREATE TABLE Vehicle (
vehicleId INT PRIMARY KEY AUTO_INCREMENT,
licensePlate VARCHAR(20) UNIQUE NOT NULL,
vehicleType ENUM('Car', 'Motorcycle', 'Truck') NOT NULL,
parkingFactor DECIMAL(3,2) NOT NULL
);
---------------------------------------------------------

---------------------------------------------------------
ParkingSpot:
---------------------------------------------------------
CREATE TABLE ParkingSpot (
spotId INT PRIMARY KEY AUTO_INCREMENT,
spotNumber INT NOT NULL,
isOccupied BOOLEAN DEFAULT FALSE,
vehicleType ENUM('Car', 'Motorcycle', 'Truck') NOT NULL
);
---------------------------------------------------------

Gate table:
---------------------------------------------------------
CREATE TABLE Gate (
gateId INT PRIMARY KEY AUTO_INCREMENT,
gateNumber INT NOT NULL
);
---------------------------------------------------------

Ticket:
---------------------------------------------------------
CREATE TABLE Ticket (
ticketId INT PRIMARY KEY AUTO_INCREMENT,
vehicleId INT NOT NULL,
spotId INT NOT NULL,
entryGateId INT NOT NULL,
entryTime DATETIME NOT NULL,
exitTime DATETIME,
FOREIGN KEY (vehicleId) REFERENCES Vehicle(vehicleId),
FOREIGN KEY (spotId) REFERENCES ParkingSpot(spotId),
FOREIGN KEY (entryGateId) REFERENCES Gate(gateId)
);
----------------------------------------------------------

Payment table:
----------------------------------------------------------
CREATE TABLE Payment (
paymentId INT PRIMARY KEY AUTO_INCREMENT,
ticketId INT NOT NULL,
amount DECIMAL(10,2) NOT NULL,
paymentTime DATETIME NOT NULL,
paymentMethod ENUM('Cash', 'CreditCard') NOT NULL,
FOREIGN KEY (ticketId) REFERENCES Ticket(ticketId)
);
----------------------------------------------------------