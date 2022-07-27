INSERT INTO roles (name) VALUES ('USER');
INSERT INTO roles (name) VALUES ('EDITOR');
INSERT INTO roles (name) VALUES ('ADMIN');

INSERT INTO users (username, password, enabled) VALUES ('suresh', '$2a$10$flDL1ovH.7JEy1lSpBuuHuqagrXA8K3j3ELXQFV/KXhQK.WSnP8a.', '1');
INSERT INTO users (username, password, enabled) VALUES ('ramesh', '$2a$10$9k8/ODt16QFCmcmXLO2.oeVR8gHUtqpw9JeoEwEx/BKKAX9BZbbHK', '1');
INSERT INTO users (username, password, enabled) VALUES ('admin', '$2a$10$bN7OWEvi6rTqJEYbZfDOg.FHmG.xPTDxJR1k9LzsR4O6Nt8zuIKwq', '1');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1); 
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2); 
INSERT INTO users_roles (user_id, role_id) VALUES (3, 3);