drop database if exists Banca;
create database Banca;
use Banca;

-- creazione tabelle e popolamento

create table Clienti (
    Codice char(10) not null primary key,
    Nome varchar(50) not null,
    Cognome varchar(50) not null,
    Telefono varchar(10), 
    Mail varchar(50), 
    Indirizzo varchar(100) not null
);

insert into Clienti values
    ('1001000001','Nome1','Cognome1','Tel1','Mail1','Indirizzo1'),
    ('1001000002','Nome2','Cognome2','Tel2',null,'Indirizzo2'),
    ('1001000003','Nome3','Cognome3',null,'Mail3','Indirizzo3');

create table ContiCorrenti (
    Codice char(10) not null primary key,
    Saldo decimal(10,2) not null
);

insert into ContiCorrenti values
    ('1111100001',3456.78),
    ('1111100002',1234.89),
    ('1111100003',1589.32);

create table ClientiContiCorrenti (
    CodiceCliente char(10) not null references Clienti(Codice),
    CodiceConto char(10) not null references ContiCorrenti(Codice),
    primary key (CodiceCliente,CodiceConto)
);

insert into ClientiContiCorrenti values
    ('1001000001','1111100001'),
    ('1001000002','1111100002'),
    ('1001000003','1111100003');

create table Movimenti (
    Progressivo int not null primary key auto_increment,
    Versamento bool not null, 
    Importo decimal(6,2) not null,
    Data date not null,
    CodiceConto varchar(10) not null references ContiCorrenti(Codice)
);

insert into Movimenti (Versamento,Importo,Data,CodiceConto) values
    (1,123.45,'2022-10-11','1111100001'),
    (1,123.45,'2022-10-12','1111100001'),
    (0,123.45,'2022-10-13','1111100001'),
    (0,123.45,'2022-11-12','1111100001'),
    (0,123.45,'2022-11-14','1111100001'),
    (1,122.45,'2022-11-15','1111100001'),
    (1,123.45,'2022-12-12','1111100001'),
    (0,133.45,'2022-12-13','1111100001'),
    (0,123.45,'2022-12-14','1111100001'),
    (0,123.45,'2022-12-15','1111100001'),
    (1,123.45,'2023-01-11','1111100001'),
    (1,173.45,'2023-01-12','1111100001'),
    (0,123.45,'2023-01-13','1111100001'),
    (0,123.45,'2023-10-14','1111100001'),
    (0,123.45,'2023-01-15','1111100001'),
    (1,123.45,'2022-10-11','1111100002'),
    (1,123.45,'2022-10-12','1111100002'),
    (0,123.45,'2022-10-13','1111100002'),
    (0,123.45,'2022-11-12','1111100002'),
    (0,123.45,'2022-11-14','1111100002'),
    (1,122.45,'2022-11-15','1111100002'),
    (1,123.45,'2022-12-12','1111100002'),
    (0,133.45,'2022-12-13','1111100002'),
    (0,123.45,'2022-12-14','1111100002'),
    (0,123.45,'2022-12-15','1111100002'),
    (1,123.45,'2023-01-11','1111100002'),
    (1,173.45,'2023-01-12','1111100002'),
    (0,123.45,'2023-01-13','1111100002'),
    (0,123.45,'2023-10-14','1111100002'),
    (0,123.45,'2023-01-15','1111100002'),
    (1,123.45,'2022-10-11','1111100003'),
    (1,123.45,'2022-10-12','1111100003'),
    (0,123.45,'2022-10-13','1111100003'),
    (0,123.45,'2022-11-12','1111100003'),
    (0,123.45,'2022-11-14','1111100003'),
    (1,122.45,'2022-11-15','1111100003'),
    (1,123.45,'2022-12-12','1111100003'),
    (0,133.45,'2022-12-13','1111100003'),
    (0,123.45,'2022-12-14','1111100003'),
    (0,123.45,'2022-12-15','1111100003'),
    (1,123.45,'2023-01-11','1111100003'),
    (1,173.45,'2023-01-12','1111100003'),
    (0,123.45,'2023-01-13','1111100003'),
    (0,123.45,'2023-10-14','1111100003'),
    (0,123.45,'2023-01-15','1111100003');

create table Utenti (
    Username char(10) not null primary key,
    Pass varchar(10) not null,
    CodiceCliente varchar(10) not null references Clienti(Codice)
);

insert into Utenti values 
    ('Username01','Pass1','1001000001'),
    ('Username02','Pass2','1001000002'),
    ('Username03','Pass3','1001000003');
