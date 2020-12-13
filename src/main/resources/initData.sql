INSERT INTO users (username, password) VALUES ('andrzej', '{noop}andrzej123');
INSERT INTO users (username, password) VALUES ('ziutek', '{noop}ziutek123');
INSERT INTO users (username, password) VALUES ('user', '{noop}pass');
INSERT INTO users (username, password) VALUES ('aaa@aaa', '{noop}bbbb');
INSERT INTO users_roles (username, role) VALUES ('aaa@aaa', 'ROLE_USER');
INSERT INTO users_roles (username, role) VALUES ('user', 'ROLE_USER');
INSERT INTO users_roles (username, role) VALUES ('ziutek', 'ROLE_USER');
INSERT INTO users_roles (username, role) VALUES ('andrzej', 'ROLE_USER');

-- INSERT INTO tasks (name, description, created_on, deadline) VALUES ('zadanie 1', 'opis zadania 1', '20201213 12:19', '20201220 12:19');