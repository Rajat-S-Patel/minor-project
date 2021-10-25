
CREATE TABLE IF NOT EXISTS user(
    username VARCHAR(50) PRIMARY KEY ,
    first_name VARCHAR(50) NOT NULL ,
    last_name VARCHAR(50) NOT NULL ,
    email VARCHAR(100) NOT NULL UNIQUE ,
    password VARCHAR(50) NOT NULL ,
    date_of_birth DATE NOT NULL,
    date_of_registration TIMESTAMP NOT NULL ,
    profile_image_url VARCHAR(100),
    bio VARCHAR(500),
    CHECK (LENGTH(password)>3)
);

CREATE TABLE IF NOT EXISTS post(
    post_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL CHECK (LENGTH(title) > 0),
    content LONGTEXT NOT NULL ,
    stars INT DEFAULT 0 NOT NULL ,
    title_image_url VARCHAR(100),
    date_of_post TIMESTAMP NOT NULL ,
    date_of_edit TIMESTAMP NOT NULL ,
    author VARCHAR(50) NOT NULL ,
    FOREIGN KEY (author) REFERENCES user(username)
);