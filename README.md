VEHICLE HIERARCHY DATABASE DESIGN AND RELATIONSHIPS

Created a database called hierarchyVehicle to represent the class hierarchy of vehicles. Defined a main table, Vehicle, that stores common attributes like brand and model. Then, for each subclass (such as Truck, Bus, Airplane, etc.)(relationship one to one), 
created a specific table with its own attributes and a relationship with Vehicle through a foreign key vehicle_id. Added one-to-many relationships between Bus and Passenger, and many-to-many relationships between Vehicle and Owner using an intermediate table VehicleOwner.

IGenericDAO<T, K>
Purpose: A generic interface that defines basic CRUD operations for any entity.
Main methods: insert(), findById(), findAll(), update(), delete().
Establishes a contract for implementing operations on entities in any DAO.

AbstractDAOClass<T, K>
Purpose: An abstract class that provides base implementation for CRUD operations on any entity.
Implemented methods: findById(), findAll(), delete().
Abstract methods: getFindByIdQuery(), getFindAllQuery(), getDeleteQuery(), setIdInStatement(), mapResultSetToEntity().
Serves as the base for specific entity DAOs, handling common data access logic while allowing customization through abstract methods.

VehicleDAO
Purpose: A specific DAO for handling CRUD operations on the Vehicle entity.
Main methods: Implements inherited methods from AbstractDAOClass to insert, retrieve, update, and delete vehicles.
Interacts directly with the Vehicle table in the database, using specific SQL queries to manage vehicle data.

VehicleServiceImpl
Purpose: A service layer class that handles business logic related to vehicles.
Main methods: addVehicle(), getVehicleById(), getAllVehicles(), updateVehicle(), removeVehicle().
Abstracts business logic, using IGenericDAO<Vehicle, Integer> to perform operations on vehicles, decoupling business logic from data access.

Vehicle
Purpose: A class representing the Vehicle entity in the system.
Attributes: id, brand, model.

ConnectionPool
Purpose: A class that manages a connection pool to the database using Apache Commons DBCP.
Main method: getDataSource().
Optimizes database connection management by reusing connections, improving application performance.

Exercise 1: XML and XSD Creation
-Created an XML file (vehicles.xml) representing a vehicle hierarchy.(located in the Resources folder)
-Developed an XSD schema (vehicles.xsd) to validate the structure of the XML file.(located in the Resources folder)

Exercise 2: XML Validation
-Implemented an XMLValidator class to validate the XML file against the XSD schema.
-Checked the validity of the XML file and provided feedback on validation results.

Exercise 3: XML Parsing
-Created an XMLParser class to parse the validated XML file.
-Extracted vehicle details (ID, brand, model, etc.) from the XML file.
-Displayed the extracted information in the console for verification.
