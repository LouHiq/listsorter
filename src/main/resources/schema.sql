DROP TABLE IF EXISTS sortedlist;
CREATE TABLE sortedlist (
  id INT NOT NULL AUTO_INCREMENT,
  nbofswaps INT NOT NULL,
  timetosortinmilliesec VARCHAR(100) NOT NULL,
  created_date DATE NOT NULL,
  PRIMARY KEY (id));