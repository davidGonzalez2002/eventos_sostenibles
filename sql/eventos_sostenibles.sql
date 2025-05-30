CREATE DATABASE IF NOT EXISTS eventos_sostenibles;
USE eventos_sostenibles;


CREATE TABLE cuentas(
    id INT PRIMARY KEY,
    nombre VARCHAR(200) NOT NULL,
    clave_acceso VARCHAR(50) NOT NULL,
    email VARCHAR(200) NOT NULL,
    tipo ENUM('USUARIO','ORGANIZADOR') NOT NULL
)ENGINE=INNODB;

CREATE TABLE usuarios(
    id INT PRIMARY KEY,
    usuario VARCHAR(100) UNIQUE NOT NULL, -- Es el usuario, por tanto no se repite

    CONSTRAINT fk_usuarios_cuentas FOREIGN KEY(id)
    REFERENCES cuentas(id)
)ENGINE=INNODB;

CREATE TABLE organizadores(
    id INT PRIMARY KEY,
    razon_social VARCHAR(200), -- Por si queremos guardar la razon_social de la empresa
    telefono VARCHAR(12) NOT NULL,

    CONSTRAINT fk_organizadores_cuentas FOREIGN KEY(id) 
    REFERENCES cuentas(id)
)ENGINE=INNODB;

CREATE TABLE clasificaciones(
    id INT PRIMARY KEY,
    categoria VARCHAR(50) NOT NULL
)ENGINE=INNODB;

CREATE TABLE ubicaciones(
    id INT PRIMARY KEY,
    direccion VARCHAR(100),
    enlace VARCHAR(100)
)ENGINE=INNODB;

CREATE TABLE eventos(
    id INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    fecha DATE NOT NULL,
    duracion DECIMAL(3,1), -- duracion en horas, por ejemplo 2 horas o 1.5 horas o 72 horas
    estado ENUM('PENDIENTE','CANCELADO','EN CURSO'), -- Estado del evento, si se ha cancelado, si todavia no es o si esta en curso
    organizador INT NOT NULL,
    clasificacion INT NOT NULL,
    ubicacion INT NOT NULL,

    CONSTRAINT fk_eventos_organizadores FOREIGN KEY(organizador) -- Declarado de esta forma para darle un nombre y que sea más fácil de administrar
    REFERENCES organizadores(id),
    CONSTRAINT fk_eventos_clasificaciones FOREIGN KEY(clasificacion)
    REFERENCES clasificaciones(id),
    CONSTRAINT fk_eventos_ubicaciones FOREIGN KEY(ubicacion)
    REFERENCES ubicaciones(id)
)ENGINE=INNODB;

CREATE TABLE inscripciones(
    id_usuario INT,
    id_evento INT,
    activo BIT DEFAULT 1, -- Si esta activo 1, 0 si se ha cancelado la inscripcion. almaceno la inscripcion porque alomejor interesa saber cosas como cuantos han cancelado
    PRIMARY KEY(id_usuario,id_evento),
    
    CONSTRAINT fk_inscripciones_usuarios FOREIGN KEY(id_usuario)
    REFERENCES usuarios(id),
    CONSTRAINT fk_inscripciones_eventos FOREIGN KEY(id_evento)
    REFERENCES eventos(id)
) ENGINE=INNODB;