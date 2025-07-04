INSERT INTO authorities (authority) VALUES ('READ');
INSERT INTO users (username, password) VALUES ('seop', '1234');
INSERT INTO user_authorities (user_id, authority_id)
VALUES (
           (SELECT id FROM users WHERE username = 'seop'),
           (SELECT id FROM authorities WHERE authority = 'READ')
       );