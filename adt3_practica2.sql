DROP DATABASE IF EXISTS adt3_practica2;

CREATE DATABASE adt3_practica2;

USE adt3_practica2;

CREATE TABLE alumno(
    idAlumno		INT NOT NULL AUTO_INCREMENT,
    nombre 			VARCHAR(50),
    apellido 		VARCHAR(100),
    dni				VARCHAR(10),
    fechaNacimiento DATE,
    PRIMARY KEY(idAlumno)
);

CREATE TABLE curso(
    idCurso		    INT NOT NULL AUTO_INCREMENT,
    nombre          VARCHAR(50),
    PRIMARY KEY(idCurso)
);

CREATE TABLE asignatura(
    idAsignatura			INT NOT NULL AUTO_INCREMENT,
    nombre 					VARCHAR(100),
    numeroHorasSemanales 	INT,
    idCurso					INT,
    PRIMARY KEY(idAsignatura),
    FOREIGN KEY (idCurso) REFERENCES curso(idCurso) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE alumno_asignatura(
    idAlumno		INT NOT NULL,
    idAsignatura	INT NOT NULL,
    PRIMARY KEY (idAlumno, idAsignatura),
    FOREIGN KEY (idAlumno) REFERENCES alumno(idAlumno) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (idAsignatura) REFERENCES asignatura(idAsignatura) ON DELETE CASCADE ON UPDATE CASCADE
);


INSERT INTO curso(nombre) VALUES ('1Âº DAM');
INSERT INTO curso(nombre) VALUES ('2Âº DAM');
INSERT INTO curso(nombre) VALUES ('1Âº ASIR');
INSERT INTO curso(nombre) VALUES ('2Âº ASIR');
INSERT INTO curso(nombre) VALUES ('1Âº DAW');
INSERT INTO curso(nombre) VALUES ('2Âº DAW');
COMMIT;

INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('PlanificaciÃ³n y administraciÃ³n de redes.',3,6);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('ImplantaciÃ³n de sistemas operativos.',3,7);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('Fundamentos de hardware.',3,3);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('GestiÃ³n de bases de datos.',3,5);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('Lenguajes de marcas y sistemas de gestiÃ³n de informaciÃ³n.',3,3);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('FormaciÃ³n y orientaciÃ³n laboral.',3,3);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('Horario reservado para el mÃ³dulo impartido en inglÃ©s.',3,3);
COMMIT;

INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('AdministraciÃ³n de sistemas operativos.',4,6);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('Servicios de red e Internet.',4,6);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('ImplantaciÃ³n de aplicaciones web.',4,5);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('AdministraciÃ³n de sistemas gestores de bases de datos.',4,3);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('Seguridad y alta disponibilidad.',4,5);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('Empresa e iniciativa emprendedora.',4,3);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('Proyecto de administraciÃ³n de sistemas informÃ¡ticos en red.',4,40);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('Horario reservado para el mÃ³dulo impartido en inglÃ©s.',4,2);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('FormaciÃ³n en Centros de Trabajo.',4,400);
COMMIT;

INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('Lenguajes de marcas y sistemas de gestiÃ³n de informaciÃ³n.',5,3);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('Sistemas informÃ¡ticos.',5,5);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('Bases de datos.',5,5);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('ProgramaciÃ³n.',5,8);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('Entornos de desarrollo.',5,3);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('FormaciÃ³n y orientaciÃ³n laboral.',5,3);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('Horario reservado para el mÃ³dulo impartido en inglÃ©s.',5,3);
COMMIT;

INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('Desarrollo web en entorno cliente.',6,7);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('Desarrollo web en entorno servidor.',6,8);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('Despliegue de aplicaciones web.',6,4);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('DiseÃ±o de interfaces web.',6,6);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('Proyecto de Desarrollo de aplicaciones web.',6,40);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('Empresa e iniciativa emprendedora.',6,3);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('Horario reservado para el mÃ³dulo impartido en inglÃ©s.',6,2);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('FormaciÃ³n en Centros de Trabajo.',6,400);
COMMIT;

INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('Lenguajes de marcas y sistemas de gestiÃ³n de informaciÃ³n.',1,3);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('Sistemas informÃ¡ticos.',1,5);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('Bases de Datos.',1,5);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('ProgramaciÃ³n.',1,8);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('Entornos de desarrollo.',1,3);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('FormaciÃ³n y OrientaciÃ³n Laboral.',1,3);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('Horario reservado para el mÃ³dulo impartido en inglÃ©s.',1,3);
COMMIT;

INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('Acceso a datos.',2,6);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('Desarrollo de interfaces.',2,6);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('ProgramaciÃ³n multimedia y dispositivos mÃ³viles.',2,5);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('ProgramaciÃ³n de servicios y procesos.',2,3);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('Sistemas de gestiÃ³n empresarial.',2,5);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('Empresa e iniciativa emprendedora.',2,3);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('Proyecto de Desarrollo de aplicaciones multiplataforma.',2,40);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('Horario reservado para el mÃ³dulo impartido en inglÃ©s.',2,2);
INSERT INTO asignatura(nombre,idCurso,numeroHorasSemanales) VALUES ('FormaciÃ³n en Centros de Trabajo.',2,400);
COMMIT;

INSERT INTO alumno(nombre,apellido,dni,fechanacimiento) VALUES ('Pedro','Inostroza','27100220A','1970-05-01');
INSERT INTO alumno(nombre,apellido,dni,fechanacimiento) VALUES ('Juan','Marchant','22100120B','1971-10-02');
INSERT INTO alumno(nombre,apellido,dni,fechanacimiento) VALUES ('Pamela','Aguirre','03100114C','1972-03-15');
INSERT INTO alumno(nombre,apellido,dni,fechanacimiento) VALUES ('MÃ³nica','Villanueva','22002201D','1973-04-20');
INSERT INTO alumno(nombre,apellido,dni,fechanacimiento) VALUES ('Ignacio','Madariaga','23100222E','1970-05-25');
INSERT INTO alumno(nombre,apellido,dni,fechanacimiento) VALUES ('Camilo','ZuÃ±iga','21112014F','1971-06-03');
INSERT INTO alumno(nombre,apellido,dni,fechanacimiento) VALUES ('Alejandro','Zurita','25072935G','1972-01-06');
INSERT INTO alumno(nombre,apellido,dni,fechanacimiento) VALUES ('Fernando','Condeza','10012012H','1973-02-09');
INSERT INTO alumno(nombre,apellido,dni,fechanacimiento) VALUES ('AndrÃ©s','Poblete','26201496I','1980-07-12');
INSERT INTO alumno(nombre,apellido,dni,fechanacimiento) VALUES ('Yilun','HernÃ¡ndez','29220123J','1981-08-15');
INSERT INTO alumno(nombre,apellido,dni,fechanacimiento) VALUES ('AndrÃ©s','Pasten','17000201K','1982-09-18');
INSERT INTO alumno(nombre,apellido,dni,fechanacimiento) VALUES ('AndrÃ©s','Mella','27100121L','1983-10-21');
INSERT INTO alumno(nombre,apellido,dni,fechanacimiento) VALUES ('Alejandro','Bustos','29002013M','1976-11-24');
INSERT INTO alumno(nombre,apellido,dni,fechanacimiento) VALUES ('Andrea','MuÃ±oz','18102204N','1977-12-27');
INSERT INTO alumno(nombre,apellido,dni,fechanacimiento) VALUES ('Ignacio','Rojas','17475289O','1978-12-31');
COMMIT;

INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (1,1);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (1,2);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (1,3);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (1,4);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (2,1);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (2,2);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (2,3);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (3,9);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (3,10);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (3,11);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (4,18);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (4,19);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (4,20);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (4,21);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (5,19);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (5,20);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (5,21);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (6,18);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (6,19);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (6,20);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (6,21);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (7,25);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (7,26);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (7,27);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (7,28);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (8,25);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (8,27);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (9,27);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (9,28);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (10,29);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (10,30);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (10,31);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (11,29);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (11,30);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (12,34);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (12,35);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (12,36);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (12,37);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (13,40);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (13,41);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (13,42);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (13,43);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (14,40);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (14,41);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (14,42);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (14,43);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (15,44);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (15,45);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (15,46);
INSERT INTO alumno_asignatura(idAlumno, idAsignatura) VALUES (15,47);
COMMIT;


/**********************************************/
/********** EXEMPLES PROCEDIMENTS  ************/
/**********************************************/
DELIMITER //

CREATE PROCEDURE matricular1 (p_idAlumno INT, p_idAsignatura INT)
BEGIN
	DECLARE numeroRegistrosAlumno INT;
	DECLARE numeroRegistrosAsignatura INT;
	DECLARE numeroRegistros INT;

    SELECT COUNT(*) INTO numeroRegistrosAlumno
    FROM alumno
    WHERE idAlumno=p_idAlumno;

    SELECT COUNT(*) INTO numeroRegistrosAsignatura
    FROM asignatura
    WHERE idAsignatura=p_idAsignatura;

    SELECT COUNT(*) INTO numeroRegistros
    FROM alumno_asignatura
    WHERE idAlumno=p_idAlumno AND idAsignatura=p_idAsignatura;

    IF ((numeroRegistrosAlumno=1) AND (numeroRegistrosAsignatura=1) AND (numeroRegistros=0)) THEN
        BEGIN
            INSERT INTO alumno_asignatura(idalumno,idasignatura) VALUES(p_idAlumno,p_idAsignatura);
        END;
    END IF;

END;
//



CREATE PROCEDURE matricular2 (p_idAlumno INT, p_idAsignatura INT, OUT p_salida INT)
BEGIN
	DECLARE numeroRegistros INT;

    SELECT COUNT(*) INTO numeroRegistros
    FROM alumno_asignatura
    WHERE idAlumno=p_idAlumno AND idAsignatura=p_idAsignatura;

    IF (numeroRegistros>0) THEN
        BEGIN
            SET p_salida=1;
        END;
    ELSE
        BEGIN
            SET p_salida=0;
            INSERT INTO alumno_asignatura(idalumno,idasignatura) VALUES(p_idAlumno,p_idAsignatura);
        END;
    END IF;
END;
//

CREATE PROCEDURE matricular3 (p1 INT, p2 INT, OUT p3 INT)
proc: BEGIN

	DECLARE existeAlumno INT default 0;
	DECLARE existeAsignatura INT default 0;
	DECLARE existeMatricula INT default 0;

    SELECT COUNT(*) INTO existeAlumno
    FROM alumno
    WHERE idAlumno = p1;

    IF (existeAlumno = 0) THEN
	        SET p3 = 1;
            LEAVE proc;
    END IF;

    SELECT COUNT(*) INTO existeAsignatura
    FROM asignatura
    WHERE idAsignatura = p2;

    IF (existeMatricula = 0) THEN
	        SET p3 = 2;
            LEAVE proc;
    END IF;

    SELECT COUNT(*) INTO existeMatricula
    FROM alumno_asignatura
    WHERE idAlumno = p1 AND idAsignatura = p2;

    IF (existeMatricula > 0) THEN
            SET p3 = 3;
            LEAVE proc;
    END IF;

    INSERT INTO alumno_asignatura(idAlumno, idAsignatura)
    VALUES (p1, p2);
	
    SET p3 = 0;
END proc;
//

DELIMITER ;