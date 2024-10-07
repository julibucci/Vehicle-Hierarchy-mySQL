CREATE DATABASE hierarchyVehicle;
USE hierarchyVehicle;

/* Vehicle class */
CREATE TABLE Vehicle (
    id INT AUTO_INCREMENT PRIMARY KEY,
    brand VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL
);

/* Truck class */
CREATE TABLE Truck (
    truck_id INT AUTO_INCREMENT PRIMARY KEY,
    load_capacity INT,
    cabin_size INT,
    vehicle_id INT UNIQUE, 
    FOREIGN KEY (vehicle_id) REFERENCES Vehicle(id)
);

/* Bus class */
CREATE TABLE Bus (
    bus_id INT AUTO_INCREMENT PRIMARY KEY,
    seating_capacity INT NOT NULL,
    number_of_doors INT NOT NULL,
    fuel_type VARCHAR(50) NOT NULL,
    vehicle_id INT UNIQUE NOT NULL,
    FOREIGN KEY (vehicle_id) REFERENCES Vehicle(id)
);

/* Passenger class for 1:N relationship with Bus- La clase Bus puede tener muchos Passenger */
CREATE TABLE Passenger (
    passenger_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    bus_id INT,
    FOREIGN KEY (bus_id) REFERENCES Bus(bus_id)
);

/* Airplane class */
CREATE TABLE Airplane (
    airplane_id INT AUTO_INCREMENT PRIMARY KEY,
    altitude INT NOT NULL,
    passenger_capacity INT NOT NULL,
    fuel_type VARCHAR(50) NOT NULL,
    vehicle_id INT UNIQUE NOT NULL,
    FOREIGN KEY (vehicle_id) REFERENCES Vehicle(id)
);

/* Bicycle class */
CREATE TABLE Bicycle (
    bicycle_id INT AUTO_INCREMENT PRIMARY KEY,
    number_of_gears INT NOT NULL,
    has_suspension BOOLEAN NOT NULL,
    vehicle_id INT UNIQUE NOT NULL,
    FOREIGN KEY (vehicle_id) REFERENCES Vehicle(id)
);

/* Boat class */
CREATE TABLE Boat (
    boat_id INT AUTO_INCREMENT PRIMARY KEY,
    max_speed INT NOT NULL,
    length INT NOT NULL,
    has_navigation_system BOOLEAN NOT NULL,
    vehicle_id INT UNIQUE NOT NULL,
    FOREIGN KEY (vehicle_id) REFERENCES Vehicle(id)
);

/* Car class */
CREATE TABLE Car (
    car_id INT AUTO_INCREMENT PRIMARY KEY,
    doors INT NOT NULL,
    color VARCHAR(50) NOT NULL,
    max_speed INT NOT NULL,
    vehicle_id INT UNIQUE NOT NULL,
    FOREIGN KEY (vehicle_id) REFERENCES Vehicle(id)
);

/* ElectricScooter class */
CREATE TABLE ElectricScooter (
    electricScooter_id INT AUTO_INCREMENT PRIMARY KEY,
    max_speed INT NOT NULL,
    has_bluetooth BOOLEAN NOT NULL,
    vehicle_id INT UNIQUE NOT NULL,
    FOREIGN KEY (vehicle_id) REFERENCES Vehicle(id)
);

/* Helicopter class */
CREATE TABLE Helicopter (
    helicopter_id INT AUTO_INCREMENT PRIMARY KEY,
    passenger_capacity INT NOT NULL,
    fuel_type VARCHAR(50) NOT NULL,
    vehicle_id INT UNIQUE NOT NULL,
    FOREIGN KEY (vehicle_id) REFERENCES Vehicle(id)
);

