-- Tabla Career
insert into career (name, boos) values('Ingeniería de Software', 'Boos1');
insert into career (name, boos) values('Ingeniería de Sistemas', 'Boos2');
insert into career (name, boos) values('Ciencias de la Computación', 'Boos3');
insert into career (name, boos) values('Ingeniería Industrial', 'Boos4');
insert into career (name, boos) values('Ingeniería Electrónica', 'Boos5');

-- Tabla Usuario
insert into usuario (name, email, password) values('admin', 'admin@example.com', 'admin');
insert into usuario (name, email, password) values('user1', 'user1@example.com', 'user1');
insert into usuario (name, email, password) values('user2', 'user2@example.com', 'user2');
insert into usuario (name, email, password) values('user3', 'user3@example.com', 'user3');
insert into usuario (name, email, password) values('user4', 'user4@example.com', 'user4');

-- Tabla Depart
insert into depart (name, cycle, section) values('Ingeniería', 1, '4to ciclo');
insert into depart (name, cycle, section) values('Ciencias', 2, '3er ciclo');
insert into depart (name, cycle, section) values('Administración', 3, '2do ciclo');
insert into depart (name, cycle, section) values('Electrónica', 4, '5to ciclo');
insert into depart (name, cycle, section) values('Industrial', 5, '6to ciclo');

-- Tabla Event
insert into event (name, description) values ('Karaduo', 'Descripción de Karaduo');
insert into event (name, description) values ('Tech Fest', 'Festival de tecnología anual');
insert into event (name, description) values ('Hackathon', 'Evento de desarrollo colaborativo');
insert into event (name, description) values ('Robotics Week', 'Competencia de robótica');
insert into event (name, description) values ('Coding Bootcamp', 'Intensivo de programación');

-- Tabla Score
insert into score (career, score, top) values ('Ingeniería de Software', 100, 10);
insert into score (career, score, top) values ('Ingeniería de Sistemas', 90, 9);
insert into score (career, score, top) values ('Ciencias de la Computación', 85, 8);
insert into score (career, score, top) values ('Ingeniería Industrial', 95, 7);
insert into score (career, score, top) values ('Ingeniería Electrónica', 88, 6);

-- Tabla Tournament
insert into tourment (name, round, type) values ('Torneo de Verano', 3, 'Individual');
insert into tourment (name, round, type) values ('Torneo de Primavera', 4, 'Grupal');
insert into tourment (name, round, type) values ('Hackathon', 5, 'Individual');
insert into tourment (name, round, type) values ('Tech Showdown', 2, 'Grupal');
insert into tourment (name, round, type) values ('Competencia de Robótica', 6, 'Individual');
