CREATE TABLE `user` (
 user_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 user_name CHAR(255) NOT NULL,
 user_pass CHAR(255)
);

CREATE TABLE seven_columns (
 column_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 user_id INT REFERENCES `user`(user_id),
 edit_date DATE NOT NULL,
 title CHAR(255) NOT NULL,
 event CHAR(255),
 emotion CHAR(255),
 negative CHAR(255),
 distortion CHAR(255),
 reason CHAR(255),
 disproof CHAR(255),
 another CHAR(255),
 change_emo CHAR(255)
);