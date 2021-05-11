drop table if exists note;
drop table if exists category;

create table category
(
    id   serial primary key not null,
    name varchar(15)        not null unique
);

create table note
(
    id          serial primary key not null,
    category_id integer references category (id),
    text        varchar(1000)      not null,
    completed   bool default false,
    deleted     bool default false
);

alter table category
    owner to notebook;
alter table note
    owner to notebook;

insert into category (name)
values ('work');
insert into category (name)
values ('study');
insert into category (name)
values ('personal');
insert into category (name)
values ('home');