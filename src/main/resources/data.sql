INSERT INTO users (username, password, enabled, account_non_expired, credentials_non_expired, account_non_locked, roles)
VALUES
('alice', '$2a$10$Wz0LZjdAAxl7FQXa2XmrVu8n0PQwD.8XRk9Hny5sjt5bC1rZj9n5C', TRUE, TRUE, TRUE, TRUE, 'PROVIDER'),
('bob', '$2a$10$fDg8sUtfnQA//WuDDve0LeJuWYh1BgKkIRkk6uGDDNmQIbWDVK5UO', TRUE, TRUE, TRUE, TRUE, 'REQUESTOR'),
('carol', '$2a$10$X5f0Kzf.IX8b37uXlYs/4O5ZlB8kPPy5rKIePLyLxe7xC5Pb2ju9m', TRUE, TRUE, TRUE, TRUE, 'PROVIDER,REQUESTOR');

-- Customers
INSERT INTO customers (user_id, phone, email, address) VALUES
(1, '+1234567890', 'alice@example.com', '123 Main St, Springfield'),
(3, '+1987654321', 'carol.customer@example.com', '456 Elm St, Shelbyville');

-- Providers
INSERT INTO providers (user_id, phone, email, address, company_name, service_type) VALUES
(2, '+1098765432', 'bob@example.com', '789 Pine St, Capital City', 'Bob Services Ltd', 'IT Support'),
(3, '+1123456789', 'carol.provider@example.com', '321 Oak St, Springfield', 'Carol Enterprises', 'Marketing');

-- Services
INSERT INTO services (service_name, description, category, price) VALUES
('Web Hosting', 'Reliable web hosting service', 'Hosting', 9.99),
('Cloud Storage', 'Secure 1TB cloud storage', 'Storage', 19.99),
('Email Marketing', 'Effective marketing campaigns', 'Marketing', 29.99);

-- Provider Services
INSERT INTO provider_services (provider_id, service_id, deleted) VALUES
(1, 1, FALSE),
(1, 2, FALSE),
(2, 3, FALSE);
