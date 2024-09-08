CREATE TABLE Setting
(
    id         INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(50) NOT NULL,
    isEditable BOOL        NOT NULL
);

CREATE TABLE Property
(
    id      INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(50) NOT NULL,
    txvalue VARCHAR(50) NOT NULL,
    setting INT         NOT NULL REFERENCES Setting (id)
);

INSERT INTO Setting (name, isEditable) VALUES ('Text Replacement', true);
INSERT INTO Setting (name, isEditable) VALUES ('Language and Region', true);
INSERT INTO Setting (name, isEditable) VALUES ('Account Info', true);
INSERT INTO Setting (name, isEditable) VALUES ('Styles', true);

INSERT INTO Property (name, txvalue, setting) VALUES ('sgduh', 'Sehr geehrte Damen und Herren', 1);
INSERT INTO Property (name, txvalue, setting) VALUES ('sgf', 'Sehr geehrte Frau', 1);
INSERT INTO Property (name, txvalue, setting) VALUES ('sgh', 'Sehr geehrter Herr', 1);

INSERT INTO Property (name, txvalue, setting) VALUES ('Country', 'AUSTRIA', 2);
INSERT INTO Property (name, txvalue, setting) VALUES ('County', 'UPPER AUSTRIA', 2);
INSERT INTO Property (name, txvalue, setting) VALUES ('Language', 'English (US)', 2);
INSERT INTO Property (name, txvalue, setting) VALUES ('Corrency', '€', 2);