-- CLIENTES
INSERT INTO cliente (id, nombre) VALUES (1, 'Juan García');
INSERT INTO cliente (id, nombre) VALUES (2, 'María López');
INSERT INTO cliente (id, nombre) VALUES (3, 'Pedro Sánchez');
INSERT INTO cliente (id, nombre) VALUES (4, 'Ana Martínez');


-- PEDIDOS DEL CLIENTE 1: Juan García
INSERT INTO pedido (id, fecha, resumen, cliente_id)
VALUES (1, '2026-10-01T10:30:00', 'Compra de ordenador portátil', 1);

INSERT INTO pedido (id, fecha, resumen, cliente_id)
VALUES (2, '2026-10-03T12:00:00', 'Compra de ratón y teclado', 1);

INSERT INTO pedido (id, fecha, resumen, cliente_id)
VALUES (3, '2026-10-05T16:45:00', 'Compra de monitor 27 pulgadas', 1);

INSERT INTO pedido (id, fecha, resumen, cliente_id)
VALUES (4, '2026-10-08T09:15:00', 'Compra de accesorios informáticos', 1);


-- PEDIDOS DEL CLIENTE 2: María López
INSERT INTO pedido (id, fecha, resumen, cliente_id)
VALUES (5, '2026-10-02T11:00:00', 'Compra de teléfono móvil', 2);

INSERT INTO pedido (id, fecha, resumen, cliente_id)
VALUES (6, '2026-10-04T14:30:00', 'Compra de funda y protector', 2);

INSERT INTO pedido (id, fecha, resumen, cliente_id)
VALUES (7, '2026-10-07T18:00:00', 'Compra de auriculares inalámbricos', 2);

INSERT INTO pedido (id, fecha, resumen, cliente_id)
VALUES (8, '2026-10-09T10:00:00', 'Compra de cargador USB-C', 2);


-- PEDIDOS DEL CLIENTE 3: Pedro Sánchez
INSERT INTO pedido (id, fecha, resumen, cliente_id)
VALUES (9, '2026-10-01T09:00:00', 'Compra de impresora', 3);

INSERT INTO pedido (id, fecha, resumen, cliente_id)
VALUES (10, '2026-10-06T13:15:00', 'Compra de cartuchos de tinta', 3);

INSERT INTO pedido (id, fecha, resumen, cliente_id)
VALUES (11, '2026-10-10T17:30:00', 'Compra de papel A4', 3);

INSERT INTO pedido (id, fecha, resumen, cliente_id)
VALUES (12, '2026-10-12T12:45:00', 'Compra de escáner', 3);


-- PEDIDOS DEL CLIENTE 4: Ana Martínez
INSERT INTO pedido (id, fecha, resumen, cliente_id)
VALUES (13, '2026-10-03T08:30:00', 'Compra de tablet', 4);

INSERT INTO pedido (id, fecha, resumen, cliente_id)
VALUES (14, '2026-10-05T15:00:00', 'Compra de lápiz digital', 4);

INSERT INTO pedido (id, fecha, resumen, cliente_id)
VALUES (15, '2026-10-11T11:30:00', 'Compra de funda para tablet', 4);

INSERT INTO pedido (id, fecha, resumen, cliente_id)
VALUES (16, '2026-10-14T19:00:00', 'Compra de teclado bluetooth', 4);
