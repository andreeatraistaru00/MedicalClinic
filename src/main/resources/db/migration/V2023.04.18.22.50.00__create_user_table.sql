create table if not exists users
(
    id                 bigserial
    primary key,
    created_date       timestamp(6),
    email              varchar(255),
    first_name         varchar(255),
    last_modified_date timestamp(6),
    last_name          varchar(255),
    password           varchar(255),
    user_name          varchar(255),
    role_id            integer
    constraint fkp56c1712k691lhsyewcssf40f
    references roles,
    speciality_id      bigint
    constraint fkelqeqwnc5uogqfkndvg2fadd6
    references speciality
    );
