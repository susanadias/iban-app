DROP TABLE IF EXISTS SUBSCRIPTIONS;
  
CREATE TABLE SUBSCRIPTIONS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250)  NULL,
  last_name VARCHAR(250) NULL,
  email_address VARCHAR(250) NOT NULL,
);

