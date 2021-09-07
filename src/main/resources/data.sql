################ USERS ##################

CREATE TABLE IF NOT EXISTS users (
    id MEDIUMINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    firstName TEXT NOT NULL,
    lastName text NOT NULL,
    email text,
    age int NOT NULL);


INSERT INTO users (firstName, lastName, email, age) VALUES
('John', 'Smith', 'js@gmail.com', 23),
('Trisha', 'Vern', 'tv@gmail.com', 44),
('Alexander', 'Ivanov', 'ai@gmail.com', 18);