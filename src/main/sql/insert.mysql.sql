INSERT INTO users(username, password, enabled)
VALUES ('user01','pass01', true);

INSERT INTO users(username,password,enabled)
VALUES ('user02','pass02', true);

INSERT INTO user_roles (username, role)
VALUES ('user01', 'ROLE_USER');

INSERT INTO user_roles (username, role)
VALUES ('user01', 'ROLE_ADMIN');

INSERT INTO user_roles (username, role)
VALUES ('user02', 'ROLE_USER');