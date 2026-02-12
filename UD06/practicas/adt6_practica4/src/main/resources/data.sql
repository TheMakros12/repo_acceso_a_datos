INSERT INTO cliente (nombre, email)
VALUES ('Juan Pérez', 'juan.perez@example.com');
INSERT INTO cliente (nombre, email)
VALUES ('María López', 'maria.lopez@example.com');
INSERT INTO cliente (nombre, email)
VALUES ('Carlos García', 'carlos.garcia@example.com');
INSERT INTO cliente (nombre, email)
VALUES ('Laura Fernández', 'laura.fernandez@example.com');
INSERT INTO cliente (nombre, email)
VALUES ('Pedro Martínez', 'pedro.martinez@example.com');
INSERT INTO reserva (fecha_entrada, fecha_salida, precio_total, confirmada,
                     id_cliente) VALUES ('2024-03-01', '2024-03-05', 500.0, true, 1);
INSERT INTO reserva (fecha_entrada, fecha_salida, precio_total, confirmada,
                     id_cliente) VALUES ('2024-04-10', '2024-04-15', 750.0, false, 2);
INSERT INTO reserva (fecha_entrada, fecha_salida, precio_total, confirmada,
                     id_cliente) VALUES ('2024-05-05', '2024-05-10', 1200.0, false, 3);
INSERT INTO reserva (fecha_entrada, fecha_salida, precio_total, confirmada,
                     id_cliente) VALUES ('2024-06-15', '2024-06-20', 650.0, false, 4);
INSERT INTO reserva (fecha_entrada, fecha_salida, precio_total, confirmada,
                     id_cliente) VALUES ('2024-07-01', '2024-07-10', 900.0, true, 1);