DELETE FROM Connections;
DELETE FROM ConnectionSuggestions;
DELETE FROM User_Comments;
DELETE FROM Comment;
DELETE FROM User_Reactions;
DELETE FROM Reaction;
DELETE FROM Feed_Posts;
DELETE FROM FeedPost;
DELETE FROM Admin;

DELETE FROM File;

DELETE FROM Connections;
DELETE FROM ConnectionSuggestions;

DELETE FROM FeedPost;
DELETE FROM Comment;
DELETE FROM Reaction;
DELETE FROM User_reactions;
DELETE FROM User_comments;
DELETE FROM Feed_posts;

DELETE FROM Interests;
DELETE FROM Interest;

DELETE FROM Admin;
DELETE FROM SystemReport;
DELETE FROM Reports;
DELETE FROM Hiring_Reports;
DROP VIEW IF EXISTS Hiring_Reports_View;

DELETE FROM experiences;
DELETE FROM Exp_company;
DELETE FROM Applies;
DELETE FROM Experience;
DELETE FROM JobPost;
DELETE FROM Company;

DELETE FROM CareerExpert;
DELETE FROM Recruiter;
DELETE FROM Person;

INSERT INTO Admin(id, name, surname, email, password, job_title, location, role) VALUES (1, 'admin', 'admin', 'admin', 'admin', 'admin', 'admin', 'ROLE_ADMIN');

INSERT INTO Person (id, name, surname, email, password, job_title, location, role) VALUES (2, 'user1', 'user1', 'user1', 'user1', 'user1', 'user1', 'ROLE_USER');
INSERT INTO Person (id, name, surname, email, password, job_title, location, role) VALUES (3, 'user2', 'user2', 'user2', 'user2', 'user2', 'user2', 'ROLE_USER');
INSERT INTO Person (id, name, surname, email, password, job_title, location, role) VALUES (4, 'user3', 'user3', 'user3', 'user3', 'user3', 'user3', 'ROLE_USER');

INSERT INTO Connections (user_ID_1, user_ID_2, status) VALUES (2, 3, 'LINKED');

INSERT INTO FeedPost (post_id, title, date, content, image, type) VALUES (1, 'Post 1', '2017-03-31 09:30:20', 'Sample post 1', NULL, 'POST');
INSERT INTO Feed_Posts (user_id, post_id) VALUES (3, 1);

INSERT INTO Comment (comment_id, post_id, content, date) VALUES (1, 1, 'Comment 1', '2017-03-31 09:30:20');
INSERT INTO User_Comments (comment_id, user_id) VALUES (1, 2);

INSERT INTO Reaction (reaction_ID, type, date) VALUES (1, 'Like', NULL);
INSERT INTO Reaction (reaction_ID, type, date) VALUES (2, 'Love', NULL);

INSERT INTO Interest (id, title, area) VALUES (1, 'Java Development', 'Programming');
INSERT INTO Interest (id, title, area) VALUES (2, 'Python Development', 'Programming');
INSERT INTO Interest (id, title, area) VALUES (3, 'C++ Development', 'Programming');
INSERT INTO Interest (id, title, area) VALUES (4, 'SQL Development', 'Programming');

INSERT INTO Interests (int_id, person_id) VALUES (1, 2);
INSERT INTO Interests (int_id, person_id) VALUES (2, 2);
INSERT INTO Interests (int_id, person_id) VALUES (3, 2);
INSERT INTO Interests (int_id, person_id) VALUES (4, 3);

INSERT INTO Company (company_ID ,name,location,about, domain) VALUES (1, 'Apple', 'California, LA', 'Apple is a good company', 'apple.com');
INSERT INTO Company (company_ID ,name,location,about, domain) VALUES (2, 'Togg', 'Ankara', 'Togg is a cool company', 'togg.com');

INSERT INTO jobPost (post_ID, date, content, job_title, company_ID, workplace, position, profession) VALUES (1, '2023-03-03 09:30:20', 'Please apply we are desperate for developers!',
                                                                                                             'Java Developer', 1, 'California, LA', 'On-site', 'Senior Developer');
INSERT INTO jobPost (post_ID, date, content, job_title, company_ID, workplace, position, profession) VALUES (2, '2023-03-03 09:30:20', 'Need Alpha Male Top Gs ASAP!',
                                                                                                             'Professional Top G', 2, 'Houston, Texas', 'On-site', 'Senior Top G');