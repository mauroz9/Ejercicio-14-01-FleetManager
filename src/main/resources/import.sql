-- =================================================================================================
-- 1. INSERTAR TALLERES
-- =================================================================================================
INSERT INTO taller (nombre, ciudad) VALUES ('Taller Mecánica Rápida', 'Sevilla');
INSERT INTO taller (nombre, ciudad) VALUES ('Norauto Los Alcores', 'Alcalá de Guadaíra');
INSERT INTO taller (nombre, ciudad) VALUES ('Talleres Paco e Hijos', 'Dos Hermanas');
INSERT INTO taller (nombre, ciudad) VALUES ('Midas Sevilla Centro', 'Sevilla');
INSERT INTO taller (nombre, ciudad) VALUES ('Neumáticos del Sur', 'Jerez de la Frontera');

-- =================================================================================================
-- 2. INSERTAR CONDUCTORES
-- =================================================================================================
INSERT INTO conductor (nombre, email) VALUES ('Fernando Alonso', 'nano@f1.com');
INSERT INTO conductor (nombre, email) VALUES ('Carlos Sainz', 'smoothoperator@f1.com');
INSERT INTO conductor (nombre, email) VALUES ('Max Verstappen', 'max@rb.com');
INSERT INTO conductor (nombre, email) VALUES ('Lewis Hamilton', 'lewis@mercedes.com');
INSERT INTO conductor (nombre, email) VALUES ('Antonio Lobato', 'alobato@tv.com');
INSERT INTO conductor (nombre, email) VALUES ('Pedro de la Rosa', 'pedro@daan.com');
INSERT INTO conductor (nombre, email) VALUES ('Nira Juanco', 'nira@f1.com');
INSERT INTO conductor (nombre, email) VALUES ('Melissa Jimenez', 'melissa@tv.com');
INSERT INTO conductor (nombre, email) VALUES ('Checo Perez', 'checo@rb.com');
INSERT INTO conductor (nombre, email) VALUES ('Lando Norris', 'lando@mclaren.com');
INSERT INTO conductor (nombre, email) VALUES ('Oscar Piastri', 'oscar@mclaren.com');
INSERT INTO conductor (nombre, email) VALUES ('George Russell', 'george@mercedes.com');

-- =================================================================================================
-- 3. INSERTAR VEHICULOS
-- Estados (Ordinal): 0 = DISPONIBLE, 1 = ASIGNADO, 2 = EN_MANTENIMIENTO
-- =================================================================================================

-- --- VEHÍCULOS DISPONIBLES (Estado 0) ---
INSERT INTO vehiculo (matricula, modelo, km_actuales, estado) VALUES ('1001-AAA', 'Toyota Corolla', 15000.0, 0);
INSERT INTO vehiculo (matricula, modelo, km_actuales, estado) VALUES ('1002-BBB', 'Renault Clio', 45000.0, 0);
INSERT INTO vehiculo (matricula, modelo, km_actuales, estado) VALUES ('1003-CCC', 'Citroen C3', 12000.0, 0);
INSERT INTO vehiculo (matricula, modelo, km_actuales, estado) VALUES ('1004-DDD', 'Peugeot 308', 8500.0, 0);
INSERT INTO vehiculo (matricula, modelo, km_actuales, estado) VALUES ('1005-EEE', 'Ford Fiesta', 62000.0, 0);
INSERT INTO vehiculo (matricula, modelo, km_actuales, estado) VALUES ('1006-FFF', 'Opel Corsa', 500.0, 0);

-- --- VEHÍCULOS ASIGNADOS (Estado 1) - Requieren asignación activa ---
INSERT INTO vehiculo (matricula, modelo, km_actuales, estado) VALUES ('2001-GGG', 'Ford Focus', 55000.0, 1);
INSERT INTO vehiculo (matricula, modelo, km_actuales, estado) VALUES ('2002-HHH', 'Seat Leon', 23000.0, 1);
INSERT INTO vehiculo (matricula, modelo, km_actuales, estado) VALUES ('2003-III', 'Volkswagen Golf', 90000.0, 1);
INSERT INTO vehiculo (matricula, modelo, km_actuales, estado) VALUES ('2004-JJJ', 'Toyota Yaris', 31000.0, 1);
INSERT INTO vehiculo (matricula, modelo, km_actuales, estado) VALUES ('2005-KKK', 'Hyundai i30', 15000.0, 1);

-- --- VEHÍCULOS EN MANTENIMIENTO (Estado 2) ---
INSERT INTO vehiculo (matricula, modelo, km_actuales, estado) VALUES ('3001-LLL', 'Seat Ibiza', 120000.0, 2);
INSERT INTO vehiculo (matricula, modelo, km_actuales, estado) VALUES ('3002-MMM', 'Renault Megane', 210000.0, 2);
INSERT INTO vehiculo (matricula, modelo, km_actuales, estado) VALUES ('3003-NNN', 'Fiat Tipo', 4000.0, 2);
INSERT INTO vehiculo (matricula, modelo, km_actuales, estado) VALUES ('3004-OOO', 'Kia Ceed', 35000.0, 2);

-- =================================================================================================
-- 4. INSERTAR ASIGNACIONES
-- =================================================================================================

