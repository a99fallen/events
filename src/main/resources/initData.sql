INSERT INTO users (username, password) VALUES ('andrzej', '{noop}andrzej123');
INSERT INTO users (username, password) VALUES ('ziutek', '{noop}ziutek123');
INSERT INTO users (username, password) VALUES ('user', '{noop}pass');
INSERT INTO users (username, password) VALUES ('aaa', '{noop}bbb');
INSERT INTO users_roles (username, role) VALUES ('aaa', 'ROLE_USER');
INSERT INTO users_roles (username, role) VALUES ('user', 'ROLE_USER');
INSERT INTO users_roles (username, role) VALUES ('ziutek', 'ROLE_USER');
INSERT INTO users_roles (username, role) VALUES ('andrzej', 'ROLE_USER');