DROP TABLE person IF EXISTS;

CREATE TABLE person (
  id         INTEGER IDENTITY PRIMARY KEY,
  username   VARCHAR(30),
  password   VARCHAR(15),
  first_name VARCHAR(30),
  last_name  VARCHAR(30),
  address    VARCHAR(255),
  city       VARCHAR(80),
  telephone  VARCHAR(20)
)