CREATE TABLE IF NOT EXISTS Person (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    job_title VARCHAR(20) NOT NULL,
    location VARCHAR(20) NOT NULL,
    role VARCHAR(20) NOT NULL,
    unique (email)
);

CREATE TABLE IF NOT EXISTS CareerExpert (
    field VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
) INHERITS (Person);

CREATE TABLE IF NOT EXISTS Recruiter (
    is_hiring BOOLEAN,
    PRIMARY KEY (id)
) INHERITS (Person);