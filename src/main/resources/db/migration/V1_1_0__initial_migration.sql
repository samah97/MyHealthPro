CREATE TABLE IF NOT EXISTS "users" (
    "id" int  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    "first_name" varchar(50),
    "last_name" varchar(50),
    "email" varchar(255),
    "password" varchar(255),
    "phone_number" varchar(30)
);

CREATE TABLE IF NOT EXISTS "professional" (
    "id" int  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    "user_id" varchar(50)
);

CREATE TABLE IF NOT EXISTS "speciality" (
    "id" int  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    "name" varchar(255)
);


INSERT INTO `speciality` (name) VALUES ('physiotherapist');
INSERT INTO `speciality` (name) VALUES ('nurse');