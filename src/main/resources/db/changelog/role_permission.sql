create table role_permission
(
    id     varchar(36) not null
        constraint context_pk primary key,
    value  int         not null,
    target varchar(50) not null
);