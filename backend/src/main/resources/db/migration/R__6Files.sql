CREATE TABLE IF NOT EXISTS File (
    file_ID BIGSERIAL NOT NULL,
    user_ID BIGSERIAL NOT NULL,
    content VARCHAR,
    fileName VARCHAR,
    fileType VARCHAR,
    uploadTime DATE,
    contentType VARCHAR,
    PRIMARY KEY (file_ID),
    FOREIGN KEY (user_ID) REFERENCES Person(id)
);