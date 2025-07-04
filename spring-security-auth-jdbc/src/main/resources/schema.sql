CREATE TABLE IF NOT EXISTS authorities (
    id INT AUTO_INCREMENT PRIMARY KEY,
    authority VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(45) NOT NULL,
    password VARCHAR(45) NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS user_authorities (
    user_id INT NOT NULL,
    authority_id INT NOT NULL,
    PRIMARY KEY (user_id, authority_id),
    FOREIGN KEY (authority_id) REFERENCES authorities(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);
