-- USERS
INSERT INTO application_user (id, username, password, roles, enabled, account_non_expired, credentials_non_expired, account_non_locked, created_at, updated_at)
VALUES
(1, 'rajesh.kumar', 'hashed', 'ROLE_CUSTOMER', true, true, true, true, NOW(), NOW()),
(2, 'pooja.sharma', 'hashed', 'ROLE_CUSTOMER', true, true, true, true, NOW(), NOW()),
(3, 'pandit.omprakash', 'hashed', 'ROLE_PROVIDER', true, true, true, true, NOW(), NOW()),
(4, 'pandit.ajay', 'hashed', 'ROLE_PROVIDER', true, true, true, true, NOW(), NOW());

-- USER INFO
INSERT INTO user_info (user_info_id, user_id, firstname, lastname, phone, email, address, city, created_at, updated_at)
VALUES
(1, 1, 'Rajesh', 'Kumar', '9876543210', 'rajesh.kumar@gmail.com', '23, MG Road', 'Bengaluru', NOW(), NOW()),
(2, 2, 'Pooja', 'Sharma', '9812345678', 'pooja.sharma@gmail.com', 'DLF Phase 2', 'Gurugram', NOW(), NOW()),
(3, 3, 'Om', 'Prakash', '9822012345', 'omprakash.pandit@gmail.com', '17, Hanuman Gali', 'Varanasi', NOW(), NOW()),
(4, 4, 'Ajay', 'Mishra', '9912233445', 'ajay.mishra@gmail.com', '21, Shivaji Nagar', 'Pune', NOW(), NOW());

-- CUSTOMERS
INSERT INTO customer (customer_id, user_id, status, created_at, updated_at)
VALUES
(1, 1, 'ACTIVE', NOW(), NOW()),
(2, 2, 'ACTIVE', NOW(), NOW());

-- PROVIDERS
INSERT INTO provider (provider_id, user_id, about_me, status, created_at, updated_at)
VALUES
(1, 3, '15 years of experience conducting Satyanarayan and Grih Pravesh poojas.', 'ACTIVE', NOW(), NOW()),
(2, 4, 'Expert in Rudrabhishek, Navagraha Shanti and Wedding rituals.', 'ACTIVE', NOW(), NOW());

-- SERVICES
INSERT INTO service (service_id, service_name, description, active, created_at, updated_at)
VALUES
(1, 'Griha Pravesh', 'For housewarming ceremonies', true, NOW(), NOW()),
(2, 'Satyanarayan Pooja', 'For family well-being and prosperity', true, NOW(), NOW()),
(3, 'Rudrabhishek', 'For Lord Shiva’s blessings', true, NOW(), NOW()),
(4, 'Navagraha Shanti', 'To calm the effects of planets', true, NOW(), NOW()),
(5, 'Wedding Pooja', 'Traditional Hindu marriage rituals', true, NOW(), NOW());

-- PROVIDER SERVICES
INSERT INTO provider_service (provider_id, service_id, deleted)
VALUES
(1, 1, false),
(1, 2, false),
(2, 3, false),
(2, 4, false),
(2, 5, false);

-- Insert bookings (explicit IDs so they match sample)
-- Booking 1: Rajesh (customer_id=1) booked service_id=1 (Griha Pravesh)
-- Booking 2: Pooja (customer_id=2) booked service_id=5 (Wedding Pooja)
INSERT INTO public.booking (booking_id, customer_id, service_id, status, remarks, created_at, updated_at)
VALUES
(1, 1, 1, 'BOOKED', 'Griha Pravesh at home', NOW(), NOW()),
(2, 2, 5, 'BOOKED', 'Wedding rituals - basic package', NOW(), NOW());

-- Insert slots for date 2025-10-10 (hourly slots). Some slots reference bookings.
-- For provider 1 (provider_id = 1): slots 08:00-09:00 and 09:00-10:00 are booked by booking_id = 1
-- For provider 2 (provider_id = 2): slots 10:00-11:00 and 11:00-12:00 are booked by booking_id = 2
-- Other slots inserted as AVAILABLE (no booking_id)

INSERT INTO public.slot (provider_id, booking_id, date, start_time, end_time, status, created_at, updated_at)
VALUES
-- Provider 1 (Om Prakash)
(1, 1, '2025-10-10', '08:00:00', '09:00:00', 'BOOKED', NOW(), NOW()),
(1, 1, '2025-10-10', '09:00:00', '10:00:00', 'BOOKED', NOW(), NOW()),
(1, NULL, '2025-10-10', '10:00:00', '11:00:00', 'AVAILABLE', NOW(), NOW()),
(1, NULL, '2025-10-10', '11:00:00', '12:00:00', 'AVAILABLE', NOW(), NOW()),
(1, NULL, '2025-10-10', '12:00:00', '13:00:00', 'AVAILABLE', NOW(), NOW()),

-- Provider 2 (Ajay Mishra)
(2, NULL, '2025-10-10', '08:00:00', '09:00:00', 'AVAILABLE', NOW(), NOW()),
(2, NULL, '2025-10-10', '09:00:00', '10:00:00', 'AVAILABLE', NOW(), NOW()),
(2, 2, '2025-10-10', '10:00:00', '11:00:00', 'BOOKED', NOW(), NOW()),
(2, 2, '2025-10-10', '11:00:00', '12:00:00', 'BOOKED', NOW(), NOW()),
(2, NULL, '2025-10-10', '12:00:00', '13:00:00', 'AVAILABLE', NOW(), NOW());