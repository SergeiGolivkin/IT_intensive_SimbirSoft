CREATE SEQUENCE IF NOT EXISTS hibernate_sequence start 1 increment 1;



CREATE TABLE Users
(
    id         serial PRIMARY KEY,
    email      varchar(255) NOT NULL UNIQUE,
    first_name varchar(50)  NOT NULL,
    last_name  varchar(100) NOT NULL,
    password   varchar(255) NOT NULL,
    role       varchar(30) default 'USER',
    status     VARCHAR(20) default 'ACTIVE'
);


INSERT INTO Users (email, first_name, last_name, password, role, status)
VALUES ('ivan@mail.ru', 'ivan', 'ivanov', '$2y$12$Vn/.SWraLgHwgIsBFtTgXuvP9xrgJCFNPmK.mMna2.6IVmogH2dOC', 'USER',
        'ACTIVE');

INSERT INTO Users (email, first_name, last_name, password, role, status)
VALUES ('petr@mail.ru', 'petr', 'petrov', '$2y$12$oh1ldnTSSUKWZcMrgl7nROWnCvGNyC8cC9dLJhYEGneKdj7CV2krK ', 'ADMIN', 'ACTIVE');