-- Inserting Authors
INSERT INTO author (name) VALUES ('J.K. Rowling');
INSERT INTO author (name) VALUES ('George R.R. Martin');
INSERT INTO author (name) VALUES ('J.R.R. Tolkien');
INSERT INTO author (name) VALUES ('Agatha Christie');
INSERT INTO author (name) VALUES ('Stephen King');
INSERT INTO author (name) VALUES ('George Orwell');
INSERT INTO author (name) VALUES ('Dan Brown');
INSERT INTO author (name) VALUES ('Haruki Murakami');
INSERT INTO author (name) VALUES ('Isaac Asimov');
INSERT INTO author (name) VALUES ('Leo Tolstoy');

-- Inserting Books
INSERT INTO book (title, isbn, available, author_id) VALUES ('A Game of Thrones', '9780553103540', TRUE, 2);
INSERT INTO book (title, isbn, available, author_id) VALUES ('Harry Potter and the Philosopher''s Stone', '9780747532699', TRUE, 1);
INSERT INTO book (title, isbn, available, author_id) VALUES ('The Hobbit', '9780547928227', TRUE, 3);
INSERT INTO book (title, isbn, available, author_id) VALUES ('Murder on the Orient Express', '9780062073501', TRUE, 4);
INSERT INTO book (title, isbn, available, author_id) VALUES ('The Shining', '9780307743657', TRUE, 5);
INSERT INTO book (title, isbn, available, author_id) VALUES ('1984', '9780451524935', TRUE, 6);
INSERT INTO book (title, isbn, available, author_id) VALUES ('The Da Vinci Code', '9780307474278', TRUE, 7);
INSERT INTO book (title, isbn, available, author_id) VALUES ('Norwegian Wood', '9780375704024', TRUE, 8);
INSERT INTO book (title, isbn, available, author_id) VALUES ('Foundation', '9780553382563', TRUE, 9);
INSERT INTO book (title, isbn, available, author_id) VALUES ('War and Peace', '9780199232765', TRUE, 10);

-- Inserting borrowers
INSERT INTO borrower (name, address, phone_number, email) VALUES ('Alice Johnson', '123 Maple St, Springfield', '555-1234', 'alice.johnson@example.com');
INSERT INTO borrower (name, address, phone_number, email) VALUES ('Bob Smith', '456 Oak St, Rivertown', '555-5678', 'bob.smith@example.com');
INSERT INTO borrower (name, address, phone_number, email) VALUES ('Charlie Brown', '789 Pine St, Hill Valley', '555-8765', 'charlie.brown@example.com');
INSERT INTO borrower (name, address, phone_number, email) VALUES ('Diana Green', '321 Birch St, Lakewood', '555-4321', 'diana.green@example.com');
INSERT INTO borrower (name, address, phone_number, email) VALUES ('Eve White', '654 Cedar St, Meadowbrook', '555-3456', 'eve.white@example.com');
INSERT INTO borrower (name, address, phone_number, email) VALUES ('Frank Black', '987 Willow St, Brookfield', '555-6543', 'frank.black@example.com');
INSERT INTO borrower (name, address, phone_number, email) VALUES ('Grace Adams', '321 Elm St, Seaside', '555-9876', 'grace.adams@example.com');
INSERT INTO borrower (name, address, phone_number, email) VALUES ('Henry Blue', '123 Cherry St, Clearwater', '555-1357', 'henry.blue@example.com');
INSERT INTO borrower (name, address, phone_number, email) VALUES ('Ivy Gray', '789 Spruce St, Highland', '555-2468', 'ivy.gray@example.com');
INSERT INTO borrower (name, address, phone_number, email) VALUES ('Jack White', '456 Maple Ave, Greenfield', '555-7531', 'jack.white@example.com');

--Inserting transactions
INSERT INTO transaction (book_id, borrower_id, issue_date, due_date, return_date, status)
VALUES
(1, 1, '2025-01-01', '2025-01-15', '2025-01-10', true),
(2, 2, '2025-01-02', '2025-01-16', '2025-01-12', true),
(3, 3, '2025-01-03', '2025-01-17', '2025-01-14', false),
(4, 1, '2025-01-04', '2025-01-18', NULL, false),
(5, 2, '2025-01-05', '2025-01-19', '2025-01-15', true);
