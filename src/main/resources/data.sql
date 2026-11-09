-- Seed Customers
INSERT INTO customers (first_name, last_name, email, driver_license_number)
VALUES ('John', 'Doe', 'john.doe@example.com', 'DL-123456');

INSERT INTO customers (first_name, last_name, email, driver_license_number)
VALUES ('Jane', 'Smith', 'jane.smith@example.com', 'DL-789012');

-- Seed Cars (changed 'year' to 'car_year')
INSERT INTO cars (make, model, car_year, license_plate, daily_rate, status)
VALUES ('Toyota', 'Camry', 2022, 'ABC-123', 55.00, 'AVAILABLE');

INSERT INTO cars (make, model, car_year, license_plate, daily_rate, status)
VALUES ('Honda', 'Civic', 2023, 'XYZ-789', 45.00, 'RENTED');

-- Seed Rentals
INSERT INTO rentals (customer_id, car_id, start_date, end_date, total_cost, status)
VALUES (1, 2, '2026-11-01', '2026-11-05', 180.00, 'CONFIRMED');