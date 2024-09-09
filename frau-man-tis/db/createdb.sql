CREATE TABLE User
(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY
    name VARCHAR(20)
);

CREATE TABLE Task
(
    id            INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    fromWho      VARCHAR(20) NOT NULL REFERENCES User,
    isDone       BOOL        NOT NULL,
    description  INT         NOT NULL,
    startingTime INT         NOT NULL,
    endTime      INT         NOT NULL
);