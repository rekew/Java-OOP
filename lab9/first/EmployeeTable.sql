CREATE TABLE Employee (
    id INT PRIMARY KEY,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    birthDate DATE,
    salary INT
);

INSERT INTO Employee VALUES
(100, 'Alice', 'Smith', '1985-01-15', 60000),
(101, 'Bob', 'Johnson', '1979-03-22', 75000),
(102, 'Carol', 'Williams', '1990-07-09', 50000);
