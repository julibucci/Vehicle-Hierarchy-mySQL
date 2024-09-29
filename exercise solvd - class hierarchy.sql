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


