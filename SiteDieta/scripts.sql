create database site;

drop table if exists site.usuario;
create table site.usuario(
id bigint(20) NOT NUll AUTO_INCREMENT,
login varchar(20) NOT NULL,
senha varchar(255) NOT NULL,
tipo varchar(20) NOT NULL,
cad_medico_id bigint(20) DEFAULT NULL,
PRIMARY KEY (id), 
UNIQUE KEY (login));

/* Inserindo usuario administrador do sistema */
insert into site.usuario values(id,'paulo.santos', '123Mudar', 'ADMIN', null);


drop table if exists site.menu_usuario;
create table site.menu_usuario(
id bigint(20) NOT NUll AUTO_INCREMENT,
nome_menu varchar(100) NOT NULL,
caminho varchar(255) NOT NULL, 
tipo_usuario varchar(20) NOT NULL,
posicao bigint(2) NOT NULL, 
PRIMARY KEY (id), 
UNIQUE KEY (nome_menu, tipo_usuario));

drop table if exists site.cadastro_medico;
create table site.cadastro_medico(
id bigint(20) NOT NUll AUTO_INCREMENT,
nome varchar(255) NOT NULL,
numero_cpf varchar(20) NOT NULL,
numero_registro varchar(20) NOT NULL,
tipo_registro varchar(10) NOT NULL,
endereco_consultorio varchar(255),
numero_consultorio varchar(10),
bairro_consultorio varchar(100),
cidade_consultorio varchar(100),
estado_consultorio varchar(2),
cnpj_consultorio varchar(20),
status varchar(20) NOT NULL,
PRIMARY KEY (id));

/* Menu geral */
insert into site.menu_usuario values(id, 'Home', '/SiteDieta/goHome.do', 'PADRAO', 1);
insert into site.menu_usuario values(id, 'Estatisticas', '#', 'PADRAO', 2);

/* Menu medico */
insert into site.menu_usuario values(id, 'Home', '/SiteDieta/goHome.do', 'MEDICO', 1);
insert into site.menu_usuario values(id, 'Estatisticas', '#', 'MEDICO', 2);

/* Menu adm */
insert into site.menu_usuario values(id, 'Home', '/SiteDieta/goHome.do', 'ADMIN', 1);
insert into site.menu_usuario values(id, 'Estatisticas', '#', 'ADMIN', 2);
insert into site.menu_usuario values(id, 'Gerenciar Registros', '/SiteDieta/gerenciamento', 'ADMIN', 3);

/* Tabela Nutricional dos Alimentos */
drop table if exists site.tabela_nutricional;
create table site.tabela_nutricional ( 
id_alimento bigint(20) not null auto_increment ,
descricao varchar (80) not null,
kilocaloria int (10) null,
kilojoule int (10) null,
proteina_grama decimal (10,4)  null,
lipideos_grama decimal (10,4)  null,
colesterol_miligrama decimal (10,4)  null,
carboidrato_grama decimal(10,4) null,
fibraAlimentar_grama decimal (10,4)  null,
calcio_miligrama decimal (10,4)  null,
magnesio_miligrama decimal(10,4) null,
fosforo_miligrama decimal (10,4)  null,
ferro_miligrama decimal (10,4)  null,
sodio_miligrama decimal (10,4)  null,
potassio_miligrama decimal (10,4)  null,
zinco_miligrama decimal (10,4)  null,
vitaminaC_miligrama decimal (10,4) default null,
primary key (id_alimento)
);

/* Tabela das Dieta Cadastradas */
drop table if exists site.dieta;
create table site.dieta ( 
id_dieta bigint(20) not null auto_increment,
id_cadastro_medico bigint (20) not null,
nome_dieta varchar (50) not  null unique,
periodo_dieta int not null,
primary key (id_dieta)
);

/* Tabela das Refeições */
drop table if exists site.refeicao;
create table site.refeicao( 
id_refeicao bigint(20) not null auto_increment,
id_dieta bigint (20) not null,
horario time not  null,
opcao_refeicao varchar(20) not null,
primary key (id_refeicao),
FOREIGN KEY (id_dieta) REFERENCES dieta (id_dieta)
);

/* Tabela dos Alimentos das Refeições */
drop table if exists site.alimento;
create table site.alimento( 
id_alimento bigint(20) not null auto_increment,
id_refeicao bigint (20) not null,
alimento varchar(120) not  null,
quantidade int null,
unidade_de_medida varchar(30) null,
primary key (id_alimento),
FOREIGN KEY (id_refeicao) REFERENCES refeicao (id_refeicao)
);

/* Comando para Popular Tabela "tabela_nutricional" com arquivo .csm */
LOAD DATA INFILE 'C:\MySQL\MySQLServer55\data\Tabela.csv' 
INTO TABLE tabela_nutricional
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\n';

create database mobile;

/* Tabela das Refeições */
drop table if exists mobile.download_dieta;
create table mobile.download_dieta( 
id bigint(20) not null auto_increment,
id_imei bigint (20) not null,
data_solicitacao datetime not  null,
data_ultima_atualizacao datetime not null,
nome varchar (80) not null,
idade int (10) not null,
genero varchar (20) not null,
altura double (3, 2) not null,
peso   double (5, 2) not null,
email varchar (40) null,
status_dieta varchar(20) not null, 
primary key (id,id_imei)
);
