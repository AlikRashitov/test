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
 ("���������",	true,	15),
("����������� �����	",true	,10),
("�������� �����",	false,	6),
("HDD ����",	false,	7),
("SSD",	true,	7),
("����������",	false,	10),
("������",	true,	20),
("����������� ������",	true,	20),
("��������� �������",	false,	100),
("������� �����",	false,	35),
("USB-����������",	false,	10),
("���� �������",	false,	20),
("SATA-����������",	false,	15),
("������ DVD-RW",	false,	20),
("���������� ������������",	false,	17),
("���������� ��� ����������",	true,	39),
("���������� ��� ��������",	false,	30),
("���������",	false,	50),
("�������",	false,	20),
("����",	false,	30),
("����������",	false,	40);
