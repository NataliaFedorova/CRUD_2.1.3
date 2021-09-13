################ USERS ##################

CREATE TABLE IF NOT EXISTS users (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name TEXT NOT NULL,
    surname text NOT NULL,
    email text,
    age int NOT NULL);


INSERT INTO users (name, surname, email, age) VALUES
('John', 'Smith', 'js@gmail.com', 23),
('Trisha', 'Vern', 'tv@gmail.com', 44),
('Alexander', 'Ivanov', 'ai@gmail.com', 18);