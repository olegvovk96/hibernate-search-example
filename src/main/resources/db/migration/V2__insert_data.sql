INSERT INTO candidate(email, first_name, last_name, phone_number, zip_code, education)
VALUES ('test1@gmail.com', 'Ivan', 'Tank', '1222333444', '79034', 'BACHELORS_DEGREE'),
       ('test2@gmail.com', 'Zakaria', 'Shannon', '1112223333', '30301', 'HIGH_SCHOOL'),
       ('test3@gmail.com', 'Renae', 'Simpson', '1112224444', '30321', 'ASSOCIATE_DEGREE'),
       ('test4@gmail.com', 'Krisha', 'Conley', '1555333111', '30337', 'BACHELORS_DEGREE'),
       ('test5@gmail.com', 'Skyla', 'Langley', '1234777999', '32437', 'MASTERS_DEGREE');


INSERT INTO hobby(name)
VALUES ('Swimming'),
       ('Camping'),
       ('Kart racing'),
       ('Metal detecting'),
       ('Fishing'),
       ('Geocaching'),
       ('Skateboarding'),
       ('Hiking');


INSERT INTO candidate_availability
VALUES ((SELECT id FROM candidate WHERE email = 'test1@gmail.com'), 'FULL_TIME'),
       ((SELECT id FROM candidate WHERE email = 'test1@gmail.com'), 'PART_TIME');

INSERT INTO candidate_availability
VALUES ((SELECT id FROM candidate WHERE email = 'test2@gmail.com'), 'FULL_TIME');

INSERT INTO candidate_availability
VALUES ((SELECT id FROM candidate WHERE email = 'test3@gmail.com'), 'PART_TIME');

INSERT INTO candidate_availability
VALUES ((SELECT id FROM candidate WHERE email = 'test4@gmail.com'), 'PART_TIME'),
       ((SELECT id FROM candidate WHERE email = 'test4@gmail.com'), 'FULL_TIME');

INSERT INTO candidate_availability
VALUES ((SELECT id FROM candidate WHERE email = 'test5@gmail.com'), 'FULL_TIME');


INSERT INTO candidate_hobby
VALUES ((SELECT id FROM candidate WHERE email = 'test1@gmail.com'), (SELECT id FROM hobby WHERE name = 'Swimming')),
       ((SELECT id FROM candidate WHERE email = 'test1@gmail.com'), (SELECT id FROM hobby WHERE name = 'Camping')),
       ((SELECT id FROM candidate WHERE email = 'test1@gmail.com'), (SELECT id FROM hobby WHERE name = 'Fishing'));

INSERT INTO candidate_hobby
VALUES ((SELECT id FROM candidate WHERE email = 'test2@gmail.com'), (SELECT id FROM hobby WHERE name = 'Swimming')),
       ((SELECT id FROM candidate WHERE email = 'test2@gmail.com'), (SELECT id FROM hobby WHERE name = 'Kart racing')),
       ((SELECT id FROM candidate WHERE email = 'test2@gmail.com'), (SELECT id FROM hobby WHERE name = 'Hiking'));

INSERT INTO candidate_hobby
VALUES ((SELECT id FROM candidate WHERE email = 'test3@gmail.com'), (SELECT id FROM hobby WHERE name = 'Metal detecting')),
       ((SELECT id FROM candidate WHERE email = 'test3@gmail.com'), (SELECT id FROM hobby WHERE name = 'Geocaching'));

INSERT INTO candidate_hobby
VALUES ((SELECT id FROM candidate WHERE email = 'test4@gmail.com'), (SELECT id FROM hobby WHERE name = 'Metal detecting')),
       ((SELECT id FROM candidate WHERE email = 'test4@gmail.com'), (SELECT id FROM hobby WHERE name = 'Skateboarding'));

INSERT INTO candidate_hobby
VALUES ((SELECT id FROM candidate WHERE email = 'test5@gmail.com'), (SELECT id FROM hobby WHERE name = 'Metal detecting')),
       ((SELECT id FROM candidate WHERE email = 'test5@gmail.com'), (SELECT id FROM hobby WHERE name = 'Swimming')),
       ((SELECT id FROM candidate WHERE email = 'test5@gmail.com'), (SELECT id FROM hobby WHERE name = 'Camping')),
       ((SELECT id FROM candidate WHERE email = 'test5@gmail.com'), (SELECT id FROM hobby WHERE name = 'Kart racing')),
       ((SELECT id FROM candidate WHERE email = 'test5@gmail.com'), (SELECT id FROM hobby WHERE name = 'Fishing'));
