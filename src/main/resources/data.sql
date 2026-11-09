-- Seed Customers (10 records)
INSERT INTO customers (first_name, last_name, email, driver_license_number)
VALUES ('John', 'Doe', 'john.doe@example.com', 'DL-123456');

INSERT INTO customers (first_name, last_name, email, driver_license_number)
VALUES ('Jane', 'Smith', 'jane.smith@example.com', 'DL-789012');

INSERT INTO customers (first_name, last_name, email, driver_license_number)
VALUES ('Michael', 'Johnson', 'michael.j@example.com', 'DL-345678');

INSERT INTO customers (first_name, last_name, email, driver_license_number)
VALUES ('Emily', 'Davis', 'emily.d@example.com', 'DL-901234');

INSERT INTO customers (first_name, last_name, email, driver_license_number)
VALUES ('Robert', 'Brown', 'robert.b@example.com', 'DL-567890');

INSERT INTO customers (first_name, last_name, email, driver_license_number)
VALUES ('Jessica', 'Wilson', 'jessica.w@example.com', 'DL-234567');

INSERT INTO customers (first_name, last_name, email, driver_license_number)
VALUES ('William', 'Moore', 'william.m@example.com', 'DL-890123');

INSERT INTO customers (first_name, last_name, email, driver_license_number)
VALUES ('Ashley', 'Taylor', 'ashley.t@example.com', 'DL-456789');

INSERT INTO customers (first_name, last_name, email, driver_license_number)
VALUES ('David', 'Anderson', 'david.a@example.com', 'DL-012345');

INSERT INTO customers (first_name, last_name, email, driver_license_number)
VALUES ('Sarah', 'Thomas', 'sarah.t@example.com', 'DL-678901');


-- Seed Cars (10 records using car_year)
INSERT INTO cars (make, model, car_year, license_plate, daily_rate, status)
VALUES ('Toyota', 'Camry', 2022, 'ABC-123', 55.00, 'AVAILABLE');

INSERT INTO cars (make, model, car_year, license_plate, daily_rate, status)
VALUES ('Honda', 'Civic', 2023, 'XYZ-789', 45.00, 'RENTED');

INSERT INTO cars (make, model, car_year, license_plate, daily_rate, status)
VALUES ('Ford', 'Mustang', 2021, 'FRD-456', 85.00, 'AVAILABLE');

INSERT INTO cars (make, model, car_year, license_plate, daily_rate, status)
VALUES ('Tesla', 'Model 3', 2024, 'TSL-999', 95.00, 'AVAILABLE');

INSERT INTO cars (make, model, car_year, license_plate, daily_rate, status)
VALUES ('Hyundai', 'Elantra', 2022, 'HYU-111', 40.00, 'RENTED');

INSERT INTO cars (make, model, car_year, license_plate, daily_rate, status)
VALUES ('Chevrolet', 'Malibu', 2020, 'CHV-222', 50.00, 'AVAILABLE');

INSERT INTO cars (make, model, car_year, license_plate, daily_rate, status)
VALUES ('Nissan', 'Altima', 2023, 'NSN-333', 52.00, 'AVAILABLE');

INSERT INTO cars (make, model, car_year, license_plate, daily_rate, status)
VALUES ('Subaru', 'Outback', 2022, 'SBR-444', 70.00, 'RENTED');

INSERT INTO cars (make, model, car_year, license_plate, daily_rate, status)
VALUES ('Mazda', 'CX-5', 2023, 'MZD-555', 75.00, 'AVAILABLE');

INSERT INTO cars (make, model, car_year, license_plate, daily_rate, status)
VALUES ('Jeep', 'Wrangler', 2021, 'JEP-666', 90.00, 'AVAILABLE');


-- Seed Rentals (10 records linking customers and cars)
INSERT INTO rentals (customer_id, car_id, start_date, end_date, total_cost, status)
VALUES (1, 2, '2026-11-01', '2026-11-05', 180.00, 'CONFIRMED');

INSERT INTO rentals (customer_id, car_id, start_date, end_date, total_cost, status)
VALUES (2, 1, '2026-11-02', '2026-11-04', 90.00, 'COMPLETED');

INSERT INTO rentals (customer_id, car_id, start_date, end_date, total_cost, status)
VALUES (3, 3, '2026-11-03', '2026-11-10', 595.00, 'ACTIVE');

INSERT INTO rentals (customer_id, car_id, start_date, end_date, total_cost, status)
VALUES (4, 4, '2026-11-04', '2026-11-08', 380.00, 'CONFIRMED');

INSERT INTO rentals (customer_id, car_id, start_date, end_date, total_cost, status)
VALUES (5, 5, '2026-11-05', '2026-11-07', 80.00, 'COMPLETED');

INSERT INTO rentals (customer_id, car_id, start_date, end_date, total_cost, status)
VALUES (6, 6, '2026-11-06', '2026-11-12', 300.00, 'ACTIVE');

INSERT INTO rentals (customer_id, car_id, start_date, end_date, total_cost, status)
VALUES (7, 7, '2026-11-07', '2026-11-11', 208.00, 'CONFIRMED');

INSERT INTO rentals (customer_id, car_id, start_date, end_date, total_cost, status)
VALUES (8, 8, '2026-10-01', '2026-10-07', 420.00, 'COMPLETED');

INSERT INTO rentals (customer_id, car_id, start_date, end_date, total_cost, status)
VALUES (9, 9, '2026-10-02', '2026-10-09', 525.00, 'ACTIVE');

INSERT INTO rentals (customer_id, car_id, start_date, end_date, total_cost, status)
VALUES (10, 10, '2026-10-03', '2026-10-05', 180.00, 'COMPLETED');