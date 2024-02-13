CREATE TABLE IF NOT EXISTS TITLE (
    ID SERIAL PRIMARY KEY,
    DESCRIPTION VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS PROFESSIONAL (
    ID SERIAL PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,
    EMAIL VARCHAR(255) UNIQUE NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
    BIRTH_DATE DATE NOT NULL,
    REGISTER_DATE TIMESTAMP NOT NULL,
    PHONE_NUMBER VARCHAR(20) NOT NULL,
    CODE VARCHAR(20) UNIQUE,
    REGISTRATION_STATUS VARCHAR(20),
    PROFESSIONAL_TYPE VARCHAR(20) NOT NULL,
    VISA_DATE TIMESTAMP
);

CREATE TABLE IF NOT EXISTS PROFESSIONAL_TITLE (
    PROFESSIONAL_ID INT,
    TITLE_ID INT,
    FOREIGN KEY (PROFESSIONAL_ID) REFERENCES PROFESSIONAL(ID),
    FOREIGN KEY (TITLE_ID) REFERENCES TITLE(ID),
    PRIMARY KEY (PROFESSIONAL_ID, TITLE_ID)
);