/* Owner class for N:M relationship with Vehicle */
CREATE TABLE Owner 
(
    owner_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

/* Junction table for N:M relationship between Vehicle and Owner - Tabla intermedia */
CREATE TABLE VehicleOwner (
    vehicle_id INT,
    owner_id INT,
    PRIMARY KEY (vehicle_id, owner_id),
    FOREIGN KEY (vehicle_id) REFERENCES Vehicle(id),
    FOREIGN KEY (owner_id) REFERENCES Owner(owner_id)
);

/*1. 10 statements for insertion.*/
INSERT INTO Vehicle (brand, model) VALUES ('Mercedes-Benz', 'Actros');
INSERT INTO Truck (load_capacity, cabin_size, vehicle_id) VALUES (12000, 2, 1);

INSERT INTO Vehicle (brand, model) VALUES ('Volvo', '9700');
INSERT INTO Bus (seating_capacity, number_of_doors, fuel_type, vehicle_id) VALUES (50, 2, 'Diesel', 2);

INSERT INTO Passenger (name, bus_id) VALUES ('Juan Perez', 1);
INSERT INTO Passenger (name, bus_id) VALUES ('Maria Lopez', 1);

INSERT INTO Vehicle (brand, model) VALUES ('Boeing', '747');
INSERT INTO Airplane (altitude, passenger_capacity, fuel_type, vehicle_id) VALUES (35000, 400, 'Jet Fuel', 3);

INSERT INTO Vehicle (brand, model) VALUES ('Giant', 'Escape 3');
INSERT INTO Bicycle (number_of_gears, has_suspension, vehicle_id) VALUES (21, FALSE, 4);

INSERT INTO Vehicle (brand, model) VALUES ('Yamaha', '242X');
INSERT INTO Boat (max_speed, length, has_navigation_system, vehicle_id) VALUES (50, 24, TRUE, 5);

INSERT INTO Vehicle (brand, model) VALUES ('Tesla', 'Model S');
INSERT INTO Car (doors, color, max_speed, vehicle_id) VALUES (4, 'Red', 250, 6);

INSERT INTO Vehicle (brand, model) VALUES ('Xiaomi', 'Mi Electric Scooter');
INSERT INTO ElectricScooter (max_speed, has_bluetooth, vehicle_id) VALUES (25, TRUE, 7);

INSERT INTO Vehicle (brand, model) VALUES ('Airbus', 'H125');
INSERT INTO Helicopter (passenger_capacity, fuel_type, vehicle_id) VALUES (6, 'Aviation Fuel', 8);

INSERT INTO Owner (name) VALUES ('Maria Gomez');
INSERT INTO VehicleOwner (vehicle_id, owner_id) VALUES (1, 1);

/*2. 10 statements for updating.*/
UPDATE Truck SET load_capacity = 15000 WHERE truck_id = 1;
UPDATE Passenger SET name = 'Juan Carlos Perez' WHERE passenger_id = 1;
UPDATE Bus SET number_of_doors = 3 WHERE bus_id = 1;
UPDATE Car SET color = 'Blue' WHERE car_id = 1;
UPDATE Airplane SET fuel_type = 'Biofuel' WHERE airplane_id = 1;
UPDATE Owner SET name = 'María Gabriela Gomez' WHERE owner_id = 1;
UPDATE Boat SET max_speed = 55 WHERE boat_id = 1;
UPDATE Helicopter SET passenger_capacity = 8 WHERE helicopter_id = 1;
UPDATE Bicycle SET number_of_gears = 18 WHERE bicycle_id = 1;
UPDATE ElectricScooter SET max_speed = 30 WHERE electricScooter_id = 1;

/*3. 10 statements for deletions.*/
DELETE FROM Car WHERE car_id = 1;
DELETE FROM Truck WHERE truck_id = 1;
DELETE FROM Passenger WHERE passenger_id = 1;
DELETE FROM Airplane WHERE airplane_id = 1;
DELETE FROM ElectricScooter WHERE electricScooter_id = 1;
DELETE FROM Boat WHERE boat_id = 1;
DELETE FROM Bicycle WHERE bicycle_id = 1;
DELETE FROM Helicopter WHERE helicopter_id = 1;
DELETE FROM VehicleOwner WHERE vehicle_id = 1 AND owner_id = 1;
/* Elimina primero la relación del propietario en la tabla VehicleOwner */
DELETE FROM VehicleOwner WHERE owner_id = 1;
/* Luego puedes eliminar el propietario de la tabla Owner */
DELETE FROM Owner WHERE owner_id = 1;

/*4. 5 alter table.*/
ALTER TABLE Vehicle
ADD COLUMN fuel_type VARCHAR(50); 

ALTER TABLE Truck
MODIFY COLUMN load_capacity DECIMAL(10, 2); -- Cambiar tipo de dato

ALTER TABLE Bus
ADD CONSTRAINT unique_seating_doors UNIQUE (seating_capacity, number_of_doors); 

ALTER TABLE Boat
DROP COLUMN has_navigation_system; 

ALTER TABLE Helicopter 
ADD COLUMN rotor_diameter INT;

/*5.  1 big statement to join all tables in the database.*/
SELECT 
    v.id AS vehicle_id, v.brand, v.model, v.fuel_type,
    t.truck_id, t.load_capacity, t.cabin_size,
    b.bus_id, b.seating_capacity, b.number_of_doors, b.fuel_type AS bus_fuel_type,
    p.passenger_id, p.name AS passenger_name,
    a.airplane_id, a.altitude, a.passenger_capacity AS airplane_passenger_capacity, a.fuel_type AS airplane_fuel_type,
    bi.bicycle_id, bi.number_of_gears, bi.has_suspension,
    bo.boat_id, bo.max_speed, bo.length,
    c.car_id, c.doors, c.color, c.max_speed AS car_max_speed,
    es.electricScooter_id, es.max_speed AS scooter_max_speed, es.has_bluetooth,
    h.helicopter_id, h.passenger_capacity AS helicopter_passenger_capacity, h.fuel_type AS helicopter_fuel_type,
    o.owner_id, o.name AS owner_name
FROM Vehicle v
LEFT JOIN Truck t ON v.id = t.vehicle_id
LEFT JOIN Bus b ON v.id = b.vehicle_id
LEFT JOIN Passenger p ON b.bus_id = p.bus_id
LEFT JOIN Airplane a ON v.id = a.vehicle_id
LEFT JOIN Bicycle bi ON v.id = bi.vehicle_id
LEFT JOIN Boat bo ON v.id = bo.vehicle_id
LEFT JOIN Car c ON v.id = c.vehicle_id
LEFT JOIN ElectricScooter es ON v.id = es.vehicle_id
LEFT JOIN Helicopter h ON v.id = h.vehicle_id
LEFT JOIN VehicleOwner vo ON v.id = vo.vehicle_id
LEFT JOIN Owner o ON vo.owner_id = o.owner_id;

/*6. 5 statements with left, right, inner, outer joins.*/
/* LEFT JOIN*/
SELECT v.brand, v.model, h.passenger_capacity, h.fuel_type
FROM Vehicle v
LEFT JOIN Helicopter h ON v.id = h.vehicle_id;

/*RIGHT JOIN*/
SELECT v.brand, v.model, b.seating_capacity, b.fuel_type
FROM Vehicle v
RIGHT JOIN Bus b ON v.id = b.vehicle_id;

/* INNER JOIN*/
SELECT v.brand, v.model, t.load_capacity, t.cabin_size
FROM Vehicle v
INNER JOIN Truck t ON v.id = t.vehicle_id;

/*LEFT JOIN*/
SELECT v.brand, v.model, c.color, c.max_speed, o.name AS owner_name
FROM Vehicle v
LEFT JOIN Car c ON v.id = c.vehicle_id
LEFT JOIN VehicleOwner vo ON v.id = vo.vehicle_id
LEFT JOIN Owner o ON vo.owner_id = o.owner_id;

/*FULL OUTER JOIN*/
SELECT v.brand, v.model, bi.number_of_gears, bi.has_suspension
FROM Vehicle v
LEFT JOIN Bicycle bi ON v.id = bi.vehicle_id
UNION
SELECT v.brand, v.model, bi.number_of_gears, bi.has_suspension
FROM Vehicle v
RIGHT JOIN Bicycle bi ON v.id = bi.vehicle_id;

/*7. 7 statements with aggregate functions and group by and without having.*/
SELECT brand, COUNT(*) AS total_vehicles
FROM Vehicle
GROUP BY brand;

SELECT fuel_type, SUM(seating_capacity) AS total_seating_capacity
FROM Bus
GROUP BY fuel_type;

SELECT cabin_size, AVG(load_capacity) AS avg_load_capacity
FROM Truck
GROUP BY cabin_size;

SELECT fuel_type, MAX(altitude) AS max_altitude
FROM Airplane
GROUP BY fuel_type;

SELECT has_suspension, MIN(number_of_gears) AS min_gears
FROM Bicycle
GROUP BY has_suspension;

SELECT bus_id, COUNT(*) AS total_passengers
FROM Passenger
GROUP BY bus_id;

SELECT v.model, COUNT(o.owner_id) AS total_owners
FROM Vehicle v
LEFT JOIN VehicleOwner vo ON v.id = vo.vehicle_id
LEFT JOIN Owner o ON vo.owner_id = o.owner_id
GROUP BY v.model;

/*8. 7 statements with aggregate functions and group by and with having.*/
SELECT brand, COUNT(*) AS total_vehicles
FROM Vehicle
GROUP BY brand
HAVING COUNT(*) > 2;

SELECT fuel_type, SUM(seating_capacity) AS total_seating_capacity
FROM Bus
GROUP BY fuel_type
HAVING SUM(seating_capacity) > 100;

SELECT cabin_size, AVG(load_capacity) AS avg_load_capacity
FROM Truck
GROUP BY cabin_size
HAVING AVG(load_capacity) > 10000;

SELECT fuel_type, MAX(altitude) AS max_altitude
FROM Airplane
GROUP BY fuel_type
HAVING MAX(altitude) > 30000;

SELECT has_suspension, MIN(number_of_gears) AS min_gears
FROM Bicycle
GROUP BY has_suspension
HAVING MIN(number_of_gears) > 15;

SELECT bus_id, COUNT(*) AS total_passengers
FROM Passenger
GROUP BY bus_id
HAVING COUNT(*) > 3;

SELECT v.model, COUNT(o.owner_id) AS total_owners
FROM Vehicle v
LEFT JOIN VehicleOwner vo ON v.id = vo.vehicle_id
LEFT JOIN Owner o ON vo.owner_id = o.owner_id
GROUP BY v.model
HAVING COUNT(o.owner_id) > 1;


