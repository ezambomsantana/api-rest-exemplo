CREATE TABLE users.post (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    title VARCHAR(250) NOT NULL,
    text VARCHAR NOT NULL,
    user_id BIGINT REFERENCES users.user(id)
)