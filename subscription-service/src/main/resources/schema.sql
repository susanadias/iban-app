DROP TABLE IF EXISTS SUBSCRIPTIONS;
  
CREATE TABLE SUBSCRIPTIONS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250)  NULL,
  gender VARCHAR(100) NULL,
  date_of_birth DATE NOT NULL,
  consent BOOLEAN NOT NULL,
  email_address VARCHAR(250) NOT NULL
);

