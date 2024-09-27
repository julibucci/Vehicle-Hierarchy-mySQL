CREATE DATABASE hierarchyVehicle;
USE hierarchyVehicle;

/*Vehicle class*/
CREATE TABLE Vehicle(
id INT AUTO_INCREMENT PRIMARY KEY,  
brand VARCHAR(50) NOT NULL,          
model VARCHAR(50) NOT NULL           
);

/* Truck class*/
CREATE TABLE Truck (
    truck_id INT AUTO_INCREMENT PRIMARY KEY,
    load_capacity INT,
    cabin_size INT,
    vehicle_id INT, 
    FOREIGN KEY (vehicle_id) REFERENCES Vehicle(id)  
);

/*Bus class*/
CREATE TABLE Bus (
    bus_id INT AUTO_INCREMENT PRIMARY KEY,
    seating_capacity INT NOT NULL,
    number_of_doors INT NOT NULL,
    fuel_type VARCHAR(50) NOT NULL,
    vehicle_id INT NOT NULL,
    FOREIGN KEY (vehicle_id) REFERENCES Vehicle(id)
);

/*Airplane class*/
CREATE TABLE Airplane (
    airplane_id INT AUTO_INCREMENT PRIMARY KEY,
    altitude INT NOT NULL,
    passenger_capacity INT NOT NULL,
    fuel_type VARCHAR(50) NOT NULL,
    vehicle_id INT NOT NULL,
    FOREIGN KEY (vehicle_id) REFERENCES Vehicle(id)
);

/*Bicycle class*/
CREATE TABLE Bicycle (
    bicycle_id INT AUTO_INCREMENT PRIMARY KEY,
    number_of_gears INT NOT NULL,
    has_suspension BOOLEAN NOT NULL,
    vehicle_id INT NOT NULL,
    FOREIGN KEY (vehicle_id) REFERENCES Vehicle(id)
);

/*Boat class*/
CREATE TABLE Boat (
    boat_id INT AUTO_INCREMENT PRIMARY KEY,
    max_speed INT NOT NULL,
    length INT NOT NULL,
    has_navigation_system BOOLEAN NOT NULL,
	vehicle_id INT NOT NULL,
    FOREIGN KEY (vehicle_id) REFERENCES Vehicle(id)
);

/*Car class*/
CREATE TABLE Car (
    car_id INT AUTO_INCREMENT PRIMARY KEY,
    doors INT NOT NULL,
    color VARCHAR(50) NOT NULL,
    max_speed INT NOT NULL,
	vehicle_id INT NOT NULL,
    FOREIGN KEY (vehicle_id) REFERENCES Vehicle(id)
);

/*ElectricScooter class*/
CREATE TABLE ElectricScooter (
    electricScooter_id INT AUTO_INCREMENT PRIMARY KEY,
    max_speed INT NOT NULL,
    has_bluetooth BOOLEAN NOT NULL,
    vehicle_id INT NOT NULL,
    FOREIGN KEY (vehicle_id) REFERENCES Vehicle(id)
);

/*Helicopter class*/
CREATE TABLE Helicopter (
    helicopter_id INT AUTO_INCREMENT PRIMARY KEY,
    passenger_capacity INT NOT NULL,
    fuel_type VARCHAR(50) NOT NULL,
    vehicle_id INT NOT NULL,
    FOREIGN KEY (vehicle_id) REFERENCES Vehicle(id)
);

/*Motorcycle class*/
CREATE TABLE Motorcycle (
    motorcycle_id INT AUTO_INCREMENT PRIMARY KEY,
    engine_capacity INT NOT NULL,
    has_windshield BOOLEAN NOT NULL,
    color VARCHAR(50) NOT NULL,
    max_speed INT NOT NULL,
    vehicle_id INT NOT NULL,
    FOREIGN KEY (vehicle_id) REFERENCES Vehicle(id)
);

/* Train class*/
CREATE TABLE Train (
    id INT AUTO_INCREMENT PRIMARY KEY,
    passenger_capacity INT NOT NULL,
    number_of_carriages INT NOT NULL,
    vehicle_id INT, 
    FOREIGN KEY (vehicle_id) REFERENCES Vehicle(id)
);

/*Tram class*/
CREATE TABLE Tram (
    tram_id INT AUTO_INCREMENT PRIMARY KEY,
    number_of_stations INT NOT NULL,
    max_speed DOUBLE NOT NULL,
    has_priority_signal BOOLEAN NOT NULL,
    vehicle_id INT,
    FOREIGN KEY (vehicle_id) REFERENCES Vehicle(id)
);

