create table if not exists appointment
(
    id         bigserial
    primary key,
    date       date not null,
    summary    varchar(150),
    time       time not null,
    status_id  integer
    constraint fkaac9lclp9nagsmmkwkc7jtrqp
    references appointment_status,
    clinic_id  bigint
    constraint fki7q7b33lue26pe9f0p9tb7j2j
    references clinic,
    medic_id   bigint
    constraint fkp7p1cmy270mwikvq3d36d2un2
    references users,
    pacient_id bigint
    constraint fkj41emk2bsyryj8jxufpjxbisu
    references users
    );

