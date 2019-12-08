create table games
(
    id            serial    not null,
    game          text      not null,
    generated     timestamp not null,
    latest_player integer   not null
);

alter table games
    owner to postgres;
