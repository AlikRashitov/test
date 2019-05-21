USE parts;
CREATE TABLE computers
(
  id int(10) PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  countt int(4),
  needed BIT DEFAULT false  NOT NULL
)
COLLATE='utf8_general_ci';
CREATE UNIQUE INDEX computers_name_uindex ON computers (name);
INSERT INTO `computers` (`name`,needed, `countt`)
VALUES
 ("Процессор",	true,	15),
("Материнская плата	",true	,10),
("Звуковая карта",	false,	6),
("HDD диск",	false,	7),
("SSD",	true,	7),
("Видеокарта",	false,	10),
("Корпус",	true,	20),
("Оперативная память",	true,	20),
("Подсветка корпуса",	false,	100),
("Сетевая карта",	false,	35),
("USB-контроллер",	false,	10),
("Блок питания",	false,	20),
("SATA-контроллер",	false,	15),
("Привод DVD-RW",	false,	20),
("Устройство видеозахвата",	false,	17),
("Вентилятор для процесоров",	true,	39),
("Вентилятор для корпусов",	false,	30),
("Термоклей",	false,	50),
("Монитор",	false,	20),
("Мышь",	false,	30),
("Клавиатура",	false,	40);
