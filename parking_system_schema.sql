CREATE DATABASE ParkingDB;
USE ParkingDB;

-- Table for storing parking slots
CREATE TABLE parking_slots (
    slot_id INT PRIMARY KEY AUTO_INCREMENT,
    slot_number VARCHAR(10) NOT NULL,
    is_occupied BOOLEAN DEFAULT FALSE
);

-- Table for storing vehicle entries
CREATE TABLE vehicles (
    vehicle_id INT PRIMARY KEY AUTO_INCREMENT,
    license_plate VARCHAR(20) NOT NULL UNIQUE,
    entry_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    exit_time TIMESTAMP NULL,
    slot_id INT,
    parking_fee DECIMAL(10,2),
    FOREIGN KEY (slot_id) REFERENCES parking_slots(slot_id)
);
