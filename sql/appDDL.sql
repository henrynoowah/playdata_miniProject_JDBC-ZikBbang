DROP TABLE APP cascade constraint;

DROP TABLE BUILDING cascade constraint;

DROP TABLE PRICE cascade constraint;

DROP TABLE SELLER cascade constraint;

CREATE TABLE APP (
	APP_ID 				VARCHAR2(20) PRIMARY KEY,
	BUILDING_ID			VARCHAR2(20) NOT NULL,
	TRADE_TYPE			VARCHAR2(20) NOT NULL,
	SELLER_ID			VARCHAR2(20) NOT NULL,
	TENANT				CHAR(5) CHECK(TENANT IN('FALSE','TRUE'))
);

CREATE TABLE BUILDING (
	BUILDING_ID 		VARCHAR2(20) PRIMARY KEY,
	REGION				VARCHAR2(20) NOT NULL,
	ADDRESS				VARCHAR2(100) NOT NULL,
	BUILDING_TYPE		VARCHAR2(20) NOT NULL
);

CREATE TABLE PRICE (
	APP_ID				VARCHAR2(20) PRIMARY KEY,
	DEPOSIT				NUMBER(19,4) NOT NULL,
	MONTHLY_RENT		NUMBER(19,4) NOT NULL,
	TRADE_PRICE			NUMBER(19,4) NOT NULL
);

CREATE TABLE SELLER (
	SELLER_ID			VARCHAR2(20) PRIMARY KEY,
	NAME				VARCHAR2(20) NOT NULL,
	PHONE				VARCHAR2(20) NOT NULL
);

ALTER TABLE APP  ADD FOREIGN KEY (BUILDING_ID) REFERENCES BUILDING  (BUILDING_ID);
ALTER TABLE APP ADD FOREIGN KEY (APP_ID)  REFERENCES PRICE  (APP_ID);
ALTER TABLE APP ADD FOREIGN KEY (SELLER_ID) REFERENCES SELLER  (SELLER_ID);
