create sequence hibernate_sequence start 1 increment 1;

create table candidate
(
    id           bigserial    NOT NULL CONSTRAINT candidate_pkey PRIMARY KEY,
    email        varchar(255) NOT NULL,
    first_name   varchar(100) NOT NULL,
    last_name    varchar(100) NOT NULL,
    phone_number varchar(10)  NOT NULL,
    zip_code     varchar(5)   NOT NULL,
    education    varchar(255)
);

create table candidate_availability
(
    candidate_id bigint       NOT NULL,
    availability varchar(255) NOT NULL
);

create table candidate_hobby
(
    candidate_id bigint NOT NULL,
    hobby_id     bigint NOT NULL,
    primary key (candidate_id, hobby_id)
);

create table hobby
(
    id   bigserial    NOT NULL CONSTRAINT hobby_pkey PRIMARY KEY,
    name varchar(255) NOT NULL
);

ALTER TABLE IF EXISTS candidate_availability
    ADD FOREIGN KEY (candidate_id) references candidate(id);
ALTER TABLE IF EXISTS candidate_hobby
    ADD FOREIGN KEY (hobby_id) REFERENCES hobby(id);
ALTER TABLE IF EXISTS candidate_hobby
    ADD FOREIGN KEY (candidate_id) references candidate(id);
