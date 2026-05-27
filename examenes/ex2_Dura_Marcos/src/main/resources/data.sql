DELETE FROM producto;

DELETE FROM pedido;

ALTER TABLE producto AUTO_INCREMENT=1;

ALTER TABLE pedido AUTO_INCREMENT=1;

INSERT INTO pedido (codigo, fecha, estado) VALUES
                                               ('PED-2025001', '2025-04-10', 'Pendiente'),
                                               ('PED-2025002', '2025-04-12', 'Enviado'),
                                               ('PED-2025003', '2025-04-15', 'Entregado'),
                                               ('PED-2025004', '2025-04-20', 'Pendiente');

INSERT INTO producto (nombre, cantidad, precio_unitario, id_pedido) VALUES
                                                                        ('Laptop HP', 2, 750, 1),
                                                                        ('Ratón inalámbrico', 1, 29, 1),
                                                                        ('Teclado mecánico', 1, 89, 2),
                                                                        ('Monitor 24 pulgadas', 1, 199, 3),
                                                                        ('Impresora láser', 1, 149, 4);