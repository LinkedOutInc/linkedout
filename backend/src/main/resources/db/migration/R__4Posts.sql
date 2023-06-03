CREATE TABLE IF NOT EXISTS FeedPost (
    post_ID BIGSERIAL PRIMARY KEY,
    title VARCHAR NOT NULL,
    date DATE NOT NULL,
    content VARCHAR(2000),
    image VARCHAR(100),
    type VARCHAR(20) NOT NULL
);

-- TODO: Check
CREATE TABLE IF NOT EXISTS Comment (
    comment_ID BIGSERIAL PRIMARY KEY,
    post_ID BIGSERIAL NOT NULL,
    content VARCHAR(2000) NOT NULL,
    date DATE NOT NULL,
    FOREIGN KEY (post_ID) REFERENCES FeedPost(post_ID)
);

CREATE TABLE IF NOT EXISTS Reaction (
    reaction_ID BIGSERIAL PRIMARY KEY,
    type VARCHAR(20),
    date DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS User_reactions (
    user_ID BIGSERIAL NOT NULL,
    reaction_ID BIGSERIAL NOT NULL,
    post_ID BIGSERIAL NOT NULL,
    PRIMARY KEY (user_ID, post_ID),
    FOREIGN KEY (user_ID) REFERENCES Person(id),
    FOREIGN KEY (reaction_ID) REFERENCES Reaction(reaction_ID),
    FOREIGN KEY (post_ID) REFERENCES FeedPost(post_ID)
);

-- TODO: Check
CREATE TABLE IF NOT EXISTS User_comments (
    comment_ID BIGSERIAL PRIMARY KEY,
    user_ID BIGSERIAL NOT NULL,
    FOREIGN KEY (user_ID) REFERENCES Person(id),
    FOREIGN KEY (comment_ID) REFERENCES Comment(comment_ID)
);

CREATE TABLE IF NOT EXISTS Feed_posts (
    user_ID BIGSERIAL NOT NULL,
    post_ID BIGSERIAL NOT NULL,
    PRIMARY KEY (user_ID, post_ID),
    FOREIGN KEY (user_ID) REFERENCES Person(id),
    FOREIGN KEY (post_ID) REFERENCES FeedPost(post_ID)
);
