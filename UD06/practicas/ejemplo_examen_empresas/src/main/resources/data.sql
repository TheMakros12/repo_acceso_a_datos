-- Primero borramos las tablas hijas para evitar problemas de Foreign Key
DELETE FROM empleado;
DELETE FROM empresa;

-- Reiniciamos los IDs autoincrementales a 1
ALTER TABLE empleado AUTO_INCREMENT=1;
ALTER TABLE empresa AUTO_INCREMENT=1;

-- Insertamos las empresas (Entidad Padre)
INSERT INTO empresa (nombre, sector, ano_fundacion, ingresos_anuales) VALUES
                                                                          ('Tech Solutions S.L.', 'Tecnología', 2015, 2500000.50),
                                                                          ('Finanzas Global Inc.', 'Finanzas', 2008, 5000000.00),
                                                                          ('Educatech España', 'Educación', 2018, 800000.75),
                                                                          ('Construcciones Avanzadas', 'Construcción', 2010, 3200000.25);

-- Insertamos los empleados (Entidad Hija) asociados a sus empresas
-- El empresa_id hace referencia a la Empresa insertada justo arriba (por su ID generado)
INSERT INTO empleado (nombre_completo, puesto, salario, email, fecha_contratacion, empresa_id) VALUES
                                                                                                   ('Juan García Pérez', 'DESARROLLADOR', 45000.00, 'juan.garcia@techsolutions.com', '2023-05-15', 1),
                                                                                                   ('María Rodríguez López', 'ANALISTA', 38000.00, 'maria.rodriguez@techsolutions.com', '2023-08-20', 1),
                                                                                                   ('Laura Martínez García', 'GERENTE', 42000.00, 'laura.martinez@techsolutions.com', '2024-01-10', 1),
                                                                                                   ('Carlos Martín Sánchez', 'GERENTE', 65000.00, 'carlos.martin@finanzas.com', '2020-03-10', 2),
                                                                                                   ('Elena Navarro Díaz', 'ANALISTA', 52000.00, 'elena.navarro@finanzas.com', '2021-11-05', 2),
                                                                                                   ('Pedro López García', 'DIRECTOR_RECURSOS_HUMANOS', 35000.00, 'pedro.lopez@educatech.com', '2024-01-15', 3),
                                                                                                   ('Sofía Gómez Ruiz', 'DESARROLLADOR', 48000.00, 'sofia.gomez@construcciones.com', '2022-07-20', 4);