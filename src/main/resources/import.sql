/* Populate tabla clientes */

INSERT INTO regions (id,name) VALUES (1, 'Sudamérica');
INSERT INTO regions (id,name) VALUES (2, 'Centromérica');
INSERT INTO regions (id,name) VALUES (3, 'Norteamérica');
INSERT INTO regions (id,name) VALUES (4, 'Europa');
INSERT INTO regions (id,name) VALUES (5, 'Asia');
INSERT INTO regions (id,name) VALUES (6, 'Africa');
INSERT INTO regions (id,name) VALUES (7, 'Oceanía');
INSERT INTO regions (id,name) VALUES (8, 'Antártida');

INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(1,'Exequiel', 'Carrizo', 'exelcarrizo@gmail.com', '2024-01-01');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(2,'Mr. John', 'Doe', 'john.doe@gmail.com', '2024-01-02');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(4,'Linus', 'Torvalds', 'linus.torvalds@gmail.com', '2024-01-03');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(4,'Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', '2024-01-04');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(5,'Erich', 'Gamma', 'erich.gamma@gmail.com', '2024-02-01');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(7,'Richard', 'Helm', 'richard.helm@gmail.com', '2024-02-10');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(6,'Ralph', 'Johnson', 'ralph.johnson@gmail.com', '2024-02-18');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(6,'John', 'Vlissides', 'john.vlissides@gmail.com', '2018-02-28');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(3,'Dr. James', 'Gosling', 'james.gosling@gmail.com', '2018-03-03');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(3,'Magma', 'Lee', 'magma.lee@gmail.com', '2018-03-04');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(4,'Tornado', 'Roe', 'tornado.roe@gmail.com', '2018-03-05');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(5,'Jade', 'Doe', 'jane.doe@gmail.com', '2018-03-06');