-- --- Asignaciones Históricas (CERRADAS - fecha_fin NOT NULL) ---
-- El Toyota Corolla (1) lo tuvo Fernando Alonso hace un mes
INSERT INTO asignacion (fecha_inicio, fecha_fin, conductor_id, vehiculo_id) VALUES ('2023-01-01 09:00:00', '2023-01-15 18:00:00', 1, 1);

-- El Renault Clio (2) lo tuvo Carlos Sainz
INSERT INTO asignacion (fecha_inicio, fecha_fin, conductor_id, vehiculo_id) VALUES ('2023-02-01 08:00:00', '2023-02-05 20:00:00', 2, 2);

-- El Seat Ibiza (11 - ahora en taller) lo tuvo Max Verstappen antes de romperse
INSERT INTO asignacion (fecha_inicio, fecha_fin, conductor_id, vehiculo_id) VALUES ('2023-03-01 10:00:00', '2023-03-20 12:00:00', 3, 11);

-- El Ford Focus (7) tuvo un uso anterior por Lewis Hamilton
INSERT INTO asignacion (fecha_inicio, fecha_fin, conductor_id, vehiculo_id) VALUES ('2023-01-10 09:00:00', '2023-01-12 18:00:00', 4, 7);

-- --- Asignaciones ACTIVAS (ABIERTAS - fecha_fin NULL) ---
-- IMPORTANTE: Deben corresponder a los vehículos con Estado = 1 (ASIGNADO)
-- Vehículos IDs: 7, 8, 9, 10, 11 no (es el 11 el Ibiza roto), el 11 no puede tener activa.

-- Vehículo 7 (Ford Focus) asignado a Fernando Alonso (1)
INSERT INTO asignacion (fecha_inicio, fecha_fin, conductor_id, vehiculo_id) VALUES (CURRENT_TIMESTAMP, NULL, 1, 7);

-- Vehículo 8 (Seat Leon) asignado a Carlos Sainz (2)
INSERT INTO asignacion (fecha_inicio, fecha_fin, conductor_id, vehiculo_id) VALUES (CURRENT_TIMESTAMP, NULL, 2, 8);

-- Vehículo 9 (VW Golf) asignado a Lando Norris (10)
INSERT INTO asignacion (fecha_inicio, fecha_fin, conductor_id, vehiculo_id) VALUES ('2023-10-01 08:00:00', NULL, 10, 9);

-- Vehículo 10 (Toyota Yaris) asignado a Pedro de la Rosa (6)
INSERT INTO asignacion (fecha_inicio, fecha_fin, conductor_id, vehiculo_id) VALUES ('2023-11-15 09:30:00', NULL, 6, 10);

-- Vehículo 11 (Hyundai i30) asignado a Antonio Lobato (5) -> OJO, arriba el ID 11 era el Seat Ibiza. El Hyundai es ID 11 en la lista?
-- Corrijo IDs según orden de inserción:
-- 1-6: Disponibles
-- 7: Ford Focus (Asignado - OK)
-- 8: Seat Leon (Asignado - OK)
-- 9: VW Golf (Asignado - OK)
-- 10: Toyota Yaris (Asignado - OK)
-- 11: Hyundai i30 (Asignado - OK) -> Este es el 11 real.
-- 12: Seat Ibiza (En Mantenimiento)
-- 13: Renault Megane (En Mantenimiento)
-- 14: Fiat Tipo (En Mantenimiento)
-- 15: Kia Ceed (En Mantenimiento)

-- Asignación activa para Vehículo 11 (Hyundai i30) con Antonio Lobato (5)
INSERT INTO asignacion (fecha_inicio, fecha_fin, conductor_id, vehiculo_id) VALUES (CURRENT_TIMESTAMP, NULL, 5, 11);


-- =================================================================================================
-- 5. INSERTAR MANTENIMIENTOS
-- =================================================================================================

-- Historial Seat Ibiza (12) - Mantenimiento antiguo
INSERT INTO mantenimiento (tipo, fecha, km_en_revision, vehiculo_id, taller_id) VALUES ('Cambio de Aceite', '2022-06-01 10:00:00', 100000.0, 12, 1);
INSERT INTO mantenimiento (tipo, fecha, km_en_revision, vehiculo_id, taller_id) VALUES ('Cambio de Ruedas', '2023-01-15 11:30:00', 115000.0, 12, 2);

-- Historial Renault Megane (13) - Mantenimiento muy usado
INSERT INTO mantenimiento (tipo, fecha, km_en_revision, vehiculo_id, taller_id) VALUES ('Revisión Motor', '2021-12-01 09:00:00', 180000.0, 13, 3);
INSERT INTO mantenimiento (tipo, fecha, km_en_revision, vehiculo_id, taller_id) VALUES ('ITV', '2023-05-20 16:00:00', 205000.0, 13, 1);

-- Historial Toyota Corolla (1) - Revisión nueva
INSERT INTO mantenimiento (tipo, fecha, km_en_revision, vehiculo_id, taller_id) VALUES ('Revisión 15000km', '2023-09-10 08:00:00', 14900.0, 1, 4);

-- Historial Ford Focus (7)
INSERT INTO mantenimiento (tipo, fecha, km_en_revision, vehiculo_id, taller_id) VALUES ('Cambio Pastillas Freno', '2023-06-01 10:00:00', 45000.0, 7, 5);