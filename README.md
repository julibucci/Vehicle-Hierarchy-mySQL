VEHICLE HIERARCHY DATABASE DESIGN AND RELATIONSHIPS

Created a database called hierarchyVehicle to represent the class hierarchy of vehicles. Defined a main table, Vehicle, that stores common attributes like brand and model. Then, for each subclass (such as Truck, Bus, Airplane, etc.)(relationship one to one), 
created a specific table with its own attributes and a relationship with Vehicle through a foreign key vehicle_id. Added one-to-many relationships between Bus and Passenger, and many-to-many relationships between Vehicle and Owner using an intermediate table VehicleOwner.
