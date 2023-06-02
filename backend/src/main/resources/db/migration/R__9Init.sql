DELETE FROM admin;
DELETE FROM person;

INSERT INTO admin(id, name, surname, email, password, job_title, location, role) VALUES (1, 'admin', 'admin', 'admin', 'admin', 'admin', 'admin', 'ROLE_ADMIN');
INSERT INTO person (id, name, surname, email, password, job_title, location, role) VALUES (2, 'user', 'user', 'user', 'user', 'user', 'user', 'ROLE_USER');
