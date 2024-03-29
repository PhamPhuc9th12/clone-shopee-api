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

create table tbl_address(
                            id bigserial primary key,
                            type varchar,
                            is_default boolan,
                            tinh varchar,
                            quan varchar,
                            xa varchar,
                            address_detail varchar,
                            name_receive varchar,
                            phone varchar
                                user_id references tbl_user(id)
)