INSERT INTO acmeb_user(user_id, username, password_hash, create_date) VALUES (1, 'user1@gmail.com', 'DUMMY', CURRENT_TIMESTAMP());
INSERT INTO acmeb_user(user_id, username, password_hash, create_date) VALUES (2, 'user2@gmail.com', 'DUMMY', CURRENT_TIMESTAMP());

INSERT INTO acmeb_customer(customer_id, customer_name, create_date, user_id) VALUES (1, 'user1', CURRENT_TIMESTAMP(), 1);
INSERT INTO acmeb_customer(customer_id, customer_name, create_date, user_id) VALUES (2, 'user1', CURRENT_TIMESTAMP(), 2);

INSERT INTO acmeb_account(account_id, account_no, currency_code, balance, create_date, user_id) VALUES (1, '12345678', 'HKD', 1000000, CURRENT_TIMESTAMP(), 1);
INSERT INTO acmeb_account(account_id, account_no, currency_code, balance, create_date, user_id) VALUES (2, '88888888', 'HKD', 1000000, CURRENT_TIMESTAMP(), 2);
