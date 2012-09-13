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
insert into menu_usuario values(id, 'Home', 'goHome.do', 'PADRAO', 1);
insert into menu_usuario values(id, 'Estatisticas', '#', 'PADRAO', 2);

/* Menu medico */
insert into menu_usuario values(id, 'Home', 'goHome.do', 'MEDICO', 1);
insert into menu_usuario values(id, 'Estatisticas', '#', 'MEDICO', 2);
insert into menu_usuario values(id, 'Gerenciar Dietas', '#', 'MEDICO', 3);

/* Menu adm */
insert into menu_usuario values(id, 'Home', 'goHome.do', 'ADMIN', 1);
insert into menu_usuario values(id, 'Estatisticas', '#', 'ADMIN', 2);
insert into menu_usuario values(id, 'Gerenciar Registros', '/SiteDieta/gerenciamento', 'ADMIN', 3);
