CREATE TABLE tbl_product (
	pno INT AUTO_INCREMENT PRIMARY KEY,
	pname VARCHAR(50) NOT NULL,
	pprice INT NOT NULL,
	pcnt INT NOT NULL,
	regdate DATETIME DEFAULT CURRENT_TIMESTAMP()
);