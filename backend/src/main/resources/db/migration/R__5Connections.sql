CREATE TABLE IF NOT EXISTS Connections (
    user_ID_1 BIGSERIAL NOT NULL,
    user_ID_2 BIGSERIAL NOT NULL,
    status VARCHAR(20),
    PRIMARY KEY (user_ID_1, user_ID_2),
    FOREIGN KEY (user_ID_1) REFERENCES Person(id),
    FOREIGN KEY (user_ID_2) REFERENCES Person(id)
);

CREATE TABLE IF NOT EXISTS ConnectionSuggestions (
    user_ID_1 BIGSERIAL NOT NULL,
    user_ID_2 BIGSERIAL NOT NULL,
    type VARCHAR(20),
    PRIMARY KEY (user_ID_1, user_ID_2),
    FOREIGN KEY (user_ID_1) REFERENCES Person(id),
    FOREIGN KEY (user_ID_2) REFERENCES Person(id)
);
