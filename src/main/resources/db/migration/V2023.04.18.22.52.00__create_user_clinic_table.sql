create table if not exists medic_clinic
(
    user_id   bigint not null
    constraint fkhv7gtkg672oo0fepeo1edoovs
    references users,
    clinic_id bigint not null
    constraint fkp7pb66xfk66ecnkimtf4ya0t3
    references clinic,
    primary key (user_id, clinic_id)
    );

