create table note
(
    id        serial primary key not null,
    category  varchar(15)        not null,
    text      varchar(1000)      not null,
    completed bool default false,
    deleted   bool default false
)