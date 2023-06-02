CREATE TABLE IF NOT EXISTS Company (
    company_ID BIGSERIAL NOT NULL,
    name VARCHAR,
    location VARCHAR,
    about VARCHAR,
    domain VARCHAR,
    company_picture bytea,
    PRIMARY KEY (company_ID)
);

CREATE TABLE IF NOT EXISTS File (
    file_ID BIGSERIAL NOT NULL,
    user_ID BIGSERIAL NOT NULL,
    content VARCHAR,
    fileName VARCHAR,
    fileType VARCHAR,
    contentType VARCHAR,
    PRIMARY KEY (file_ID),
    FOREIGN KEY (user_ID) REFERENCES Person(id)
);

CREATE TABLE IF NOT EXISTS Experience (
    exp_ID BIGSERIAL NOT NULL,
    user_ID BIGSERIAL NOT NULL,
    title VARCHAR,
    description TEXT,
    type VARCHAR,
    start_date DATE,
    end_date DATE,
    PRIMARY KEY (exp_ID, user_ID),
    FOREIGN KEY (user_ID) REFERENCES Person(id)
);
CREATE TABLE IF NOT EXISTS experiences (
    exp_ID BIGSERIAL NOT NULL,
    user_ID BIGSERIAL NOT NULL,
    PRIMARY KEY (exp_ID, user_ID),
    FOREIGN KEY (exp_ID, user_ID) REFERENCES Experience(exp_ID, user_ID)
);
CREATE TABLE IF NOT EXISTS Exp_company (
    exp_ID BIGSERIAL NOT NULL,
    company_ID BIGSERIAL NOT NULL,
    user_ID BIGSERIAL NOT NULL,
    is_verified INT,
    PRIMARY KEY (exp_ID, company_ID, user_ID),
    FOREIGN KEY (exp_ID, user_ID) REFERENCES Experience(exp_ID, user_ID),
    FOREIGN KEY (company_ID) REFERENCES Company(company_ID)
);
CREATE TABLE IF NOT EXISTS JobPost (
    post_ID BIGSERIAL,
    date DATE,
    content VARCHAR,
    job_title VARCHAR,
    company_ID BIGSERIAL,
    workplace VARCHAR,
    position VARCHAR,
    profession VARCHAR,
    PRIMARY KEY (post_ID),
    FOREIGN KEY (company_ID) REFERENCES Company(company_ID)
);
CREATE TABLE IF NOT EXISTS Applies (
    user_ID BIGSERIAL,
    post_ID BIGSERIAL,
    PRIMARY KEY (user_ID, post_ID),
    FOREIGN KEY (user_ID) REFERENCES Person(id),
    FOREIGN KEY (post_ID) REFERENCES JobPost(post_ID)
);