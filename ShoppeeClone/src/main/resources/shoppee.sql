create table tbl_user
(
    id       bigserial primary key,
    username varchar,
    password varchar,
    fullname varchar,
    image    varchar,
    birthday timestamp,
    gender   varchar,
    email    varchar,
    phone    varchar,
    is_shop  boolean
)