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

/* Creamos algunos usuarios con sus roles */
INSERT INTO `users` (username, password, enabled, name, lastname, email) VALUES ('andres','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS',1, 'Andres', 'Guzman','profesor@bolsadeideas.com');
INSERT INTO `users` (username, password, enabled, name, lastname, email) VALUES ('admin','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS',1, 'John', 'Doe','jhon.doe@bolsadeideas.com');

INSERT INTO `roles` (name) VALUES ('ROLE_USER');
INSERT INTO `roles` (name) VALUES ('ROLE_ADMIN');

INSERT INTO `user_authorities` (user_id, role_id) VALUES (1, 1);
INSERT INTO `user_authorities` (user_id, role_id) VALUES (2, 2);
INSERT INTO `user_authorities` (user_id, role_id) VALUES (2, 1);

INSERT INTO productos (nombre, precio, create_at) VALUES('Panasonic Pantalla LCD', 259990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Sony Camara digital DSC-W320B', 123490, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Apple iPod shuffle', 1499990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Sony Notebook Z110', 37990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Hewlett Packard Multifuncional F2280', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Bianchi Bicicleta Aro 26', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Mica Comoda 5 Cajones', 299990, NOW());

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura equipos de oficina', null, 1, NOW());

INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(2, 1, 4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 5);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 7);

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura Bicicleta', 'Alguna nota importante!', 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(3, 2, 6);
