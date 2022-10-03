use Donativa;

CREATE TABLE usuarios (
id_usuario int PRIMARY KEY NOT NULL AUTO_INCREMENT,
nome_usuario varchar(20),
email varchar(30),
senha varchar(12)
);

CREATE TABLE beneficiario (
id_beneficiario int PRIMARY KEY NOT NULL AUTO_INCREMENT,
nome_beneficiario varchar(30),
telefone_beneficiario int,
cpf_beneficiario int,
rg_beneficiario int,
data_nascimento_beneficiario Date,
genero_beneficiario varchar(30),
aceite_de_termos_beneficiario boolean,
id_usuario int,
FOREIGN KEY(id_usuario) REFERENCES usuarios (id_usuario)
);

CREATE TABLE doador (
id_doador int PRIMARY KEY NOT NULL AUTO_INCREMENT,
nome_doador varchar(30),
telefone_doador varchar(12),
cpf_doador int,
cnpj_doador int,
rg_doador int,
genero_doador varchar(10),
data_nascimento_doador date,
aceite_termos_doador boolean,
id_usuario int,
FOREIGN KEY(id_usuario) REFERENCES usuarios (id_usuario)
);

CREATE TABLE administrador  (
id_adm int PRIMARY KEY NOT NULL AUTO_INCREMENT,
nome_adm varchar(30),
id_usuario int,
FOREIGN KEY(id_usuario) REFERENCES usuarios (id_usuario)
);

CREATE TABLE permissoes (
id_permissoes int PRIMARY KEY NOT NULL AUTO_INCREMENT,
tipoPermissão boolean
);

CREATE TABLE doacao (
id_doacao int PRIMARY KEY NOT NULL AUTO_INCREMENT,
nome_doador varchar(30),
num_pedido int,
data_doacao date
);

CREATE TABLE pedido_beneficiario (
id_pedido int PRIMARY KEY NOT NULL AUTO_INCREMENT,
num_pedido int,
data_pedido date,
quantidade_itens int,
id_beneficiario int,
FOREIGN KEY (id_beneficiario) REFERENCES Beneficiario (id_beneficiario)
);

CREATE TABLE endereco (
id_endereco int PRIMARY KEY NOT NULL AUTO_INCREMENT,
rua varchar(30),
numero int,
cep int,
bairro varchar(30),
cidade varchar(30),
estado varchar(30),
id_beneficiario int,
FOREIGN KEY (id_beneficiario) REFERENCES Beneficiario (id_beneficiario)
);
