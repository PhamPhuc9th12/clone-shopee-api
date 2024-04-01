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

create table tbl_category(
                             id bigserial primary key,
                             name varchar,
                             image varchar,
                             shop_id bigserial references tbl_shop(id)

)

create table tbl_shop(
                         id bigserial primary key,
                         name varchar,
                         image varchar,
                         created_at varchar,
                         product_count varchar,
                         follow_count varchar,
                         rating bigserial,
                         user_id bigserial references tbl_user(id),
                         cate_id bigserial references tbl_category(id)
)

create table tbl_product(
                            id bigserial primary key,
                            name varchar,
                            description varchar,
                            images varchar,
                            is_free_ship boolean,
                            ship_cost bigserial,
                            resource varchar,
                            is_return boolean,
                            time_return timestamp,
                            like_count bigserial,
                            comment_count bigserial,
                            cate_id bigserial references tbl_category(id),
                            shop_id bigserial references tbl_shop(id)
)

create table tbl_product_type(
                                 id bigserial primary key,
                                 name varchar,
                                 product_id bigserial references tbl_product(id)
)
create table tbl_size(
                                 id bigserial primary key,
                                 name varchar,
                                 description varchar
)
create table tbl_product_type_size_map(
                                          id bigserial primary key,
                                          price bigserial,
                                          quantity bigserial,
                                          is_sale boolean,
                                          sale_percent bigserial,
                                          sale_cost bigserial,
                                          sale_start_time timestamp,
                                          sale_end_time timestamp,
                                          product_type_id bigserial references tbl_product_type(id),
                                          size_id bigserial references tbl_size(id)

)
