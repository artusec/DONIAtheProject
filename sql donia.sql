// version 13-5-2018 13:05
// ESTO ES UN SCRIPT PARA INICIALIZAR LA DB DE DONIA
// borjawer (en linux y mac funciona, en win deberia)

//crear db donia, conectarse y crear usuario usr con clave usr

DROP TABLE `rusuariogenero`;
DROP TABLE `rlistacancion`;
DROP TABLE `cancion`;
DROP TABLE `video`;
DROP TABLE `letra`;
DROP TABLE `biblioteca`;
DROP TABLE `listaauto`;
DROP TABLE `genero`;
DROP TABLE `listanormal`;
DROP TABLE `lista`;
DROP TABLE `usuarioadmin`;
DROP TABLE `usuario`;

CREATE TABLE `usuario` (
  `usuario` varchar(100) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `clave` varchar(100) NOT NULL,
  PRIMARY KEY (`usuario`)
);

CREATE TABLE `usuarioadmin` (
  `usuario` varchar(100) NOT NULL,
  PRIMARY KEY (`usuario`),
  CONSTRAINT `usuarioadmin_usuario_FK` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE TABLE `lista` (
  `lista` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`lista`)
) ;

CREATE TABLE `listanormal` (
  `lista` varchar(100) NOT NULL,
  `usuario` varchar(100) NOT NULL,
  PRIMARY KEY (`lista`),
  KEY `listanormal_usuario_FK` (`usuario`),
  CONSTRAINT `listanormal_lista_FK` FOREIGN KEY (`lista`) REFERENCES `lista` (`lista`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `listanormal_usuario_FK` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE TABLE `genero` (
  `genero` varchar(100) NOT NULL,
  PRIMARY KEY (`genero`)
)

CREATE TABLE `listaauto` (
  `lista` varchar(100) NOT NULL,
  `genero` varchar(100) NOT NULL,
  PRIMARY KEY (`lista`),
  KEY `listaauto_genero_FK` (`genero`),
  CONSTRAINT `listaauto_genero_FK` FOREIGN KEY (`genero`) REFERENCES `genero` (`genero`),
  CONSTRAINT `listaauto_listanormal_FK` FOREIGN KEY (`lista`) REFERENCES `listanormal` (`lista`) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE TABLE `biblioteca` (
  `lista` varchar(100) NOT NULL,
  PRIMARY KEY (`lista`),
  CONSTRAINT `biblioteca_lista_FK` FOREIGN KEY (`lista`) REFERENCES `lista` (`lista`)
) ;

CREATE TABLE `letra` (
  `texto` text NOT NULL,
  `letra` varchar(100) NOT NULL,
  PRIMARY KEY (`letra`)
) ;

CREATE TABLE `video` (
  `enlace` varchar(100) NOT NULL,
  `enlaceDescarga` varchar(100) DEFAULT NULL,
  `video` varchar(100) NOT NULL,
  PRIMARY KEY (`video`)
) ;

CREATE TABLE `cancion` (
  `cancion` varchar(100) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `autor` varchar(100) DEFAULT NULL,
  `duracion` int(10) unsigned DEFAULT NULL,
  `album` varchar(100) DEFAULT NULL,
  `genero` varchar(100) DEFAULT NULL,
  `video` varchar(100) DEFAULT NULL,
  `letra` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cancion`),
  KEY `cancion_letra_FK` (`letra`),
  KEY `cancion_video_FK` (`video`),
  KEY `cancion_genero_FK` (`genero`),
  CONSTRAINT `cancion_genero_FK` FOREIGN KEY (`genero`) REFERENCES `genero` (`genero`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `cancion_letra_FK` FOREIGN KEY (`letra`) REFERENCES `letra` (`letra`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `cancion_video_FK` FOREIGN KEY (`video`) REFERENCES `video` (`video`) ON DELETE SET NULL ON UPDATE CASCADE
) ;

CREATE TABLE `rlistacancion` (
  `lista` varchar(100) NOT NULL,
  `cancion` varchar(100) NOT NULL,
  PRIMARY KEY (`lista`,`cancion`),
  KEY `rlistacancion_cancion_FK` (`cancion`),
  CONSTRAINT `rlistacancion_cancion_FK` FOREIGN KEY (`cancion`) REFERENCES `cancion` (`cancion`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `rlistacancion_lista_FK` FOREIGN KEY (`lista`) REFERENCES `lista` (`lista`) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE TABLE `rusuariogenero` (
  `usuario` varchar(100) NOT NULL,
  `genero` varchar(100) NOT NULL,
  PRIMARY KEY (`usuario`,`genero`),
  KEY `rusuariogenero_genero_FK` (`genero`),
  CONSTRAINT `rusuariogenero_genero_FK` FOREIGN KEY (`genero`) REFERENCES `genero` (`genero`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `rusuariogenero_usuario_FK` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ;

GRANT SELECT, INSERT, UPDATE, DELETE ON donia.* TO 'usr'@'localhost';
GRANT ALL PRIVILEGES ON donia.* TO 'usr'@'%' WITH GRANT OPTION; //por si acaso

INSERT INTO donia.lista
(lista, nombre)
VALUES('l0', 'biblioteca');

INSERT INTO donia.biblioteca
(lista)
VALUES('l0');

INSERT INTO donia.usuario
(usuario, nombre, clave)
VALUES('u0', 'admin', 'u0');

INSERT INTO donia.usuarioadmin
(usuario)
VALUES('u0');
