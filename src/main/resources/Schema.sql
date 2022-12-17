CREATE TABLE Employee (
    employee_id   VARCHAR(128)      NOT NULL,
    first_name    VARCHAR(256)      NOT NULL,
    last_name     VARCHAR(256)      NOT NULL,
    email        VARCHAR(256)      NOT NULL,
    phone_no      NUMBER(20)           NOT NULL,
    PRIMARY KEY (employee_id)
);