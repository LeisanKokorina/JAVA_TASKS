INSERT INTO users (id, login, hash_password, state, role)
  SELECT
    1,
    'Admin',
    '$2a$10$io5CLIs7oJcUr5yr2OvBx.e3wpHnV8CjrSYsjts7i/o.mkS5pwK0y',
    'CONFIRMED',
    'ADMIN'


  WHERE
    NOT EXISTS(
        SELECT id
        FROM users
        WHERE id = 1
    );

CREATE TABLE IF NOT EXISTS persistent_logins (
  username VARCHAR(64) NOT NULL,
  series VARCHAR(64) PRIMARY KEY NOT NULL,
  token VARCHAR(64) NOT NULL,
  last_used TIMESTAMP NOT NULL
)