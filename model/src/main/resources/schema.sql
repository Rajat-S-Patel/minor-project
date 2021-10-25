
CREATE TABLE IF NOT EXISTS user(
    username VARCHAR(50) PRIMARY KEY ,
    first_name VARCHAR(50) NOT NULL ,
    last_name VARCHAR(50) NOT NULL ,
    email VARCHAR(100) NOT NULL UNIQUE ,
    password VARCHAR(50) NOT NULL ,
    date_of_birth DATETIME NOT NULL,
    date_of_registration DATETIME NOT NULL ,
    profile_image_url VARCHAR(100),
    bio VARCHAR(500),
    CHECK (LENGTH(password)>3)
);