DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS articles;

CREATE TABLE users(
                      id int NOT NULL AUTO_INCREMENT,
                      name varchar(50) NOT NULL,
                      age int NOT NULL,
                      PRIMARY KEY (id)
);

CREATE TABLE articles(
                         id int NOT NULL AUTO_INCREMENT,
                         text varchar(255) NOT NULL,
                         color varchar(50) NOT NULL,
                         user_id int NOT NULL,
                         PRIMARY KEY (id),
                         FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);


